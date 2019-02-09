package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Consts;
import entity.Message;
import entity.Miner;
import entity.MinerCompany;

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
}
