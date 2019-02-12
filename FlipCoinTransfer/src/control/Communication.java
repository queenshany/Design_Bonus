package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import entity.Consts;
import entity.SystemParams;
import entity.Transaction;
import entity.TransactionConfirm;
import entity.TransactionPay;
import utils.E_Status;
import utils.E_TransType;

/**
 * This class represents the communication between the systems (Transfer & Mining)
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Communication {

	private static Communication instance;

	public static Communication getInstance() {
		if (instance == null)
			instance = new Communication();
		return instance;
	}
	/**
	 * exporting pending transactions to JSON
	 */
	public void exportTransactionsToJSON() {
		try {
			File file = new File(Consts.JSON_EXPORT_FILE_PATH);
			file.getParentFile().mkdirs();
			if (!file.exists())
				file.createNewFile();

			ArrayList<TransactionPay> trP = TransLogic.getInstance().getAllPayTrans();
			ArrayList<TransactionConfirm> trC = TransLogic.getInstance().getAllConfirmTrans();
			JsonObject rootObject = new JsonObject();
			JsonArray transJSON = new JsonArray();


			for (TransactionPay t : trP) {
				if (t.getStatus().equals(E_Status.Pending)) {
					t.setStatus(E_Status.Waiting);
					TransLogic.getInstance().updateTransPay(t);
					JsonObject tJSON = new JsonObject();
					tJSON.put("ID", t.getTransID());
					tJSON.put("Size", t.getSize());
					tJSON.put("Fee", t.getFee());
					tJSON.put("Type", t.getType().toString());
					tJSON.put("Status", t.getStatus().toString());

					transJSON.add(tJSON);
				}
			}

			for (TransactionConfirm t : trC) {
				if (t.getStatus().equals(E_Status.Pending)) {
					t.setStatus(E_Status.Waiting);
					TransLogic.getInstance().updateTransConfirm(t);
					JsonObject tJSON = new JsonObject();
					tJSON.put("ID", t.getTransID());
					tJSON.put("Size", t.getSize());
					tJSON.put("Fee", t.getFee());
					tJSON.put("Type", t.getType().toString());
					tJSON.put("Status", t.getStatus().toString());

					transJSON.add(tJSON);
				}
			}
			//JsonObject tJSON = new JsonObject();

			rootObject.put("Transactions", transJSON);

			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(rootObject.toJson());
			fileWriter.close();

			System.out.println("Exported To JSON XDXD");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * importing transactions from XML
	 */
	public ArrayList<Transaction> importTransactionsFromXML() {
		ArrayList<Transaction> trans = new ArrayList<>();
		
		SAXBuilder builder = new SAXBuilder();
		File file = new File(Consts.XML_IMPORT_FILE_PATH);
		
		try {
			Document document = (Document) builder.build(file);
			Element rootElement = document.getRootElement();
			List<Element> transactions = rootElement.getChildren("Transaction");
			
			for (int i = 0; i < transactions.size(); i++) {
				Element transElement = transactions.get(i);
				
				/*System.out.println(transElement.getAttributeValue("ID"));
				System.out.println(transElement.getAttributeValue("size"));
				System.out.println(transElement.getAttributeValue("Type"));
				System.out.println(transElement.getAttributeValue("ComissionFee"));
				System.out.println(transElement.getAttributeValue("BlockUniqueAddress"));
				System.out.println(transElement.getAttributeValue("TransactionDate"));
				System.out.println();*/
				
				int id = Integer.parseInt(transElement.getAttributeValue("ID"));
				int size = Integer.parseInt(transElement.getAttributeValue("size"));
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date transactionDate = new Date(simpleDateFormat.parse(transElement.getAttributeValue("TransactionDate")).getTime());				
				double comissionFee = Double.parseDouble(transElement.getAttributeValue("ComissionFee"));
				
				trans.add(new Transaction(id,
										null,
										size,
										null,
										transactionDate,
										comissionFee,
										null,
										null,
										null,
										null,
										null,
										null,
										E_TransType.getType(transElement.getAttributeValue("Type"))));
			}
		}
		catch (IOException | JDOMException | ParseException e) {
			e.printStackTrace();
		}
		
		return trans;
	}
}
