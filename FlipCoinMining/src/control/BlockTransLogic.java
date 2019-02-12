package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.sql.Date;

import entity.Block;
import entity.Consts;
import entity.Miner;
import entity.Riddle;
import entity.SolvedRiddle;
import entity.Transaction;
import utils.E_Status;
import utils.E_TransStatus;
import utils.E_Type;

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

				if (t.getInsertionDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, t.getInsertionDate());
				
				if (t.getStatus() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, t.getStatus().toString());
				
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
		t.setStatus(E_TransStatus.Executed);

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_ATTACH_TRANS_TO_BLOCK)) {

				int i = 1;
				stmt.setString(i++, b.getBlockAddress());
				stmt.setDate(i++, t.getAdditionDate());
				stmt.setTime(i++, t.getAdditionTime());
				stmt.setString(i++, t.getStatus().toString());
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


	/**
	 * updating trans status
	 * @param t
	 */
	public void updateTransStatus(Transaction t) {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_TRANS_STATUS)) {

				int i = 1;
				stmt.setString(i++, t.getStatus().toString());
				stmt.setInt(i++, t.getID());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ***************************** SELECT QUERIES ***************************** 
	/**
	 * Loading blocks from the DB to the system
	 * @return ALL of the blocks
	 */
	public ArrayList<Block> getBlocks() {
		ArrayList<Block> results = new ArrayList<Block>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					//CallableStatement stmt = conn.prepareCall(Consts.SQL_TRANS_WITHOUT_BLOCK_QRY);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_BLOCKS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Block(rs.getString(i++),
							rs.getDate(i++),
							rs.getTime(i++),
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
	 * Loading trans from the DB to the system
	 * @return ALL of the trans 
	 */
	public ArrayList<Transaction> getTrans() {
		ArrayList<Transaction> results = new ArrayList<Transaction>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					//CallableStatement stmt = conn.prepareCall(Consts.SQL_TRANS_WITHOUT_BLOCK_QRY);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_TRANS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Transaction(rs.getInt(i++),
							rs.getInt(i++),
							E_Type.valueOf(rs.getString(i++)),
							rs.getDouble(i++),
							rs.getDate(i++),
							rs.getString(i++),
							rs.getDate(i++),
							rs.getTime(i++),
							E_TransStatus.valueOf(rs.getString(i++))
							));
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

	// ***************************** GENERAL QUERIES ***************************** 
	/**
	 * Loading trans from the DB to the system WITH STATUS WAITING
	 * @return ALL of the trans without blocks from the DB
	 */
	public ArrayList<Transaction> getTransWithoutBlock() {
		ArrayList<Transaction> results = new ArrayList<Transaction>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					//CallableStatement stmt = conn.prepareCall(Consts.SQL_TRANS_WITHOUT_BLOCK_QRY);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_TRANS_WITHOUT_BLOCK);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Transaction(rs.getInt(i++),
							rs.getInt(i++),
							E_Type.valueOf(rs.getString(i++)),
							rs.getDouble(i++),
							rs.getDate(i++),
							rs.getString(i++),
							rs.getDate(i++),
							rs.getTime(i++),
							E_TransStatus.valueOf(rs.getString(i++))
							));
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

	public ArrayList<Transaction> getTransInBlock(Block block) {
		ArrayList<Transaction> results = new ArrayList<Transaction>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					//CallableStatement stmt = conn.prepareCall(Consts.SQL_TRANS_WITHOUT_BLOCK_QRY);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_TRANS_IN_BLOCK)){
				if (block.getBlockAddress() != null) 
					stmt.setString(1, block.getBlockAddress());
				else 
					stmt.setNull(1, java.sql.Types.INTEGER);

				ResultSet rs = stmt.executeQuery();
				{
					while (rs.next()) {
						int i = 1;
						results.add(new Transaction(rs.getInt(i++),
								rs.getInt(i++),
								E_Type.valueOf(rs.getString(i++)),
								rs.getDouble(i++),
								rs.getDate(i++),
								rs.getString(i++),
								rs.getDate(i++),
								rs.getTime(i++),
								E_TransStatus.valueOf(rs.getString(i++))
								));
					}
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
	 * calculating the size left in block
	 * @param block
	 * @return the size left 
	 */
	public Integer calcBlockSizeLeft(Block block) {
		Integer transSize = new Integer(0);
		ArrayList<Transaction> trans = new ArrayList<>(getTransInBlock(block));

		for (Transaction t : trans) {
			transSize += t.getSize();
		}

		return block.getSize()-transSize;
	}


	/**
	 * this method sets transactions to irrelevant status
	 */
	public void setIrrelevantTransactions() {
		Date today = Date.valueOf(LocalDate.now());

		ArrayList<Transaction> trans = getTransWithoutBlock();

		for (Transaction t: trans) {
			if (t.getInsertionDate().before(today) &&
					(t.getStatus().equals(E_TransStatus.Waiting))){
				t.setStatus(E_TransStatus.Irrelevant);
				updateTransStatus(t);
			}
		}
	}

	/**
	 * getting blocks of miner
	 * @param blocks
	 * @return array list of miner blocks
	 */
	public ArrayList<Block> getBlocksOfMiner (Miner miner){
		ArrayList<Block> blocks = new ArrayList<>();
		for (Block b : getBlocks())
			if (b != null && b.getMinerAddress().equalsIgnoreCase(miner.getUniqueAddress())) {
				blocks.add(b);	
			}
		return blocks;		
	}
	/**
	 * creating a new block for miner
	 * @param solved
	 * @return
	 */
	//TODO
	public boolean generateBlockForMiner(SolvedRiddle solved) {
		Riddle riddle = RiddleLogic.getInstance().getRiddles().get(RiddleLogic.getInstance().getRiddles().indexOf(new Riddle(solved.getRiddleNum())));
		System.out.println(riddle);
		//int size = 
		return false;
	}
	
}
