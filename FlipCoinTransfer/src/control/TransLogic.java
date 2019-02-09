package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Consts;
import entity.Transaction;
import entity.TransactionConfirm;
import entity.TransactionPay;
import utils.E_Status;
import utils.E_Type;

/**
 * This class represents the Transaction Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class TransLogic {
	private static TransLogic instance;

	public static TransLogic getInstance() {
		if (instance == null)
			instance = new TransLogic();
		return instance;
	}

	// ***************************** INSERT QUERIES *****************************
	/**
	 * Inserting Trans Pay to the DB
	 * @param trans
	 */
	public void insertTransPay(TransactionPay trans) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_TRANS_PAY);
				int i = 1;

				stmt.setInt(i++, trans.getTransID());

				if (trans.getDescription() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getDescription());

				if (trans.getSize() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, trans.getSize());				

				if (trans.getCreationDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, trans.getCreationDate());	

				if (trans.getExecutionDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, trans.getExecutionDate());	

				if (trans.getFee() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, trans.getFee());	

				if (trans.getStatus() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getStatus().toString());	

				if (trans.getCreatingAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getCreatingAddress());	

				if (trans.getCreatingSignature() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getCreatingSignature());	

				if (trans.getDestinationAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getDestinationAddress());

				if (trans.getDestinationSignature() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getDestinationSignature());

				if (trans.getWalletAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getWalletAddress());

				if (trans.getPayValue() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, trans.getPayValue());	

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + trans);
	}

	/**
	 * Inserting Trans Confirm to the DB
	 * @param trans
	 */
	public void insertTransConfirm(TransactionConfirm trans) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_TRANS_CONFIRM);
				int i = 1;

				stmt.setInt(i++, trans.getTransID());

				if (trans.getDescription() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getDescription());

				if (trans.getSize() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, trans.getSize());				

				if (trans.getCreationDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, trans.getCreationDate());	

				if (trans.getExecutionDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, trans.getExecutionDate());	

				if (trans.getFee() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, trans.getFee());	

				if (trans.getStatus() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getStatus().toString());	

				if (trans.getCreatingAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getCreatingAddress());	

				if (trans.getCreatingSignature() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getCreatingSignature());	

				if (trans.getDestinationAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getDestinationAddress());

				if (trans.getDestinationSignature() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getDestinationSignature());

				if (trans.getWalletAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, trans.getWalletAddress());

				if (trans.getIsConfirmed() == null)
					stmt.setNull(i++, java.sql.Types.BOOLEAN);
				else
					stmt.setBoolean(i++, trans.getIsConfirmed());	

				if (trans.getShippmentDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, trans.getShippmentDate());	

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + trans);
	}

	// ***************************** GENERAL QUERIES *****************************

	/**
	 * Getting all transactions with status Pending
	 * @return transactions with status Pending
	 */
	public ArrayList<Transaction> getAllPendingTrans() {
		ArrayList<Transaction> results = new ArrayList<Transaction>();
		try {
			Class.forName(Consts.JDBC_STR);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_ALL_PENDING_TRANS)){
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					int i = 1;
					results.add(new Transaction(rs.getInt(i++),
							rs.getString(i++),
							rs.getInt(i++),
							rs.getDate(i++),
							rs.getDate(i++),
							rs.getDouble(i++),
							E_Status.valueOf(rs.getString(i++)),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							E_Type.valueOf(rs.getString(i++))
							));
				}
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * Getting all transactions
	 * @return all transactions
	 */
	public ArrayList<Transaction> getAllTrans() {
		ArrayList<Transaction> results = new ArrayList<Transaction>();
		try {
			Class.forName(Consts.JDBC_STR);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_ALL_TRANS)){
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					int i = 1;
					results.add(new Transaction(rs.getInt(i++),
							rs.getString(i++),
							rs.getInt(i++),
							rs.getDate(i++),
							rs.getDate(i++),
							rs.getDouble(i++),
							E_Status.valueOf(rs.getString(i++)),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							E_Type.valueOf(rs.getString(i++))
							));
				}
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
}
