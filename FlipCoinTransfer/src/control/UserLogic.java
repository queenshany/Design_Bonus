package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Consts;
import entity.Item;
import entity.Message;

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

		System.out.println(message);
	}
}
