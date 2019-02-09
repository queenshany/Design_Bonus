package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Consts;
import entity.Message;
import entity.Riddle;
import entity.RiddleLevel;
import entity.Solution;
import entity.SolvedRiddle;

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

				if (s.getResult() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
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
}
