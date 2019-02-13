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

import entity.Consts;
import entity.Lottery;
import entity.Message;
import entity.Miner;
import entity.Riddle;
import entity.RiddleLevel;
import entity.Solution;
import entity.SolvedRiddle;
import entity.Transaction;
import utils.E_Level;
import utils.E_Status;
import utils.E_TransStatus;
import utils.E_Type;

/**
 * This class represents the Riddle & Solution & Level Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class RiddleLogic {
	private static RiddleLogic instance;

	public static RiddleLogic getInstance() {
		if (instance == null)
			instance = new RiddleLogic();
		return instance;
	}

	// ***************************** INSERT QUERIES ***************************** 

	/**
	 * Inserting a riddle to the DB
	 * @param r
	 */
	public void insertRiddle(Riddle r) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_RIDDLE);
				int i = 1;

				stmt.setInt(i++, r.getRiddleNum());

				if (r.getPublishedDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, r.getPublishedDate());

				if (r.getPublishedTime() == null)
					stmt.setNull(i++, java.sql.Types.TIME);
				else
					stmt.setTime(i++, r.getPublishedTime());

				if (r.getDescription() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, r.getDescription());

				if (r.getSolutionDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, r.getSolutionDate());

				if (r.getSolutionTime() == null)
					stmt.setNull(i++, java.sql.Types.TIME);
				else
					stmt.setTime(i++, r.getSolutionTime());

				if (r.getStatus() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, r.getStatus().toString());

				if (r.getRiddleLevel() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, r.getRiddleLevel());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + r);
	}

	/**
	 * Inserting a riddle Level to the DB
	 * @param r
	 */
	public void insertRiddleLevel(RiddleLevel r) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_RIDDLE_LEVEL);
				int i = 1;

				stmt.setInt(i++, r.getLevelCode());

				if (r.getLevelName() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, r.getLevelName().toString());

				if (r.getDifficultyLevel() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, r.getDifficultyLevel());

				if (r.getBlockSize() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, r.getBlockSize());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + r);
	}

	/**
	 * Inserting a solution to the DB
	 * @param s
	 */
	public void insertSolution(Solution s) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_SOLUTION);
				int i = 1;

				stmt.setInt(i++, s.getRiddleNum());
				stmt.setInt(i++, s.getSolutionNum());

//				if (s.getResult() < 0)
//					stmt.setNull(i++, java.sql.Types.DOUBLE);
//				else
					stmt.setDouble(i++, s.getResult());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + s);
	}

	/**
	 * Inserting a solution to the DB
	 * @param s
	 */
	public void insertSolvedRiddle(SolvedRiddle sr) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_SOLVED_RIDDLE);
				int i = 1;

				stmt.setString(i++, sr.getUniqueAddress());
				stmt.setInt(i++, sr.getRiddleNum());

				if (sr.getSolvedDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, sr.getSolvedDate());

				if (sr.getSolvedTime() == null)
					stmt.setNull(i++, java.sql.Types.TIME);
				else
					stmt.setTime(i++, sr.getSolvedTime());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + sr);
	}

	// ***************************** UPDATE QUERIES ***************************** 

	/**
	 * Updates Riddle values
	 * @param r
	 */
	public void updateRiddle(Riddle r) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_RIDDLE)) {

				int i = 1;

				if (r.getSolutionDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, r.getSolutionDate());

				if (r.getSolutionTime() == null)
					stmt.setNull(i++, java.sql.Types.TIME);
				else
					stmt.setTime(i++, r.getSolutionTime());

				if (r.getStatus() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, r.getStatus().toString());

				if (r.getRiddleLevel() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, r.getRiddleLevel());

				stmt.setInt(i++, r.getRiddleNum());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + r);
	}

	/**
	 * Updates riddle Level values
	 * @param r
	 */
	public void updateRiddleLevel(RiddleLevel r) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_RIDDLE_LEVEL)) {

				int i = 1;

				if (r.getLevelName() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, r.getLevelName().toString());

				if (r.getDifficultyLevel() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, r.getDifficultyLevel());

				if (r.getBlockSize() < 0)
					stmt.setNull(i++, java.sql.Types.INTEGER);
				else
					stmt.setInt(i++, r.getBlockSize());

				stmt.setInt(i++, r.getLevelCode());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + r);
	}

	// ***************************** SELECT QUERIES ***************************** 
	/**
	 * Loading Riddles from the DB to the system
	 * @return ALL of the Riddles from the DB
	 */
	public ArrayList<Riddle> getRiddles() {
		ArrayList<Riddle> results = new ArrayList<Riddle>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_RIDDLES);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Riddle(rs.getInt(i++),
							rs.getDate(i++),
							rs.getTime(i++),
							rs.getString(i++),
							rs.getDate(i++),
							rs.getTime(i++),
							E_Status.valueOf(rs.getString(i++)),
							rs.getInt(i++)));
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
	 * Loading riddle Levels from the DB to the system
	 * @return ALL of the riddle Levels from the DB
	 */
	public ArrayList<RiddleLevel> getRiddleLevels() {
		ArrayList<RiddleLevel> results = new ArrayList<RiddleLevel>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_RIDDLE_LEVELS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new RiddleLevel(rs.getInt(i++),
							E_Level.valueOf(rs.getString(i++)),
							rs.getInt(i++),
							rs.getInt(i++)));
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
	 * Loading riddle Levels from the DB to the system
	 * @return ALL of the riddle Levels from the DB
	 */
	public ArrayList<SolvedRiddle> getSolvedRiddles(Riddle riddle) {
		ArrayList<SolvedRiddle> results = new ArrayList<SolvedRiddle>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_GET_SOLVED_RIDDLE_BY_NUM)){
				if (riddle.getRiddleNum() > 0) 
					stmt.setInt(1, riddle.getRiddleNum());
				else 
					return results;

				ResultSet rs = stmt.executeQuery();
				{
					while (rs.next()) {
						int i = 1;
						results.add(new SolvedRiddle(rs.getString(i++),
								rs.getInt(i++),
								rs.getDate(i++),
								rs.getTime(i++))
								);
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
	 * Loading Solutions from the DB to the system
	 * @return ALL of the Solutions from the DB
	 */
	public ArrayList<Solution> getSolutions() {
		ArrayList<Solution> results = new ArrayList<Solution>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_SOLUTIONS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Solution(rs.getInt(i++),
							rs.getInt(i++),
							rs.getDouble(i++)));
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
	 * generating id for new riddle
	 * @return id for new riddle
	 */
	public int getRiddleID() {
		ArrayList<Riddle> riddles = getRiddles();
		riddles.sort(new Comparator<Riddle>() {

			@Override
			public int compare(Riddle r1, Riddle r2) {
				return r1.getRiddleNum()-r2.getRiddleNum();
			}
		});

		if (!riddles.isEmpty())
			return riddles.get(riddles.size()-1).getRiddleNum() + 1;
		return 1;
	}

	/**
	 * generating id for new riddle Level
	 * @return id for new riddle Level
	 */
	public int getRiddleLevelID() {
		ArrayList<RiddleLevel> levels = getRiddleLevels();
		levels.sort(new Comparator<RiddleLevel>() {

			@Override
			public int compare(RiddleLevel r1, RiddleLevel r2) {
				return r1.getLevelCode()-r2.getLevelCode();
			}
		});

		if (!levels.isEmpty())
			return levels.get(levels.size()-1).getLevelCode() + 1;
		return 1;
	}
	/**
	 * checks if a miner solved a riddle first
	 * @return true
	 */
	public boolean isFirstSolved(Riddle riddle, Miner miner) {
		ArrayList<SolvedRiddle> riddles = getSolvedRiddles(riddle);
		if (riddles.get(0).getUniqueAddress().equals(miner.getUniqueAddress()))
			return true;
		return false;
	}
	/**
	 * checking if a miner solved a riddle correctly. if he solved first, we'll generate a block
	 * @return true if he did
	 */
	public boolean isSolvedCorrectly(ArrayList<Solution> solutions, Riddle riddle, Miner miner) {

		ArrayList<Solution> tempSols = new ArrayList<>();
		for (Solution sol: getSolutions()) {
			if (sol.getRiddleNum() == riddle.getRiddleNum()) {
				if (solutions.contains(sol))	
					tempSols.add(sol);
			}
		}

		// check if solution is correct
		if (tempSols.size() != solutions.size())
			return false;

		SolvedRiddle solved = new SolvedRiddle(miner.getUniqueAddress(),
				riddle.getRiddleNum(),
				Date.valueOf(LocalDate.now()),
				Time.valueOf(LocalTime.now()));
		// add to solved riddle table anyway
		insertSolvedRiddle(solved);

		// check if solved first

		// if solved first, update riddle status to solved and generate a block
		if (isFirstSolved(riddle, miner)) 
			BlockTransLogic.getInstance().generateBlockForMiner(miner, riddle);

		riddle.setStatus(E_Status.Solved);
		updateRiddle(riddle);

		return true;
	}
	/**
	 * updating riddle status to irrelevant
	 */
	public void updateRiddleStatusToIrrelevant(Riddle riddle) {
		if (riddle.getSolutionDate().before(Date.valueOf(LocalDate.now()))
				&& riddle.getSolutionTime().before(Time.valueOf(LocalTime.now()))
				&& riddle.getStatus().equals(E_Status.Unsolved)){
			riddle.setStatus(E_Status.Irrelevant);
		}
	}
}
