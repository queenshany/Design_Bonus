package entity;
import java.net.URLDecoder;

public final class Consts {
	private Consts() {
		throw new AssertionError();
	}

	public static final String XML_EXPORT_FILE_PATH = System.getProperty("user.dir") + "\\comm_JSON_XML\\TransFromMining.xml";
	
	public static final String XML_IMPORT_FILE_PATH = System.getProperty("user.dir") + "\\comm_JSON_XML\\TransFromMining.xml";
	
	public static final String JSON_EXPORT_FILE_PATH = System.getProperty("user.dir") + "\\comm_JSON_XML\\TransFromTransfer.json";
	
	public static final String JSON_IMPORT_FILE_PATH = System.getProperty("user.dir") + "\\comm_JSON_XML\\TransFromTransfer.json";
	
	public static final int PHONE_LENGTH = 7;

	public static final int BLOCK_ADDRESS_LENGTH = 4;

	public static final int MINER_ADDRESS_LENGTH = 6;

	public static final String JDBC_STR = "net.ucanaccess.jdbc.UcanaccessDriver";

	public static final String DB_FILE_NAME = "DBMining.accdb";

	public static final String DB_FILE_PATH = getDBPath(); 

	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILE_PATH + ";COLUMNORDER=DISPLAY";

	// ***************************** INSERT QUERIES ***************************** 

	public static final String SQL_INS_BLOCK = "INSERT INTO tblBlock ( blockAddress, creationDate, creationTime, size, previousBlock, minerAddress )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_BONUS = "INSERT INTO tblBonus ( bonusNum, description )\r\n" + 
			"VALUES ((?), (?))\r\n" + "";

	public static final String SQL_INS_GET_BONUS = "INSERT INTO keyGetBonus ( lotteryNum, uniqueAddress, bonusNum )\r\n" + 
			"VALUES ((?), (?), (?))";

	public static final String SQL_INS_LOTTERY = "INSERT INTO tblLottery ( lotteryNum, lotteryDate, maxParticipants, numOfWinners, numOfBonuses )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?))";

	public static final String SQL_INS_MESSAGE = "INSERT INTO tblMessage ( ID, uniqueAddress, title, description, messageDate, messageTime )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_MINER_COMPANY = "INSERT INTO tblMinerCompany ( uniqueAddress, contactFirstName, contactLastName, contactPhone, contactEmail )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?))";

	public static final String SQL_INS_MINER = "INSERT INTO tblMiner ( uniqueAddress, minerName, password, email )\r\n" + 
			"VALUES ((?), (?), (?), (?))";

	public static final String SQL_INS_PARTICIPANT = "INSERT INTO keyParticipant ( lotteryNum, uniqueAddress, isWinner )\r\n" + 
			"VALUES ((?), (?), (?))";

	public static final String SQL_INS_RIDDLE_LEVEL = "INSERT INTO tblRiddleLevel ( levelCode, levelName, difficultyLevel, blockSize )\r\n" + 
			"VALUES ((?), (?), (?), (?))";

	public static final String SQL_INS_RIDDLE = "INSERT INTO tblRiddle ( riddleNum, publishedDate, publishedTime, description, solutionDate, solutionTime, status, riddleLevel )\r\n" + 
			"VALUES ((?), (?), (?), (?), (?), (?), (?), (?))";

	public static final String SQL_INS_SOLUTION = "INSERT INTO tblSolution ( riddleNum, solutionNum, result )\r\n" + 
			"VALUES ((?), (?), (?))";

	public static final String SQL_INS_SOLVED_RIDDLE = "INSERT INTO keySolvedRiddle ( uniqueAddress, riddleNum, solvedDate, solvedTime )\r\n" + 
			"VALUES ((?), (?), (?), (?))";

	public static final String SQL_INS_TRANS = "INSERT INTO tblTransaction ( ID, size, type, fee, status )\r\n" + 
			"VALUES ((?), (?), (?), (?), 'Waiting')";

	// ***************************** DELETE QUERIES ***************************** 

	public static final String SQL_DEL_BONUS = "{ call deleteBonusQry(?) }";

	// ***************************** UPDATE QUERIES ***************************** 

	public static final String SQL_ATTACH_TRANS_TO_BLOCK = "UPDATE tblTransaction SET tblTransaction.blockAddress = [blockAddresss], tblTransaction.additionDate = (?), tblTransaction.additionTime = (?), tblTransaction = 'Executed'\r\n" + 
			"WHERE (((tblTransaction.ID)=(?)))";

	public static final String SQL_UPD_BONUS = "{ call updateBonusQry(?, ?) }";

	public static final String SQL_UPD_LAST_TRANSFERRED_TRANS = "{ call updateLastTransferredTransQry(?, ?) }";
	
	public static final String SQL_UPD_LOTTERY = "UPDATE tblLottery SET tblLottery.lotteryDate = (?), tblLottery.maxParticipants = (?), tblLottery.numOfWinners = (?), tblLottery.numOfBonuses = (?)\r\n" + 
			"WHERE (((tblLottery.lotteryNum)=(?)))";

	public static final String SQL_UPD_MINER_COMPANY = "{ call updateMinerCompanyQry(?, ?, ?, ?, ?) }";

	public static final String SQL_UPD_MINER_PROFIT = "{ call updateMinerProfitQry(?, ?) }";

	public static final String SQL_UPD_MINER = "{ call updateMinerQry(?, ?, ?, ?) }";

	public static final String SQL_UPD_RIDDLE_LEVEL = "{ call updateRiddleLevelQry(?, ?, ?, ?) }";

	public static final String SQL_UPD_RIDDLE = "{ call updateRiddleQry(?, ?, ?, ?, ?) }";

	// ***************************** SELECT QUERIES *****************************

	public static final String SQL_SEL_BLOCKS = "SELECT * FROM tblBlock";
	
	public static final String SQL_SEL_MINERS = "SELECT * FROM tblMiner";

	public static final String SQL_SEL_LOTTERIES = "SELECT * FROM tblLottery";

	public static final String SQL_SEL_RIDDLES = "SELECT * FROM tblRiddle";

	public static final String SQL_SEL_RIDDLE_LEVELS = "SELECT * FROM tblRiddleLevel";

	public static final String SQL_SEL_BONUSES = "SELECT * FROM tblBonus";
	
	public static final String SQL_SEL_SOLUTIONS = "SELECT * FROM tblSolution";
	
	public static final String SQL_SEL_SYS_PARAMS = "SELECT * FROM tblSystem";
	
	public static final String SQL_SEL_MESSAGES = "SELECT * FROM tblMessage";
	
	// ***************************** GENERAL QUERIES ***************************** 

	public static final String SQL_TRANS_WITHOUT_BLOCK = "SELECT *\r\n" + 
			"FROM tblTransaction\r\n" + 
			"WHERE (tblTransaction.blockAddress=\"\" OR tblTransaction.blockAddress IS NULL)";

	public static final String SQL_TRANS_IN_BLOCK = "SELECT *\r\n" + 
			"FROM tblTransaction\r\n" + 
			"WHERE (tblTransaction.blockAddress)= (?)\r\n" + "";

	// ***************************** PATH STUFF ***************************** 

	private static String getDBPath() {
		try {
			String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String decoded = URLDecoder.decode(path, "UTF-8");
			if (decoded.contains(".jar")) {
				decoded = decoded.substring(0, decoded.lastIndexOf('/'));
				//System.out.println(decoded + "/database/" + DB_FILE_NAME);

				return decoded + "/databaseMining/" + DB_FILE_NAME;
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
