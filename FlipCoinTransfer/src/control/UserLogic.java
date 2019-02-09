package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Consts;
import entity.Message;
import entity.User;

/**
 * This class represents the Users & Messages Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class UserLogic {
	private static UserLogic instance;

	public static UserLogic getInstance() {
		if (instance == null)
			instance = new UserLogic();
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

				if (message.getUserAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, message.getUserAddress());

				if (message.getUserSignature() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, message.getUserSignature());

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
	 * Inserting a user to the DB
	 * @param user
	 */
	public void insertUser(User user) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_USER);
				int i = 1;

				stmt.setString(i++, user.getPublicAddress());

				if (user.getSignature() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, user.getSignature());

				if (user.getUsername() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, user.getUsername());

				if (user.getPassword() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, user.getPassword());

				if (user.getPhone() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, user.getPhone());

				if (user.getEmail() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, user.getEmail());

				if (user.getIsEmployee() == null)
					stmt.setNull(i++, java.sql.Types.BOOLEAN);
				else
					stmt.setBoolean(i++, user.getIsEmployee());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + user);

	}
	
	// ***************************** UPDATE QUERIES *****************************

	/**
	 * Updates User values
	 * @param user
	 */
	public void updateUser(User user) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_USER)) {

				int i = 1;

				if (user.getPassword() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, user.getPassword());

				if (user.getPhone() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, user.getPhone());

				if (user.getEmail() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, user.getEmail());

				if (user.getIsEmployee() == null)
					stmt.setNull(i++, java.sql.Types.BOOLEAN);
				else
					stmt.setBoolean(i++, user.getIsEmployee());

				stmt.setString(i++, user.getPublicAddress());

				if (user.getSignature() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, user.getSignature());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + user);
	}
}
