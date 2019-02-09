package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Consts;
import entity.User;
import entity.Wallet;
import entity.WalletBitcoinKnots;
import entity.WalletBitcoinSpace;

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
}
