package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import entity.Block;
import entity.Consts;
import entity.Lottery;
import entity.Message;
import entity.Miner;
import entity.MinerCompany;
import entity.Transaction;
import entity.User;

/**
 * This class represents the Miners & Companies & Messages Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class MinerLogic {
	private static MinerLogic instance;

	public static MinerLogic getInstance() {
		if (instance == null)
			instance = new MinerLogic();
		return instance;
	}

	// ***************************** INSERT QUERIES ***************************** 

	/**
	 * Inserting a message to the DB
	 * @param message
	 */
	public void insertMessage(Message message) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_MESSAGE);
				int i = 1;

				stmt.setInt(i++, message.getID());

				if (message.getUniqueAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, message.getUniqueAddress());

				if (message.getTitle() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, message.getTitle());

				if (message.getDescription() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, message.getDescription());

				if (message.getMessageDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, message.getMessageDate());

				if (message.getMessageTime() == null)
					stmt.setNull(i++, java.sql.Types.TIME);
				else
					stmt.setTime(i++, message.getMessageTime());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + message);
	}

	/**
	 * Inserting a miner company to the DB
	 * @param mc
	 */
	public void insertMinerCompany(MinerCompany mc) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_MINER_COMPANY);
				int i = 1;

				stmt.setString(i++, mc.getUniqueAddress());

				if (mc.getContactFirstName() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, mc.getContactFirstName());

				if (mc.getContactLastName() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, mc.getContactLastName());

				if (mc.getContactPhone() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, mc.getContactPhone());

				if (mc.getContactEmail() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, mc.getContactEmail());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + mc);
	}

	/**
	 * Inserting a miner to the DB
	 * @param m
	 */
	public void insertMiner(Miner m) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_MINER);
				int i = 1;

				stmt.setString(i++, m.getUniqueAddress());

				if (m.getMinerName() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, m.getMinerName());

				if (m.getPassword() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, m.getPassword());

				if (m.getEmail() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, m.getEmail());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + m);
	}

	// ***************************** UPLOAD QUERIES ***************************** 

	/**
	 * Updates Miner values
	 * @param m
	 */
	public void updateMiner(Miner m) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_MINER)) {

				int i = 1;

				if (m.getMinerName() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, m.getMinerName());

				if (m.getPassword() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, m.getPassword());

				if (m.getEmail() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, m.getEmail());

				stmt.setString(i++, m.getUniqueAddress());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + m);
	}

	/**
	 * Updates Miner Company values
	 * @param mc
	 */
	public void updateMiner(MinerCompany mc) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_MINER_COMPANY)) {

				int i = 1;

				if (mc.getContactFirstName() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, mc.getContactFirstName());

				if (mc.getContactLastName() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, mc.getContactLastName());

				if (mc.getContactPhone() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, mc.getContactPhone());

				if (mc.getContactEmail() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, mc.getContactEmail());

				stmt.setString(i++, mc.getUniqueAddress());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("UPDATE " + mc);
	}

	/**
	 * Updates Miner Profit values
	 * @param m
	 */
	/**
	 * This method updates the miner's digital profit
	 * @param trans
	 * @param block
	 */
	public void updateProfit(Transaction trans, Block block) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_MINER_PROFIT)) {

				int i = 1;
				stmt.setDouble(i++, trans.getFee());
				stmt.setString(i++, block.getMinerAddress());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("UPDATE PROFIT ");
	}

	// ***************************** SELECT QUERIES ***************************** 
	/**
	 * Loading Messages from the DB to the system
	 * @return ALL of the Messages from the DB
	 */
	public ArrayList<Message> getMessages() {
		ArrayList<Message> results = new ArrayList<Message>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_MESSAGES);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Message(rs.getInt(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getDate(i++),
							rs.getTime(i++)));
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
	 * Loading Miners from the DB to the system
	 * @return ALL of the Miners from the DB
	 */
	public ArrayList<Miner> getMiners() {
		ArrayList<Miner> results = new ArrayList<Miner>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_MINERS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Miner(rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getDouble(i++)));
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
	 * generating id for new message
	 * @return id for new message
	 */
	public int getMessageID() {
		ArrayList<Message> messages = getMessages();
		messages.sort(new Comparator<Message>() {

			@Override
			public int compare(Message m1, Message m2) {
				return m1.getID()-m2.getID();
			}
		});
		
		if (!messages.isEmpty())
			return messages.get(messages.size()-1).getID() + 1;
		return 1;
	}
	
	/**
	 * getting messages of miner
	 * @param miner
	 * @return array list of miner's messages
	 */
	public ArrayList<Message> getMessagesOfMiner (Miner miner){
		ArrayList<Message> messages = new ArrayList<>();
		for (Message m : getMessages())
			if (m != null && m.getUniqueAddress().equalsIgnoreCase(miner.getUniqueAddress())) {
				messages.add(m);	
			}
		return messages;		
	}
}
