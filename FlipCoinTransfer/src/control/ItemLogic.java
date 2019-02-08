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
import entity.Item;
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
	
	/**
	 * Inserting an item to the DB
	 * @param c
	 */
	public void insertItem(Item item) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_ITEM);
					int i = 1;

					stmt.setInt(i++, item.getCatalogNumber());
					
					if (item.getItemName() == null)
						stmt.setNull(i++, java.sql.Types.VARCHAR);
					else
						stmt.setString(i++, item.getItemName());
					
					if (item.getImage() == null)
						stmt.setNull(i++, java.sql.Types.VARCHAR);
					else
						stmt.setString(i++, item.getImage());
					
					if (item.getDescription() == null)
						stmt.setNull(i++, java.sql.Types.VARCHAR);
					else
						stmt.setString(i++, item.getDescription());
					
					if (item.getPrice() < 0)
						stmt.setNull(i++, java.sql.Types.DOUBLE);
					else
						stmt.setDouble(i++, item.getPrice());
					
					if (item.getQuantity() < 0)
						stmt.setNull(i++, java.sql.Types.INTEGER);
					else
						stmt.setInt(i++, item.getQuantity());
					
					if (item.getCategory() < 0)
						stmt.setNull(i++, java.sql.Types.INTEGER);
					else
						stmt.setInt(i++, item.getCategory());
					
					if (item.getSellerAddress() == null)
						stmt.setNull(i++, java.sql.Types.VARCHAR);
					else
						stmt.setString(i++, item.getSellerAddress());
					
					if (item.getSellerSignature() == null)
						stmt.setNull(i++, java.sql.Types.VARCHAR);
					else
						stmt.setString(i++, item.getSellerSignature());
					
					stmt.executeUpdate();
				
				} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(item);
	}
}
