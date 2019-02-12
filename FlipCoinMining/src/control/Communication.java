package control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import entity.Consts;
import entity.Transaction;
import utils.E_Type;

/**
 * This class represents the communication between the systems (Transfer & Mining)
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Communication {
	
	public static boolean exportToXML() {
		try {
			Document doc = new Document();
			doc.setRootElement(new Element("Transactions"));
			
			File file = new File(Consts.XML_EXPORT_FILE_PATH);
			file.getParentFile().mkdirs();
			if (!file.exists())
				file.createNewFile();
			
			ArrayList<Transaction> trans = tra
			
			for (Transaction t : trans) {
				Element element = new Element("Transaction");
				element.setAttribute("ID", String.valueOf(t.getID()));
				element.setAttribute("size", String.valueOf(t.getSize()));
				element.setAttribute("Type", (t.getType() == null ? "" : t.getType().toString()));
				element.setAttribute("ComissionFee", String.valueOf(t.getCommissionFee()));
				element.setAttribute("BlockUniqueAddress", (t.getBlockUniqueAddress() == null ? "" : t.getBlockUniqueAddress()));
				element.setAttribute("TransactionDate", (t.getTransDate() == null ? "" : t.getTransDate().toString()));
				
				doc.getRootElement().addContent(element);
			}
			
			XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
			xmlOutputter.output(doc, new FileOutputStream(file));
			
			System.out.println("Exported To XML XDXD");
			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean importFromJSON() {
		try {
			File file = new File(Consts.JSON_IMPORT_FILE_PATH);
			if (!file.exists())
				return false;
			
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(new FileReader(file));
			JSONObject rootObject = (JSONObject) obj;
			
			JSONArray jsonTrans = (JSONArray) rootObject.get("Transactions");
			
			ArrayList<Transaction> trans = new ArrayList<>();
			
			for (Object objT : jsonTrans) {
				JSONObject jsonT = (JSONObject) objT;
				Integer ID = Integer.parseInt(String.valueOf(jsonT.get("ID")));
				Integer size = Integer.parseInt(String.valueOf(jsonT.get("Size")));
				Double comissionFee = Double.parseDouble(String.valueOf(jsonT.get("Comission Fee")));
				E_Type type = E_Type.getType(String.valueOf(jsonT.get("Type")));
				
				Transaction transaction = new Transaction(null,
														size,
														type,
														comissionFee,
														null,
														null);
				
				trans.add(transaction);
			}
			
			//Add to DB instead of printing.
			sysData.insertNewTransactions(trans);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
