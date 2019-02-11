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

import entity.SystemParams;
import entity.Transaction;
import entity.TransactionConfirm;
import entity.TransactionPay;

/**
 * This class represents the communication between the systems (Transfer & Mining)
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Communication {

	public void exportAllTransactionsToJSON() {
		try {
			File file = new File(System.getProperty("user.dir") + "\\FlipCoin-Mining\\allTrans.json");
			file.getParentFile().mkdirs();
			if (!file.exists())
				file.createNewFile();

			SystemParams sys = SysData.getInstance().getLastVersionParams();
			ArrayList<Transaction> temp = TransLogic.getInstance().getAllPendingTrans();
			TreeSet<Transaction> trans = new TreeSet<>(new Comparator<Transaction>() {

				public int compare(Transaction o1, Transaction o2) {
					return o1.getCreationDate().compareTo(o2.getCreationDate());
				}
			});


			JsonObject rootObject = new JsonObject();
			JsonArray transJSON = new JsonArray();


			/*			for (TransactionPay t : transPay) {
				JsonObject tJSON = new JsonObject();
				tJSON.put("ID", t.getTransID());
				tJSON.put("Size", t.getSize());
				tJSON.put("Comission Fee", t.getCommissionFee());
				tJSON.put("Type", "Pay");

				transJSON.add(tJSON);
			}

			for (TransactionConfirm t : transConfirm) {
				JsonObject tJSON = new JsonObject();
				tJSON.put("ID", t.getTransID());
				tJSON.put("Size", t.getSize());
				tJSON.put("Comission Fee", t.getCommissionFee());
				tJSON.put("Type", "Confirm");

				transJSON.add(tJSON);
			}
			 */		
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
