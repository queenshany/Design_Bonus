package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.JFrame;

import entity.Category;
import entity.Consts;
import entity.Message;
import entity.User;
import entity.WalletBitcoinSpace;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

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
	private void insertMessage(Message message) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
			//	CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_MESSAGE);
				PreparedStatement stmt = conn.prepareStatement(Consts.SQL_INS_MESSAGE);
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
	
	// ***************************** SELECT QUERIES *****************************
	
	/**
	 * Loading Users from the DB to the system
	 * @return ALL of the Users from the DB
	 */
	public ArrayList<User> getUsers() {
		ArrayList<User> results = new ArrayList<User>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_USERS);
					ResultSet rs = stmt.executeQuery())
			{
					while (rs.next()) {
					int i = 1;
					results.add(new User(rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getBoolean(i++)));
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
	 * sending a message to user
	 * @param string of message
	 */
	public void sendMessage (String title, String desc, User user) {
		Message message = new Message(getMessageID(), user.getPublicAddress(), user.getSignature());
		message.setTitle(title);
		message.setDescription(desc);
		message.setMessageDate(Date.valueOf(LocalDate.now()));
		message.setMessageTime(Time.valueOf(LocalTime.now()));

		insertMessage(message);
	}
	
	/**
	 * getting messages of user
	 * @param user
	 * @return array list of user's messages
	 */
	public ArrayList<Message> getMessagesOfUser (User user){
		ArrayList<Message> messages = new ArrayList<>();
		for (Message m : getMessages())
			if (m != null && m.getUserAddress().equalsIgnoreCase(user.getPublicAddress())
			&& m.getUserSignature().equalsIgnoreCase(user.getSignature())) {
				messages.add(m);	
			}
		messages.sort(new Comparator<Message>() {

			@Override
			public int compare(Message m1, Message m2) {
				if (m1.getMessageDate().after(m2.getMessageDate()))
					return -1;
				else if (m1.getMessageDate().before(m2.getMessageDate()))
					return 1;
				else
					return m2.getMessageTime().compareTo(m1.getMessageTime());
			}
		});
		return messages;		
	}
	
	/**
	 * producing Users report
	 * @return the report itself
	 */
	//TODO
	public JFrame produceUsersReport() {
		try {
			Class.forName(Consts.JDBC_STR);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR)){
				HashMap<String, Object> params = new HashMap<>();
				params.put("date", Date.valueOf(LocalDate.now()));
				JasperPrint print = JasperFillManager.fillReport(
						//getClass().getResourceAsStream("../boundary/TransactionStatusReport.jasper"),
						getClass().getResourceAsStream("/boundary/UsersReport.jasper"),
						params, conn);

				JFrame frame = new JFrame("Users Report");
				frame.getContentPane().add(new JRViewer(print));
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.pack();
				return frame;
			}
			catch (SQLException | JRException | NullPointerException e) {
				e.printStackTrace();
			}

		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
}
