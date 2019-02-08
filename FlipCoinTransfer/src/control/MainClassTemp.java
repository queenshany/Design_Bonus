package control;

import java.sql.Date;
import java.sql.Time;

import entity.Item;
import entity.ItemInTransaction;
import entity.Message;
import entity.Recommendation;
import entity.RecommendedFor;
import entity.SystemParams;
import entity.TransactionConfirm;
import entity.TransactionPay;
import utils.E_Level;
import utils.E_Status;

/**
 * This MainClass object - represents the program runner
 **/
public class MainClassTemp{

	private static ItemLogic il = new ItemLogic();
	private static RecLogic rl = new RecLogic();
	private static TransLogic tl = new TransLogic();
	private static UserLogic ul = new UserLogic();
	private static WalletLogic wl = new WalletLogic();
	private static SysData sd = new SysData();

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//il.insertItem(new Item(8, "j", "h", "h", 8, 7, 1, "A1A1A1", "A11"));
		//il.insertItemIntoTrans(new ItemInTransaction(8, 7, 8));
		//ul.insertMessage(new Message(1, "A1A1A1", "A11", "hello", "world", new Date(8, 2, 2019), new Time(7)));
		//rl.insertRecommendation(new Recommendation(8, new Date(8, 2, 2019), 0.5, 54, false));
		//rl.insertRecommendedFor(new RecommendedFor("A1A1A1", "A11", 8, E_Level.Weak));
		//sd.insertSysParams(new SystemParams(2, new Date(8, 2, 2019), 5, 6, 4, 5, 4, 4, 4, 4, 8));
		//tl.insertTransConfirm(new TransactionConfirm(9, "", 66, new Date(8, 2, 2019), new Date(8, 2, 2019), 5, E_Status.Executed, "A1A1A1", "A11", "B2B2B2", "B22", "AAAA", true, new Date(8, 2, 2019)));
		tl.insertTransPay(new TransactionPay(9, "", 66, new Date(8, 2, 2019), new Date(8, 2, 2019), 5, E_Status.Executed, "A1A1A1", "A11", "B2B2B2", "B22", "AAAA", 8));

	}

}
