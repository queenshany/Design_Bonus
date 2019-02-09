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
import entity.ItemInTransaction;
import entity.Transaction;

/**
 * This class represents the Item Management in the system: Item, ItemInTransaction, Categories
 * @author Shany Klein & Ofri Kokush
 *
 */
public class ItemLogic {
	private static ItemLogic instance;

	public static ItemLogic getInstance() {
		if (instance == null)
			instance = new ItemLogic();
		return instance;
	}

	// ***************************** INSERT QUERIES ***************************** 
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

		System.out.println("INSERT " + c);
	}

	/**
	 * Inserting an item to the DB
	 * @param item
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

		System.out.println("INSERT " + item);
	}

	/**
	 * Inserting an item to a transaction in the DB
	 * @param item
	 */
	public void insertItemIntoTrans(ItemInTransaction item) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_ITEM_INTO_TRANS);
				int i = 1;

				stmt.setInt(i++, item.getItem());
				stmt.setInt(i++, item.getTrans());
				if (item.getQuantity() <= 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, item.getQuantity());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + item);
	}

	// ***************************** DELETE QUERIES ***************************** 
	/**
	 * Deleting a category from the DB
	 * @param c
	 */
	public void deleteCategory(Category c) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_CATEGORY);
				int i = 1;

				stmt.setInt(i++, c.getSerialNumber());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("DELETE " + c);
	}

	/**
	 * Deleting an item from trans in the DB
	 * @param item
	 */
	public void deleteItemInTrans(ItemInTransaction item) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_ITEM_IN_TRANS);
				int i = 1;

				stmt.setInt(i++, item.getItem());
				stmt.setInt(i++, item.getTrans());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("DELETE " + item);
	}

	/**
	 * Deleting an item from the DB
	 * @param item
	 */
	public void deleteItem(Item item) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_ITEM);
				int i = 1;

				stmt.setInt(i++, item.getCatalogNumber());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("DELETE " + item);
	}

	// ***************************** UPDATE QUERIES *****************************

	/**
	 * Updates category values
	 * @param c
	 */
	public void updateCategory(Category c) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_CATEGORY)) {

				int i = 1;
				stmt.setString(i++, c.getCategoryName());
				stmt.setInt(i++, c.getSerialNumber());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + c);
	}
	
	/**
	 * Updates item in trans values
	 * @param item
	 */
	public void updateItemInTrans(ItemInTransaction item) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_ITEM_IN_TRANS)) {

				int i = 1;
				stmt.setInt(i++, item.getQuantity());
				stmt.setInt(i++, item.getItem());
				stmt.setInt(i++, item.getTrans());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + item);
	}
	
	/**
	 * Updates item in trans values
	 * @param item
	 */
	public void updateItem(Item item) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_ITEM)) {

				int i = 1;
				stmt.setString(i++, item.getItemName());
				stmt.setString(i++, item.getImage());
				stmt.setString(i++, item.getDescription());
				stmt.setDouble(i++, item.getPrice());
				stmt.setInt(i++, item.getQuantity());
				stmt.setInt(i++, item.getCategory());
				stmt.setInt(i++, item.getCatalogNumber());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + item);
	}
}
