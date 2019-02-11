package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Consts;
import entity.Recommendation;
import entity.Transaction;
import entity.User;
import entity.Wallet;
import entity.WalletBitcoinKnots;
import entity.WalletBitcoinSpace;
import utils.E_WalletType;

/**
 * This class represents the Wallet Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class WalletLogic {
	private static WalletLogic instance;

	public static WalletLogic getInstance() {
		if (instance == null)
			instance = new WalletLogic();
		return instance;
	}

	// ***************************** INSERT QUERIES *****************************

	/**
	 * Inserting a wallet to the DB
	 * @param wallet
	 */
	public void insertWallet(Wallet wallet) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_WALLET);
				int i = 1;

				stmt.setString(i++, wallet.getUniqueAddress());

				if (wallet.getPrice() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getPrice());

				stmt.setBoolean(i++, wallet.isOnPC());
				stmt.setBoolean(i++, wallet.isOnPhone());
				stmt.setBoolean(i++, wallet.isOnTablet());

				if (wallet.getAmount() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getAmount());

				if (wallet.getPendingAmount() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getPendingAmount());

				if (wallet.getUserAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, wallet.getUserAddress());

				if (wallet.getUserSignature() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, wallet.getUserSignature());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + wallet);
	}

	/**
	 * Inserting a wallet knots to the DB
	 * @param wallet
	 */
	public void insertWalletBitcoinKnots(WalletBitcoinKnots wallet) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_WALLET_KNOTS);
				int i = 1;

				stmt.setString(i++, wallet.getUniqueAddress());

				if (wallet.getDiscountPercent() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getDiscountPercent());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + wallet);
	}

	/**
	 * Inserting a wallet space to the DB
	 * @param wallet
	 */
	public void insertWalletBitcoinSpace(WalletBitcoinSpace wallet) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_WALLET_SPACE);
				int i = 1;

				stmt.setString(i++, wallet.getUniqueAddress());

				if (wallet.getTransSize() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getTransSize());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + wallet);
	}

	// ***************************** UPDATE QUERIES *****************************

	/**
	 * Updates Wallet values
	 * @param wallet
	 */
	public void updateWallet(Wallet wallet) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_WALLET)) {

				int i = 1;

				if (wallet.getPrice() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getPrice());

				stmt.setBoolean(i++, wallet.isOnPC());
				stmt.setBoolean(i++, wallet.isOnPhone());
				stmt.setBoolean(i++, wallet.isOnTablet());

				if (wallet.getAmount() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getAmount());

				if (wallet.getPendingAmount() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getPendingAmount());

				stmt.setString(i++, wallet.getUniqueAddress());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + wallet);
	}

	/**
	 * Updates Wallet Bitcoin Knots values
	 * @param wallet
	 */
	public void updateWalletBitcoinKnots(WalletBitcoinKnots wallet) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_WALLET_KNOTS)) {

				int i = 1;

				if (wallet.getDiscountPercent() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getDiscountPercent());

				stmt.setString(i++, wallet.getUniqueAddress());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + wallet);
	}

	/**
	 * Updates Wallet Bitcoin Space values
	 * @param wallet
	 */
	public void updateWalletBitcoinSpace(WalletBitcoinSpace wallet) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_WALLET_SPACE)) {

				int i = 1;

				if (wallet.getTransSize() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, wallet.getTransSize());

				stmt.setString(i++, wallet.getUniqueAddress());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + wallet);
	}

	// ***************************** SELECT QUERIES *****************************

	/**
	 * Loading Wallets from the DB to the system
	 * @return ALL of the Wallets from the DB
	 */
	public ArrayList<Wallet> getWallets() {
		ArrayList<Wallet> results = new ArrayList<Wallet>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_WALLETS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Wallet(rs.getString(i++),
							rs.getDouble(i++),
							rs.getBoolean(i++),
							rs.getBoolean(i++),
							rs.getBoolean(i++),
							rs.getDouble(i++),
							rs.getDouble(i++),
							rs.getString(i++),
							rs.getString(i++)/*
							,E_WalletType.valueOf(rs.getString(i++))*/
							));
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

	/**
	 * Loading Wallets from the DB to the system
	 * @return ALL of the Wallets from the DB
	 */
	public ArrayList<WalletBitcoinKnots> getWalletsKnots() {
		ArrayList<WalletBitcoinKnots> results = new ArrayList<WalletBitcoinKnots>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_WALLET_KNOTS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new WalletBitcoinKnots(rs.getString(i++),
							rs.getDouble(i++),
							rs.getBoolean(i++),
							rs.getBoolean(i++),
							rs.getBoolean(i++),
							rs.getDouble(i++),
							rs.getDouble(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getDouble(i++)/*
							,E_WalletType.valueOf(rs.getString(i++))*/
							));
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

	
	/**
	 * Loading Wallets Space from the DB to the system
	 * @return ALL of the Wallets from the DB
	 */
	public ArrayList<WalletBitcoinSpace> getWalletSpace() {
		ArrayList<WalletBitcoinSpace> results = new ArrayList<WalletBitcoinSpace>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_WALLET_SPACE);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new WalletBitcoinSpace(rs.getString(i++),
							rs.getDouble(i++),
							rs.getBoolean(i++),
							rs.getBoolean(i++),
							rs.getBoolean(i++),
							rs.getDouble(i++),
							rs.getDouble(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getInt(i++)/*
							,E_WalletType.valueOf(rs.getString(i++))*/
							));
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

	
	// ***************************** GENERAL METHODS *****************************
	
	public void calcPendingAmount(Wallet wallet) {
		ArrayList<Transaction> trans = TransLogic.getInstance().getAllPendingTrans();
	}
}
