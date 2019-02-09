package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import entity.Consts;
import entity.Item;
import entity.Message;
import entity.Recommendation;
import entity.RecommendedFor;

/**
 * This class represents the Recommendation Management in the system: Recommendation, RecommendationFor
 * @author Shany Klein & Ofri Kokush
 *
 */
public class RecLogic {
	private static RecLogic instance;

	public static RecLogic getInstance() {
		if (instance == null)
			instance = new RecLogic();
		return instance;
	}

	// ***************************** INSERT QUERIES *****************************
	/**
	 * Inserting a recommendation to the DB
	 * @param rec
	 */
	public void insertRecommendation(Recommendation rec) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_RECOMMENDATION);
				int i = 1;

				stmt.setInt(i++, rec.getRecNum());

				if (rec.getCreationDate() == null)
					stmt.setNull(i++, java.sql.Types.DATE);
				else
					stmt.setDate(i++, rec.getCreationDate());

				if (rec.getProbability() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, rec.getProbability());

				if (rec.getRecommendedFee() < 0)
					stmt.setNull(i++, java.sql.Types.DOUBLE);
				else
					stmt.setDouble(i++, rec.getRecommendedFee());

				if (rec.getIsApproved() == null)
					stmt.setNull(i++, java.sql.Types.BOOLEAN);
				else
					stmt.setBoolean(i++, rec.getIsApproved());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + rec);
	}

	/**
	 * Inserting a recommendation for user to the DB
	 * @param rec
	 */
	public void insertRecommendedFor(RecommendedFor rec) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_RECOMMENDATION_FOR_USER);
				int i = 1;

				if (rec.getUserAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, rec.getUserAddress());

				if (rec.getUserSignature() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, rec.getUserSignature());

				stmt.setInt(i++, rec.getRecommendation());

				if (rec.getCommitmentLevel() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, rec.getCommitmentLevel().toString());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("INSERT " + rec);
	}

	// ***************************** DELETE QUERIES *****************************

	/**
	 * Deleting a recommendation from the DB
	 * @param rec
	 */
	public void deleteRecommendation(Recommendation rec) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_RECOMMENDATION);
				int i = 1;

				stmt.setInt(i++, rec.getRecNum());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("DELETE " + rec);
	}

	/**
	 * Deleting a recommendation from the DB
	 * @param rec
	 */
	public void deleteUserInRec(RecommendedFor rec) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try {
				Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_USER_IN_REC);
				int i = 1;

				stmt.setString(i++, rec.getUserAddress());
				stmt.setString(i++, rec.getUserSignature());
				stmt.setInt(i++, rec.getRecommendation());

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("DELETE " + rec);
	}

	// ***************************** GENERAL QUERIES *****************************

	/**
	 * Calculating the probability to be chosen
	 * @param date of the probability
	 * @return the probability to be chosen
	 */
	public Double calcProbability(Date date) {
		Double result = 0.0;

		try {
			Class.forName(Consts.JDBC_STR);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_REC_CALC_PROBABILITY)){
				int i=1;
				while (i < 6) {
					if (date != null) 
						stmt.setDate(i++, date);
					else 
						stmt.setNull(i++, java.sql.Types.DATE);
				}
				ResultSet rs = stmt.executeQuery();
				//System.err.println(rs.toString());
				while (rs.next())
				{
					result = rs.getDouble(1);
				}
				//return results;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
