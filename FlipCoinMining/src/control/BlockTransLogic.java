package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;

import entity.Block;
import entity.Bonus;
import entity.Consts;
import entity.Transaction;

/**
 * This class represents the Block & Transaction Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class BlockTransLogic {
	private static BlockTransLogic instance;

	public static BlockTransLogic getInstance() {
		if (instance == null)
			instance = new BlockTransLogic();
		return instance;
	}

	// ***************************** INSERT QUERIES ***************************** 
	/**
	 * Inserting a block to the DB
	 * @param b
	 */
	public void insertBlock(Block b) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_BLOCK);
				int i = 1;

				stmt.setString(i++, b.getBlockAddress());

				if (b.getCreationDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, b.getCreationDate());

				if (b.getCreationTime() == null)
					stmt.setNull(i++, java.sql.Types.TIME);
				else
					stmt.setTime(i++, b.getCreationTime());

				if (b.getSize() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, b.getSize());

				if (b.getPreviousBlock() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, b.getPreviousBlock());

				if (b.getMinerAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, b.getMinerAddress());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + b);
	}

	/**
	 * Inserting a transaction to the DB
	 * @param t
	 */
	public void insertTrans(Transaction t) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_TRANS);
				int i = 1;

				stmt.setInt(i++, t.getID());

				if (t.getSize() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, t.getSize());

				if (t.getType() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, t.getType().toString());

				if (t.getFee() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, t.getFee());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + t);
	}
	
	// ***************************** UPDATE QUERIES ***************************** 
/**
 * Attaching trans to block
 * @param t
 * @param b
 */
	public void attachTransToBlock(Transaction t, Block b) {
		
		t.setAdditionDate(Date.valueOf(LocalDate.now()));
		t.setAdditionTime(Time.valueOf(LocalTime.now()));
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_ATTACH_TRANS_TO_BLOCK)) {

				int i = 1;
				stmt.setString(i++, b.getBlockAddress());
				stmt.setDate(i++, t.getAdditionDate());
				stmt.setTime(i++, t.getAdditionTime());
				stmt.setInt(i++, t.getID());
				
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("ATTACHED " + t);
		System.out.println("TO " + b);
	}
}
