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

	public static final int PHONE_LENGTH = 7;

	public static final String JDBC_STR = "net.ucanaccess.jdbc.UcanaccessDriver";

	public static final String DB_FILE_NAME = "DBTransfer.accdb";
	public static final String DB_FILE_PATH = getDBPath(); 

	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILE_PATH + ";COLUMNORDER=DISPLAY";


	// ***************************** INSERT QUERIES ***************************** 

	//public static final String INS_CATEGORY = "{ call insertCategoryQry(?,?) }";
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

	public static final String SQL_INS_SYS_PARAM = "INSERT INTO tblSystem ( version, versionDate, transMinSize, transMaxSize, transSizeForExpansion, priceForExpansion, discountPercentPerFee, priceForDiscount, transSizeFree, maxAllowableDiscount, lastTransferredTrans)\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_TRANS_CONFIRM = "INSERT INTO tblTransConfirm ( transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature, destinationAddress, destinationSignature, walletAddress, isConfirmed, shippmentDate )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_TRANS_PAY = "INSERT INTO tblTransConfirm ( transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature, destinationAddress, destinationSignature, walletAddress, payValue )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?))";

	// ***************************** UPDATE QUERIES ***************************** 

	// ***************************** DELETE QUERIES ***************************** 

	// ***************************** GENERAL QUERIES ***************************** 

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
