package entity;
import java.net.URLDecoder;
/**
 * This class represents the Consts in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public final class Consts {
	private Consts() {
		throw new AssertionError();
	}
	
	public static final String XML_EXPORT_FILE_PATH = System.getProperty("user.dir") + "..\\..\\comm_JSON_XML\\TransFromMining.xml";
	
	public static final String XML_IMPORT_FILE_PATH = System.getProperty("user.dir") + "\\comm_JSON_XML\\TransFromMining.xml";
	
	public static final String JSON_EXPORT_FILE_PATH = System.getProperty("user.dir") + "\\comm_JSON_XML\\TransFromTransfer.json";
	
	public static final String JSON_IMPORT_FILE_PATH = System.getProperty("user.dir") + "\\comm_JSON_XML\\TransFromTransfer.json";

	public static final int PHONE_LENGTH = 7;
	
	public static final int USER_SIGNATURE_LENGTH = 3;
	
	public static final int USER_ADDRESS_LENGTH = 6;
	
	public static final int WALLET_ADDRESS_LENGTH = 4;

	public static final int MAX_PAY_TRANS = 100;

	public static final String JDBC_STR = "net.ucanaccess.jdbc.UcanaccessDriver";

	public static final String DB_FILE_NAME = "DBTransfer.accdb";

	public static final String DB_FILE_PATH = getDBPath(); 

	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILE_PATH + ";COLUMNORDER=DISPLAY";


	// ***************************** INSERT QUERIES ***************************** 

	public static final String SQL_INS_CATEGORY = "INSERT INTO tblCategory ( serialNumber, categoryName )\r\n" + 
			"VALUES ((?), (?))\r\n" + "";

	public static final String SQL_INS_ITEM = "INSERT INTO tblItem ( catalogNumber, itemName, image, description, price, quantity, category, sellerAddress, sellerSignature )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_ITEM_INTO_TRANS = "INSERT INTO keyItemInTransaction ( item, trans, quantity )\r\n" + 
			"VALUES ((?), (?), (?))";

	public static final String SQL_INS_MESSAGE = "INSERT INTO tblMessage ( ID, userAddress, userSignature, title, description, messageDate, messageTime )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?))\r\n";

	public static final String SQL_INS_RECOMMENDATION = "INSERT INTO tblRecommendation ( recNum, creationDate, probability, recommendedFee, isApproved )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?))";

	public static final String SQL_INS_RECOMMENDATION_FOR_USER = "INSERT INTO keyRecommendedFor ( userAddress, userSignature, recommendation, commitmentLevel )\r\n" + 
			"VALUES ((?), (?), (?), (?))";

	public static final String SQL_INS_SYS_PARAM = "INSERT INTO tblSystem ( version, versionDate, transMinSize, transMaxSize, transSizeForExpansion, priceForExpansion, discountPercentPerFee, priceForDiscount, transSizeFree, maxAllowableDiscount, lastTransferredTrans, firstTransferredTrans)\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_TRANS_CONFIRM = "INSERT INTO tblTransConfirm ( transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature, destinationAddress, destinationSignature, walletAddress, isConfirmed, shippmentDate )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_TRANS_PAY = "INSERT INTO tblTransPay ( transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature, destinationAddress, destinationSignature, walletAddress, payValue )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_USER = "INSERT INTO tblUser ( publicAddress, signature, username, password, phone, email, isEmployee )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_WALLET = "INSERT INTO tblWallet ( uniqueAddress, price, isOnPC, isOnPhone, isOnTablet, amount, pendingAmount, userAddress, userSignature )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_WALLET_KNOTS = "INSERT INTO tblWalletBitcoinKnots ( walletUniqueAddress, discountPercent )\r\n" + 
			"VALUES ((?), (?))";

	public static final String SQL_INS_WALLET_SPACE = "INSERT INTO tblWalletBitcoinSpace ( walletUniqueAddress, transSize )\r\n" + 
			"VALUES ((?), (?))";

	// ***************************** DELETE QUERIES ***************************** 

	public static final String SQL_DEL_CATEGORY = "{ call deleteCategoryQry(?) }";

	public static final String SQL_DEL_ITEM_IN_TRANS = "{ call deleteItemInTransactionQry(?, ?) }";

	public static final String SQL_DEL_ITEM = "{ call deleteItemQry(?) }";

	public static final String SQL_DEL_RECOMMENDATION = "{ call deleteRecommendationQry(?) }";

	public static final String SQL_DEL_USER_IN_REC = "{ call deleteUserInRecommendationQry(?, ?, ?) }";

	// ***************************** UPDATE QUERIES ***************************** 

	public static final String SQL_UPD_CATEGORY = "{ call updateCategoryQry(?, ?) }";
	
	public static final String SQL_UPD_ITEM_IN_TRANS = "{ call updateItemInTransactionQry(?, ?, ?) }";
	
	public static final String SQL_UPD_ITEM = "{ call updateItemQry(?, ?, ?, ?, ?, ?, ?) }";
	
	public static final String SQL_UPD_FIRST_AND_LAST_TRANSFERRED_TRANS = "{ call updateFirstLastTransferredTransQry(?, ?, ?) }";
	
	public static final String SQL_UPD_REC = "{ call updateRecommendationQry(?, ?, ?) }";
	
	public static final String SQL_UPD_USER_IN_REC = "{ call updateRecommendedForQry(?, ?, ?, ?) }";
	
	public static final String SQL_UPD_TRANS_CONFIRM = "{ call updateTransConfirmQry(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
	
	public static final String SQL_UPD_TRANS_PAY = "{ call updateTransPayQry(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
	
	public static final String SQL_UPD_USER = "{ call updateUserQry(?, ?, ?, ?, ?, ?) }";
	
	public static final String SQL_UPD_WALLET_KNOTS = "{ call updateWalletBitcoinKnotsQry(?, ?) }";
	
	public static final String SQL_UPD_WALLET_SPACE = "{ call updateWalletBitcoinSpaceQry(?, ?) }";
	
	public static final String SQL_UPD_WALLET = "{ call updateWalletQry(?, ?, ?, ?, ?, ?, ?) }";
	
	// ***************************** SELECT QUERIES ***************************** 

	public static final String SQL_SEL_USERS = "SELECT * FROM tblUser";

	public static final String SQL_SEL_REC_FOR = "SELECT * FROM keyRecommendedFor";

	public static final String SQL_SEL_ITEM_IN_TRANS = "SELECT * FROM keyItemInTransaction";
	
	public static final String SQL_SEL_TRANS_PAY = "SELECT * FROM tblTransPay";
	
	public static final String SQL_SEL_TRANS_CONFIRM = "SELECT * FROM tblTransConfirm";
	
	public static final String SQL_SEL_ITEMS = "SELECT * FROM tblItem";
	
	public static final String SQL_SEL_CATEGORIES = "SELECT * FROM tblCategory";
	
	public static final String SQL_SEL_SYS_PARAMS = "SELECT * FROM tblSystem";
	
	public static final String SQL_SEL_RECOMMENDATIONS = "SELECT * FROM tblRecommendation";
	
	public static final String SQL_SEL_MESSAGES = "SELECT * FROM tblMessage";
	
	public static final String SQL_SEL_WALLETS = "SELECT * FROM tblWallet";
	
	public static final String SQL_SEL_WALLET_KNOTS = "SELECT W.uniqueAddress, W.isOnPC, W.isOnPhone, W.isOnTablet, W.amount, W.pendingAmount, W.pendingAmount, W.userAddress, W.userSignature, K.discountPercent\r\n" + 
			"FROM TblWallet AS W, tblWalletBitcoinKnots AS K\r\n" + 
			"WHERE ((W.uniqueAddress=K.walletUniqueAddress))";
	
	public static final String SQL_SEL_WALLET_SPACE = "SELECT W.uniqueAddress, W.isOnPC, W.isOnPhone, W.isOnTablet, W.amount, W.pendingAmount, W.pendingAmount, W.userAddress, W.userSignature, S.transSize\r\n" + 
			"FROM TblWallet AS W, tblWalletBitcoinSpace AS S\r\n" + 
			"WHERE W.uniqueAddress=S.walletUniqueAddress";
	
	// ***************************** GENERAL QUERIES ***************************** 

	public static final String SQL_REC_CALC_PROBABILITY = "SELECT SUM(C) * 100/((Select COUNT(*) FROM tblTransPay TP WHERE TP.creationDate = (?))+(Select COUNT(*) FROM tblTransConfirm TC WHERE TC.creationDate = (?))) AS transPercent\r\n" + 
			"FROM (SELECT creationDate, status, COUNT(*) as C, (Select COUNT(*) FROM tblTransConfirm WHERE TC.creationDate = (?)) as P\r\n" + 
			"FROM tblTransConfirm TC \r\n" + 
			"group by creationDate, status\r\n" + 
			"\r\n" + 
			"UNION ALL\r\n" + 
			"\r\n" + 
			"SELECT creationDate, status, COUNT(*) as C, (Select COUNT(*) FROM tblTransPay WHERE TP.creationDate = (?)) as P\r\n" + 
			"From tblTransPay TP\r\n" + 
			"group by creationDate, status) \r\n" + 
			"GROUP BY creationDate, status\r\n" + 
			"HAVING creationDate=(?) AND status=\"Executed\"";

	public static final String SQL_ALL_PENDING_TRANS = "Select *\r\n" + 
			"from (SELECT transID, description, [size], creationDate, executionDate, fee, status, creatingAddress, creatingSignature, destinationAddress, destinationSignature, walletAddress ,'Pay' as type\r\n" + 
			"FROM tblTransPay\r\n" + 
			"WHERE status=\"Pending\" OR status=\"Waiting\")\r\n" + 
			"\r\n" + 
			"UNION ALL (SELECT transID, description, [size], creationDate, executionDate, fee, status, creatingAddress, creatingSignature, destinationAddress, destinationSignature, walletAddress, 'Confirm' as type\r\n" + 
			"FROM tblTransConfirm\r\n" + 
			"WHERE status=\"Pending\" OR status=\"Waiting\")\r\n" + 
			"ORDER BY creationDate";

	public static final String SQL_ALL_TRANS = "Select *\r\n" + 
			"from (SELECT transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature, destinationAddress, destinationSignature, walletAddress, 'Pay' as type\r\n" + 
			"FROM tblTransPay)\r\n" + 
			"\r\n" + 
			"UNION ALL (SELECT transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature, destinationAddress, destinationSignature, walletAddress, 'Confirm' as type\r\n" + 
			"FROM tblTransConfirm)\r\n" + 
			"ORDER BY creationDate";

	public static final String SQL_LOAD_MONEY = "{ call loadMoneyToWalletQry(?, ?) }";
	
	
	// ***************************** PATH STUFF ***************************** 

	private static String getDBPath() {
		try {
			String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String decoded = URLDecoder.decode(path, "UTF-8");
			if (decoded.contains(".jar")) {
				decoded = decoded.substring(0, decoded.lastIndexOf('/'));
				//System.out.println(decoded + "/database/" + DB_FILE_NAME);

				return decoded + "/databaseTransfer/" + DB_FILE_NAME;
			}
			else {
				decoded = decoded.substring(0, decoded.lastIndexOf('/'));
				//System.out.println(decoded);

				return decoded + "/entity/"+ DB_FILE_NAME;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		//return new File("/database/" + DB_FILE_NAME).getAbsolutePath();
	}
}
