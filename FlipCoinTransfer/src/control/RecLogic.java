package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Consts;
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

		System.out.println(rec);
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

		System.out.println(rec);
	}
}
