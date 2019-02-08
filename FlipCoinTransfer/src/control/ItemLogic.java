package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Category;
import entity.Consts;
import entity.Transaction;

/**
 * This class represents the Item Management in the system: Item, ItemInTransaction, Categories
 * @author Shany Klein & Ofri Kokush
 *
 */
public class ItemLogic {
	
	/**
	 * Inserting a category to the DB
	 * @param c
	 */
	public void insertCategory(Category c) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_CATEGORY);
				//PreparedStatement stmt = conn.prepareStatement(Consts.INS_CATEGORY){
					int i = 1;
					
					stmt.setInt(i++, c.getSerialNumber());
					
					if (c.getCategoryName() == null)
						stmt.setNull(i++, java.sql.Types.VARCHAR);
					else
						stmt.setString(i++, c.getCategoryName());
					
					stmt.executeUpdate();
				
				} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(c);
	}
}
