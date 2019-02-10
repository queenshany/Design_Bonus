package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Consts;
import entity.Item;
import entity.SystemParams;
import entity.Transaction;
import entity.User;

/**
 * This class represents the Sys Management: Net Mode, Parameters, Sign In
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
	
	// ***************************** INSERT QUERIES ***************************** 

	/**
	 * Inserting sys params to the DB
	 * @param sys
	 */
	public void insertSysParams(SystemParams sys) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_SYS_PARAM);
				int i = 1;

				stmt.setDouble(i++, sys.getVersion());

				if (sys.getVersionDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, sys.getVersionDate());

				if (sys.getTransMinSize() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, sys.getTransMinSize());

				if (sys.getTransMaxSize() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, sys.getTransMaxSize());

				if (sys.getTransSizeForExpansion() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, sys.getTransSizeForExpansion());				

				if (sys.getPriceForExpansion() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, sys.getPriceForExpansion());

				if (sys.getDiscountPercentPerFee() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, sys.getDiscountPercentPerFee());

				if (sys.getPriceForDiscount() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, sys.getPriceForDiscount());

				if (sys.getTransSizeFree() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setDouble(i++, sys.getTransSizeFree());

				if (sys.getMaxAllowableDiscount() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, sys.getMaxAllowableDiscount());

				if (sys.getLastTransferredTrans() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setDouble(i++, sys.getLastTransferredTrans());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + sys);
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
				stmt.setInt(i++, trans.getTransID());
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

	// ***************************** SELECT QUERIES *****************************

	/**
	 * Loading SysParams from the DB to the system
	 * @return ALL of the SysParams from the DB
	 */
	public ArrayList<SystemParams> getSysParams() {
		ArrayList<SystemParams> results = new ArrayList<SystemParams>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_SYS_PARAMS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new SystemParams(rs.getDouble(i++),
							rs.getDate(i++),
							rs.getInt(i++),
							rs.getInt(i++),
							rs.getInt(i++),
							rs.getDouble(i++),
							rs.getDouble(i++),
							rs.getDouble(i++),
							rs.getInt(i++),
							rs.getDouble(i++),
							rs.getInt(i++)));
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//System.out.println(results);
		return results;
	}

}
