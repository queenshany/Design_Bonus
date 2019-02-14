package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Consts;
import entity.SystemParams;
import entity.TransactionConfirm;
import entity.TransactionPay;
import entity.User;
import entity.Wallet;
import entity.WalletBitcoinKnots;
import entity.WalletBitcoinSpace;
import utils.E_Status;

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

		calcAmount(wallet);
		calcPendingAmount(wallet);

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
	public ArrayList<WalletBitcoinSpace> getWalletsSpace() {
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
	/**
	 * calc pending wallet amount
	 * @param wallet
	 * @return the amount left
	 */
	public void calcPendingAmount(Wallet wallet) {

		Double pending = new Double(wallet.getAmount());
		User user = new User(wallet.getUserAddress(), wallet.getUserSignature());
		for (User u : UserLogic.getInstance().getUsers())
			if (u != null && u.equals(user)) {
				user = u;
				break;
			}

		for (TransactionPay tp : TransLogic.getInstance().getAllPayTrans()) {
			if (tp.getWalletAddress().equals(wallet.getUniqueAddress())){
				if (tp.getStatus().equals(E_Status.Pending) || tp.getStatus().equals(E_Status.Waiting)
						|| tp.getStatus().equals(E_Status.Executed)) {

					if (tp.getCreatingAddress().equalsIgnoreCase(user.getPublicAddress())
							&& tp.getCreatingSignature().equalsIgnoreCase(user.getSignature()))
						pending -= (tp.getPayValue() + tp.getFee());

					if (tp.getDestinationAddress().equalsIgnoreCase(user.getPublicAddress())
							&& tp.getDestinationSignature().equalsIgnoreCase(user.getSignature()))
						pending += tp.getPayValue();
				}
			}
		}

		for (TransactionConfirm tc : TransLogic.getInstance().getAllConfirmTrans()) {
			if (tc.getWalletAddress().equals(wallet.getUniqueAddress())){
				if (tc.getStatus().equals(E_Status.Pending) || tc.getStatus().equals(E_Status.Waiting)
						|| tc.getStatus().equals(E_Status.Executed)) {

					if (tc.getCreatingAddress().equalsIgnoreCase(user.getPublicAddress())
							&& tc.getCreatingSignature().equalsIgnoreCase(user.getSignature()))
						pending -= tc.getFee();
				}
			}
		}

		wallet.setPendingAmount(pending);
	}

	/**
	 * calc pending wallet amount
	 * @param wallet
	 * @return the amount in wallet
	 */
	public void calcAmount(Wallet wallet) {

		Double amt = new Double(wallet.getAmount());
		User user = new User(wallet.getUserAddress(), wallet.getUserSignature());
		for (User u : UserLogic.getInstance().getUsers())
			if (u != null && u.equals(user)) {
				user = u;
				break;
			}

		for (TransactionPay tp : TransLogic.getInstance().getAllPayTrans()) {
			if (tp.getWalletAddress().equals(wallet.getUniqueAddress())){
				if (tp.getStatus().equals(E_Status.Closed)) {

					if (tp.getCreatingAddress().equalsIgnoreCase(user.getPublicAddress())
							&& tp.getCreatingSignature().equalsIgnoreCase(user.getSignature()))
						amt -= (tp.getPayValue() + tp.getFee());

					if (tp.getDestinationAddress().equalsIgnoreCase(user.getPublicAddress())
							&& tp.getDestinationSignature().equalsIgnoreCase(user.getSignature()))
						amt += tp.getPayValue();
				}
			}
		}

		for (TransactionConfirm tc : TransLogic.getInstance().getAllConfirmTrans()) {
			if (tc.getWalletAddress().equals(wallet.getUniqueAddress())){
				if (tc.getStatus().equals(E_Status.Closed)) {
					if (tc.getCreatingAddress().equalsIgnoreCase(user.getPublicAddress())
							&& tc.getCreatingSignature().equalsIgnoreCase(user.getSignature()))
						amt -= tc.getFee();
				}
			}
		}

		wallet.setAmount(amt);
	}

	/**
	 * getting all wallets of user
	 * @param user
	 * @return array list of user's wallet
	 */
	public ArrayList<Wallet> getWalletsOfUser(User user){
		ArrayList<Wallet> wallets = new ArrayList<>();
		for (Wallet w : getWallets())
			if (w != null && w.getUserAddress().equalsIgnoreCase(user.getPublicAddress())
			&& w.getUserSignature().equalsIgnoreCase(user.getSignature())) {
				wallets.add(w);	
			}
		return wallets;
	}

	/**
	 * getting bitcoin knots wallets of user
	 * @param user
	 * @return array list of user's wallet
	 */
	public ArrayList<WalletBitcoinKnots> getWalletsKnotsOfUser(User user){
		ArrayList<WalletBitcoinKnots> wallets = new ArrayList<>();
		for (WalletBitcoinKnots w : getWalletsKnots())
			if (w != null && w.getUserAddress().equalsIgnoreCase(user.getPublicAddress())
			&& w.getUserSignature().equalsIgnoreCase(user.getSignature())) {
				wallets.add(w);	
			}
		return wallets;
	}

	/**
	 * getting bitcoin space wallets of user
	 * @param user
	 * @return array list of user's wallet
	 */
	public ArrayList<WalletBitcoinSpace> getWalletsSpaceOfUser(User user){
		ArrayList<WalletBitcoinSpace> wallets = new ArrayList<>();
		for (WalletBitcoinSpace w : getWalletsSpace())
			if (w != null && w.getUserAddress().equalsIgnoreCase(user.getPublicAddress())
			&& w.getUserSignature().equalsIgnoreCase(user.getSignature())) {
				wallets.add(w);	
			}
		return wallets;
	}

	/**
	 * This method loads money to wallet
	 * @param wallet
	 * @param amount
	 */
	public void loadMoney(Wallet wallet, Double amount) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_LOAD_MONEY)) {

				int i = 1;
				stmt.setDouble(i++, amount);
				stmt.setString(i++, wallet.getUniqueAddress());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("UPDATE WALLET ");
	}
	/**
	 * generating a new wallet for user
	 * @param user
	 */
	public void generateWalletForNewUser(User user){
		String walletAddress;
		do {
			walletAddress = SysData.getInstance().generateRandomStrings(Consts.WALLET_ADDRESS_LENGTH);
			System.out.println(walletAddress);
		}
		while (getWallets().contains(new Wallet(walletAddress)));

		Wallet wallet = new Wallet(walletAddress, 0, true, false, false, 0, 0, user.getPublicAddress(), user.getSignature());
		insertWallet(wallet);
		
		// sending a message
		String title = "You Received a New Wallet!";
		String desc = "You received a new wallet (ID: " + wallet.getUniqueAddress() + "). You can view and edit it in Wallets Management in your profile.";
		UserLogic.getInstance().sendMessage(title, desc, user);
	}
}