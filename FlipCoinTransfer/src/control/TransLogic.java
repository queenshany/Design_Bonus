package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import entity.Consts;
import entity.Message;
import entity.Recommendation;
import entity.RecommendedFor;
import entity.Transaction;
import entity.TransactionConfirm;
import entity.TransactionPay;
import entity.User;
import utils.E_Status;
import utils.E_TransType;

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

	// ***************************** UPDATE QUERIES *****************************

	/**
	 * Updates Trans Confirm values
	 * @param trans
	 */
	public void updateTransConfirm(TransactionConfirm trans) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_TRANS_CONFIRM)) {

				int i = 1;

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

				stmt.setInt(i++, trans.getTransID());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + trans);
	}

	/**
	 * Updates Trans Pay values
	 * @param trans
	 */
	public void updateTransPay(TransactionPay trans) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_TRANS_PAY)) {

				int i = 1;

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

				stmt.setInt(i++, trans.getTransID());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + trans);
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
							E_TransType.valueOf(rs.getString(i++))
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
							E_TransType.valueOf(rs.getString(i++))
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
	 * Getting all Pay transactions
	 * @return all transactions
	 */
	public ArrayList<TransactionPay> getAllPayTrans() {
		ArrayList<TransactionPay> results = new ArrayList<>();
		try {
			Class.forName(Consts.JDBC_STR);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_TRANS_PAY)){
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					int i = 1;
					results.add(new TransactionPay(rs.getInt(i++),
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
							rs.getDouble(i++)
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
	public ArrayList<TransactionConfirm> getAllConfirmTrans() {
		ArrayList<TransactionConfirm> results = new ArrayList<>();
		try {
			Class.forName(Consts.JDBC_STR);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_TRANS_CONFIRM)){
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					int i = 1;
					results.add(new TransactionConfirm(rs.getInt(i++),
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
							rs.getBoolean(i++),
							rs.getDate(i++)
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

	
	// ***************************** GENERAL METHODS *****************************
	/**
	 * generating id for new Transaction
	 * @return id for new Transaction
	 */
	public int getTransID() {
		ArrayList<Transaction> trans = getAllTrans();
		trans.sort(new Comparator<Transaction>() {

			@Override
			public int compare(Transaction t1, Transaction t2) {
				return t1.getTransID()-t2.getTransID();
			}
		});
		
		if (!trans.isEmpty())
			return trans.get(trans.size()-1).getTransID() + 1;
		return 1;
	}
	
	/**
	 * getting Pay Trans of user Created
	 * @param user
	 * @return array list of Trans of user Created
	 */
	public ArrayList<TransactionPay> getPayTransOfUserCreated (User user){
		ArrayList<TransactionPay> trans = new ArrayList<>();
		for (TransactionPay t : getAllPayTrans())
			if (t != null && t.getCreatingAddress().equalsIgnoreCase(user.getPublicAddress())
			&& t.getCreatingSignature().equalsIgnoreCase(user.getSignature())) {
				trans.add(t);	
			}
		return trans;		
	}
	
	/**
	 * getting Pay Trans of user Destination
	 * @param user
	 * @return array list of Trans of user Destination
	 */
	public ArrayList<TransactionPay> getPayTransOfUserDestination (User user){
		ArrayList<TransactionPay> trans = new ArrayList<>();
		for (TransactionPay t : getAllPayTrans())
			if (t != null && t.getDestinationAddress().equalsIgnoreCase(user.getPublicAddress())
			&& t.getDestinationSignature().equalsIgnoreCase(user.getSignature())) {
				trans.add(t);	
			}
		return trans;		
	}
	
	/**
	 * getting Confirm Trans of user Created
	 * @param user
	 * @return array list of Trans of user Created
	 */
	public ArrayList<TransactionConfirm> getConfirmTransOfUserCreated (User user){
		ArrayList<TransactionConfirm> trans = new ArrayList<>();
		for (TransactionConfirm t : getAllConfirmTrans())
			if (t != null && t.getCreatingAddress().equalsIgnoreCase(user.getPublicAddress())
			&& t.getCreatingSignature().equalsIgnoreCase(user.getSignature())) {
				trans.add(t);	
			}
		return trans;		
	}
	
	/**
	 * getting Confirm Trans of user Destination
	 * @param user
	 * @return array list of Trans of user Destination
	 */
	public ArrayList<TransactionConfirm> getConfirmTransOfUserDestination (User user){
		ArrayList<TransactionConfirm> trans = new ArrayList<>();
		for (TransactionConfirm t : getAllConfirmTrans())
			if (t != null && t.getDestinationAddress().equalsIgnoreCase(user.getPublicAddress())
			&& t.getDestinationSignature().equalsIgnoreCase(user.getSignature())) {
				trans.add(t);	
			}
		return trans;		
	}
}
