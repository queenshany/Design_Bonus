package entity;
import java.net.URLDecoder;

public final class Consts {
	private Consts() {
		throw new AssertionError();
	}

	public static final String JDBC_STR = "net.ucanaccess.jdbc.UcanaccessDriver";

	public static final String DB_FILE_NAME = "DBTransfer.accdb";
	public static final String DB_FILE_PATH = getDBPath(); 

	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILE_PATH + ";COLUMNORDER=DISPLAY";
	
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
