package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
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
import entity.Message;
import entity.SystemParams;
import entity.Transaction;
import entity.TransactionConfirm;
import entity.TransactionPay;
import entity.User;
import utils.E_Status;
import utils.E_TransType;

/**
 * This class represents the communication between the systems (Transfer & Mining)
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Communication {

	/**
	 * exporting pending transactions to JSON
	 * @return 
	 */
	public static boolean exportTransactionsToJSON() {
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
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * importing transactions from XML
	 */
	public static boolean importTransactionsFromXML() {
		ArrayList<Transaction> trans = new ArrayList<>();

		SAXBuilder builder = new SAXBuilder();
		File file = new File(Consts.XML_IMPORT_FILE_PATH);

		try {
			Document document = (Document) builder.build(file);
			Element rootElement = document.getRootElement();
			List<Element> transactions = rootElement.getChildren("Transaction");

			for (int i = 0; i < transactions.size(); i++) {
				Element transElement = transactions.get(i);

				int id = Integer.parseInt(transElement.getAttributeValue("ID"));
				int size = Integer.parseInt(transElement.getAttributeValue("Size"));
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				E_TransType type = E_TransType.getType(String.valueOf(transElement.getAttributeValue("Type")));
				Date executaionDate = new Date(simpleDateFormat.parse(transElement.getAttributeValue("ExecutaionDate")).getTime());				
				double fee = Double.parseDouble(transElement.getAttributeValue("Fee"));
				E_Status status = E_Status.getStatus(String.valueOf(transElement.getAttributeValue("Status")));

				trans.add(new Transaction(id,
						null,
						size,
						null,
						executaionDate,
						fee,
						status,
						null,
						null,
						null,
						null,
						null,
						type));
			}

			ArrayList<TransactionPay> trP = TransLogic.getInstance().getAllPayTrans();
			ArrayList<TransactionConfirm> trC = TransLogic.getInstance().getAllConfirmTrans();

			for (Transaction t : trans) {

				if (t.getType().equals(E_TransType.Pay)) {
					if (trP.contains(t) && trP.get(trP.indexOf(t)).getStatus().equals(E_Status.Waiting)) {
						TransactionPay tp = trP.get(trP.indexOf(t));
						tp.setExecutionDate(t.getExecutionDate());
						tp.setStatus(t.getStatus());
						TransLogic.getInstance().updateImportedTransPay(tp);
						System.out.println(tp);
					}
				}
				else if (t.getType().equals(E_TransType.Confirm)) {
					if (trC.contains(t) && trC.get(trC.indexOf(t)).getStatus().equals(E_Status.Waiting)) {
						TransactionConfirm tc = trC.get(trC.indexOf(t));
						tc.setExecutionDate(t.getExecutionDate());
						tc.setStatus(t.getStatus());
						if (trP.contains(new Transaction(tc.getTransPayID()))) {
							TransactionPay tp = trP.get(trP.indexOf(new Transaction(tc.getTransPayID())));
							if (tp.getStatus().equals(E_Status.Executed)) {
								tp.setStatus(E_Status.Closed);
								tc.setStatus(E_Status.Closed);
								TransLogic.getInstance().updateImportedTransPay(tp);
								// sending messages about transactions being closed
								User userPAY = UserLogic.getInstance().getUsers().get(UserLogic.getInstance().getUsers().indexOf(
										new User(tp.getCreatingAddress(), tp.getCreatingSignature())));
							
								User userCON = UserLogic.getInstance().getUsers().get(UserLogic.getInstance().getUsers().indexOf(
										new User(tc.getCreatingAddress(), tc.getCreatingSignature())));
								String title = "Your Transaction is Closed!";
								String descPAY = "A transaction you created is now closed. Transaction ID: " + tp.getTransID() ;
								String descCON = "A transaction you created is now closed. Transaction ID: " + tc.getTransID() ;
								UserLogic.getInstance().sendMessage(title, descPAY, userPAY);
								UserLogic.getInstance().sendMessage(title, descCON, userCON);
							}
						}
							
						TransLogic.getInstance().updateImportedTransConfirm(tc);
						System.out.println(tc);
					}
				}
			}
			//System.out.println(t);
			//TransLogic.getInstance().
			return true;
		}
		catch (IOException | JDOMException | ParseException e) {
			e.printStackTrace();
		}

		return false;
	}
}
