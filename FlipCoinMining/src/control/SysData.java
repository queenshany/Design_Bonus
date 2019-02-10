package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.lang.RandomStringUtils;

import entity.Consts;
import entity.Message;
import entity.SystemParams;
import entity.Transaction;

/**
 * This class represents the Sys Management: Parameters, Sign In
 * @author Shany Klein & Ofri Kokush
 *
 */
public class SysData {

	private static SysData instance;

	public static SysData getInstance() {
		if (instance == null)
			instance = new SysData();
		return instance;
	}

	// ***************************** UPDATE QUERIES *****************************

	/**
	 * Updates last transferred trans
	 * @param sys
	 * @param trans
	 */
	public void updateLastTransferredTrans(SystemParams sys, Transaction trans) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_LAST_TRANSFERRED_TRANS)) {

				int i = 1;
				stmt.setInt(i++, trans.getID());
				stmt.setDouble(i++, sys.getVersion());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + sys);
	}

	// ***************************** GENERAL METHODS *****************************
	/**
	 * This method generates Random Strings for addresses and stuff
	 * @param length
	 * @return the string
	 */
	public String generateRandomStrings(int length) {
		return RandomStringUtils.randomAlphanumeric(length).toUpperCase();
	}

	
}
