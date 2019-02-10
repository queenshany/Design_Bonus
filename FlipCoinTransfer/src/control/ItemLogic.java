package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import entity.Category;
import entity.Consts;
import entity.Item;
import entity.ItemInTransaction;
import entity.Transaction;
import entity.User;

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

	// ***************************** SELECT QUERIES *****************************

	/**
	 * Loading Items from the DB to the system
	 * @return ALL of the Items from the DB
	 */
	public ArrayList<Item> getItems() {
		ArrayList<Item> results = new ArrayList<Item>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_ITEMS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Item(rs.getInt(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getDouble(i++),
							rs.getInt(i++),
							rs.getInt(i++),
							rs.getString(i++),
							rs.getString(i++)));
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
	 * Loading Categories from the DB to the system
	 * @return ALL of the Categories from the DB
	 */
	public ArrayList<Category> getCategories() {
		ArrayList<Category> results = new ArrayList<Category>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_CATEGORIES);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Category(rs.getInt(i++),
							rs.getString(i++)));
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
	 * generating id for new item
	 * @return id for new item
	 */
	public int getItemID() {
		ArrayList<Item> items = getItems();
		items.sort(new Comparator<Item>() {

			@Override
			public int compare(Item i1, Item i2) {
				return i1.getCatalogNumber()-i2.getCatalogNumber();
			}
		});

		if (!items.isEmpty())
			return items.get(items.size()-1).getCatalogNumber() + 1;
		return 1;
	}

	/**
	 * generating id for new category
	 * @return id for new category
	 */
	public int getCategoryID() {
		ArrayList<Category> categories = getCategories();
		categories.sort(new Comparator<Category>() {

			@Override
			public int compare(Category c1, Category c2) {
				return c1.getSerialNumber()-c2.getSerialNumber();
			}
		});

		if (!categories.isEmpty())
			return categories.get(categories.size()-1).getSerialNumber() + 1;
		return 1;
	}
	/**
	 * searching for an item based on relevant queries
	 * @return arraylist of searched items
	 */
	public ArrayList<Item> searchItem (Double minPrice, Double maxPrice, Category cat, String str, User seller){
		ArrayList<Item> items = getItems();

		// filtering by seller
		if (seller != null){
			ArrayList<Item> temp = new ArrayList<Item>();
			for (int i = 0; i < items.size(); i++)
				if (!items.get(i).getSellerAddress().equals(seller.getPublicAddress()) &&
					!items.get(i).getSellerSignature().equals(seller.getSignature())) 
					temp.add(items.get(i));
			items.removeAll(temp);
		}
		
		// filtering by min price
		if (minPrice != null) {
			ArrayList<Item> temp = new ArrayList<Item>();
			for (int i = 0; i < items.size(); i++)
				if (items.get(i).getPrice() < minPrice) 
					temp.add(items.get(i));
			items.removeAll(temp);
		}

		// filtering by max price
		if (maxPrice != null) {
			ArrayList<Item> temp = new ArrayList<Item>();
			for (int i = 0; i < items.size(); i++)
				if (items.get(i).getPrice() > maxPrice) 
					temp.add(items.get(i));
			items.removeAll(temp);
		}

		// filtering by category
		if (cat != null) {
			ArrayList<Item> temp = new ArrayList<Item>();
			for (int i = 0; i < items.size(); i++)
				if (items.get(i).getCategory() != cat.getSerialNumber()) 
					temp.add(items.get(i));
			items.removeAll(temp);
		}

		// filtering by string	~ product name & description
		if (str != null) {
			ArrayList<Item> temp = new ArrayList<Item>();
			for (int i = 0; i < items.size(); i++)
				if (!items.get(i).getItemName().toLowerCase().contains(str.toLowerCase()) &&
					!items.get(i).getDescription().toLowerCase().contains(str.toLowerCase())) 
					temp.add(items.get(i));
			items.removeAll(temp);
		}
		return items;
	}
}
