package control;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import entity.Consts;
import entity.SystemParams;
import entity.Transaction;
import entity.TransactionConfirm;
import entity.TransactionPay;
import utils.E_Status;

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
	public void importTransactionsFromXML() {
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
}
