package control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import entity.Consts;
import entity.Riddle;
import entity.Solution;
import entity.Transaction;
import utils.E_Status;
import utils.E_TransStatus;
import utils.E_Type;

/**
 * This class represents the communication between the systems (Transfer & Mining)
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Communication {

	/**
	 * exporting trans to XML
	 */
	public static boolean exportToXML() {
		try {
			Document doc = new Document();
			doc.setRootElement(new Element("Transactions"));

			File file = new File(Consts.XML_EXPORT_FILE_PATH);
			file.getParentFile().mkdirs();
			if (!file.exists())
				file.createNewFile();

			ArrayList<Transaction> trans = BlockTransLogic.getInstance().getTrans();

			for (Transaction t : trans) {
				if (t.getStatus().equals(E_TransStatus.Executed)) {
					Element element = new Element("Transaction");
					element.setAttribute("ID", String.valueOf(t.getID()));
					element.setAttribute("Size", String.valueOf(t.getSize()));
					element.setAttribute("Type", (t.getType() == null ? "" : t.getType().toString()));
					element.setAttribute("Fee", String.valueOf(t.getFee()));
					element.setAttribute("Status", (t.getStatus().toString()));
					element.setAttribute("ExecutaionDate", t.getAdditionDate().toString());
					doc.getRootElement().addContent(element);
				}
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

	/**
	 * importing trans from JSON
	 */
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
				Integer id = Integer.parseInt(String.valueOf(jsonT.get("ID")));
				Integer size = Integer.parseInt(String.valueOf(jsonT.get("Size")));
				Double fee = Double.parseDouble(String.valueOf(jsonT.get("Fee")));
				E_Type type = E_Type.getType(String.valueOf(jsonT.get("Type")));
				E_TransStatus status = E_TransStatus.getStatus(String.valueOf(jsonT.get("Status")));
				Date date = Date.valueOf(LocalDate.now());

				Transaction transaction = new Transaction(id,
						size,
						type,
						fee,
						date,
						null,
						null,
						null,
						status);

				trans.add(transaction);
			}

			//Add to DB instead of printing.
			for (Transaction t : trans) {
				BlockTransLogic.getInstance().insertTrans(t);
			}
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * importing riddles from XML
	 */
	public static boolean importRiddlesFromXML() {
		ArrayList<Riddle> riddles = new ArrayList<>();
		ArrayList<Solution> solutions = new ArrayList<>();

		SAXBuilder builder = new SAXBuilder();
		File file = new File(Consts.XML_RIDDLES_FILE_PATH);

		try {
			Document document = (Document) builder.build(file);
			Element rootElement = document.getRootElement();
			//List<Element> ridE = rootElement.getChildren("Riddles");
			//List<Element> solE = rootElement.getChildren("Solutions");
			Element riddleElement = rootElement.getChild("Riddles");
			Element solutionElement = rootElement.getChild("Solutions");
			List<Element> ridE = riddleElement.getChildren("Riddle");
			List<Element> solE = solutionElement.getChildren("Solution");

			for (int i = 0; i < ridE.size(); i++) {
				Element ridElement = ridE.get(i);

				int id = Integer.parseInt(ridElement.getAttributeValue("RiddleNum"));
				String desc = ridElement.getAttributeValue("Description");

				Riddle r = new Riddle(id,
						Date.valueOf(LocalDate.now()),
						Time.valueOf(LocalTime.now()),
						desc,
						null,
						null,
						E_Status.Unsolved,
						1);
			//	System.out.println(r);
				riddles.add(r);
			}

			for (int i = 0; i < solE.size(); i++) {
				Element solElement = solE.get(i);

				int ridID = Integer.parseInt(solElement.getAttributeValue("RiddleNum"));
				int solID = Integer.parseInt(solElement.getAttributeValue("SolutionNum"));
				double result = Double.parseDouble(solElement.getAttributeValue("Result"));
				Solution s  = new Solution(ridID, solID, result);
				//System.out.println(s);
				solutions.add(s);
			}

//			solutions.sort(new Comparator<Solution>() {
//				@Override
//				public int compare(Solution s1, Solution s2) {
//					return s1.getRiddleNum()-s2.getRiddleNum();
//				}
//			});
//
//			riddles.sort(new Comparator<Riddle>() {
//				@Override
//				public int compare(Riddle s1, Riddle s2) {
//					return s1.getRiddleNum()-s2.getRiddleNum();
//				}
//			});

//			for (int i = 0; i < riddles.size(); i++) {
//				//System.err.println(riddles.get(i));
//				Riddle r = riddles.get(i);
//				int temp = r.getRiddleNum();
//				r.setRiddleNum(RiddleLogic.getInstance().getRiddleID());
//				
//				System.out.println();
//
//				for (int j = 0; j < solutions.size(); j++) {
//					Solution s = solutions.get(j);
//					if (temp == s.getRiddleNum()) {
//						System.out.println(r);
//						s.setRiddleNum(r.getRiddleNum());
//						//System.out.println(s);
//						RiddleLogic.getInstance().insertSolution(s);
//						//break;
//					}
//				}
//				RiddleLogic.getInstance().insertRiddle(r);
//				System.out.println();
//			}
			for (Riddle rid : riddles)
				RiddleLogic.getInstance().insertRiddle(rid);
			
			for (Solution sol : solutions)
				RiddleLogic.getInstance().insertSolution(sol);
			//System.out.println(t);
			return true;
		}
		catch (IOException | JDOMException e) {
			e.printStackTrace();
		}

		return false;
	}

}
