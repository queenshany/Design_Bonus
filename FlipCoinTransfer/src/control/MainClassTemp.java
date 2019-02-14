package control;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import entity.Category;
import entity.Item;
import entity.ItemInTransaction;
import entity.Message;
import entity.Recommendation;
import entity.RecommendedFor;
import entity.SystemParams;
import entity.Transaction;
import entity.TransactionConfirm;
import entity.TransactionPay;
import entity.User;
import entity.Wallet;
import entity.WalletBitcoinKnots;
import entity.WalletBitcoinSpace;
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
		//tl.insertTransPay(new TransactionPay(8, "", 66, new Date(8, 2, 2019), new Date(8, 2, 2019), 5, E_Status.Executed, "A1A1A1", "A11", "B2B2B2", "B22", "BBBB", 8));
		//ul.insertUser(new User("K", "KK", "kk", "kkk", "2", "2", false));
		//wl.insertWallet(new Wallet("z", 0.6, true, true, false, 4, 3, "A1A1A1", "A11"));
		//wl.insertWalletBitcoinKnots(new WalletBitcoinKnots("z", 0.6, true, true, false, 4, 3, "A1A1A1", "A11", 0.6));
		//wl.insertWalletBitcoinSpace(new WalletBitcoinSpace("z", 0.6, true, true, false, 4, 3, "A1A1A1", "A11",6));
		//il.deleteCategory(new Category(8, "g"));
		//il.deleteItemInTrans(new ItemInTransaction(8, 7, 8));
		//il.deleteItem(new Item(8, "j", "h", "h", 8, 7, 1, "A1A1A1", "A11"));
		//rl.deleteUserInRec(new RecommendedFor("A1A1A1", "A11", 8, E_Level.Weak));
		//rl.deleteRecommendation(new Recommendation(8, new Date(8, 2, 2019), 0.5, 54, false));
		//System.out.println(rl.calcProbability(new Date(8, 2, 2019)));
		//System.out.println(tl.getAllPendingTrans());
		//System.out.println(tl.getAllTrans());
		//il.updateCategory(new Category(7, "j"));
		//il.updateItemInTrans(new ItemInTransaction(3, 1, 2));
		//il.updateItem(new Item(7, "v", "v", "v", 3, 3, 3, "A1A1A1", "A11"));
		//sd.updateLastTransferredTrans(new SystemParams(2, new Date(8, 2, 2019), 5, 6, 4, 5, 4, 4, 4, 4, 8), new TransactionPay(8, "", 66, new Date(8, 2, 2019), new Date(8, 2, 2019), 5, E_Status.Executed, "A1A1A1", "A11", "B2B2B2", "B22", "BBBB", 8));
		//rl.updateRecommendation(new Recommendation(3, new Date(8, 2, 2019), 500000000, 6000000, true));
		//rl.updateUserInRec(new RecommendedFor("e5e5e5", "e55", 1, E_Level.Weak));
		//tl.updateTransConfirm(new TransactionConfirm(9, "fff", 3456, new Date(8, 2, 2019), new Date(8, 2, 2019), 5, E_Status.Executed, "A1A1A1", "A11", "B2B2B2", "B22", "AAAA", true, new Date(8, 2, 2019)));
		//tl.updateTransPay(new TransactionPay(8, "fffff", 67, new Date(8, 2, 2019), new Date(8, 2, 2019), 5, E_Status.Executed, "A1A1A1", "A11", "B2B2B2", "B22", "BBBB", 8));
		//ul.updateUser(new User("kk", "kk", "aaaaaaaaa", "aaaaaaaaaa", "2", "2", true));
		//System.out.println(sd.getSysParams());
		//wl.updateWallet(new Wallet("z", 0.6, false, false, false, 4, 3, "A1A1A1", "A11"));
		//wl.updateWalletBitcoinKnots(new WalletBitcoinKnots("z", 0.6, true, true, false, 4, 3, "A1A1A1", "A11", 888));
		//wl.updateWalletBitcoinSpace(new WalletBitcoinSpace("z", 0.6, true, true, false, 4, 3, "A1A1A1", "A11", 999));
		//System.out.println(il.getCategories());
		//System.out.println(il.getItems());
		//System.out.println(rl.getRecommendations());
		//System.out.println("ALL " +tl.getAllTrans());
		//System.out.println("PENDING " +tl.getAllPendingTrans());
		//System.out.println(ul.getMessages());
		//System.out.println(ul.getUsers());
		//System.out.println(sd.getSysParams());
		//System.out.println(wl.getWallets());
		//		System.out.println("CATEGORY " + il.getCategoryID());
		//		System.out.println("ITEM " + il.getItemID());
		//		System.out.println("MSG " + ul.getMessageID());
		//		System.out.println("REC " + rl.getRecID());
		//		System.out.println("SYS " + sd.getSysVersion());
		//		System.out.println("TRA " + tl.getTransID());

		//System.out.println(il.getItems());
		//System.out.println(il.searchItem(null, null, null, null, new User("B2B2B2", "B22")));
	//Communication.getInstance().exportTransactionsToJSON();
//	for (Transaction transaction : Communication.getInstance().importTransactionsFromXML())
	//	System.out.println(transaction.toString());
	//System.out.println(rl.calcProbability(Date.valueOf(LocalDate.now())));
//		Communication.importTransactionsFromXML();
		//il.insertItem(new Item(9, "itemName", "image", "description", 6, 3, 2, "a1a1a1", "a11"));
	//	System.out.println(wl.getWalletsSpace());
	//	Communication.exportTransactionsToJSON();
		wl.generateWalletForNewUser(new User("A1A1A1", "A11"));
	}

}
