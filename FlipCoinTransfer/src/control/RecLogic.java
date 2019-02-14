package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.JFrame;

import entity.Category;
import entity.Consts;
import entity.Item;
import entity.Message;
import entity.Recommendation;
import entity.RecommendedFor;
import entity.User;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import utils.E_Level;

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

	// ***************************** UPDATE QUERIES *****************************

	/**
	 * Updates Level of User in Recommendation value
	 * @param rec
	 */
	public void updateUserInRec(RecommendedFor rec) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_USER_IN_REC)) {

				int i = 1;
				stmt.setString(i++, rec.getCommitmentLevel().toString());
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
		System.out.println("UPDATE " + rec);
	}

	/**
	 * Updates Recommendation values
	 * @param rec
	 */
	public void updateRecommendation(Recommendation rec) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_REC)) {

				int i = 1;
				stmt.setDouble(i++, rec.getRecommendedFee());
				stmt.setBoolean(i++, rec.getIsApproved());
				stmt.setInt(i++, rec.getRecNum());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + rec);
	}

	// ***************************** SELECT QUERIES *****************************

	/**
	 * Loading Recommendations from the DB to the system
	 * @return ALL of the Recommendations from the DB
	 */
	public ArrayList<Recommendation> getRecommendations() {
		ArrayList<Recommendation> results = new ArrayList<Recommendation>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_RECOMMENDATIONS);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Recommendation(rs.getInt(i++),
							rs.getDate(i++),
							rs.getDouble(i++),
							rs.getDouble(i++),
							rs.getBoolean(i++)));
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
	 * Loading Recommendations FOR from the DB to the system
	 * @return ALL of the Recommendations FOR from the DB
	 */
	public ArrayList<RecommendedFor> getRecommendationsFor() {
		ArrayList<RecommendedFor> results = new ArrayList<>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_REC_FOR);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new RecommendedFor(rs.getString(i++),
							rs.getString(i++),
							rs.getInt(i++),
							E_Level.valueOf(rs.getString(i++)))
							);
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
	 * Calculating the probability to be chosen
	 * @param date of the probability
	 * @return the probability to be chosen
	 */
	public Double calcProbability(Date date) {
		Double result = 0.0;

		if (TransLogic.getInstance().getTransAmountPerDate(date) == 0)
			return result;
		else {
			try {
				Class.forName(Consts.JDBC_STR);
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_REC_CALC_PROBABILITY)){
					int i = 1;
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
	// ***************************** GENERAL METHODS *****************************
	/**
	 * generating id for new rec
	 * @return id for new rec
	 */
	public int getRecID() {
		ArrayList<Recommendation> recs = getRecommendations();
		recs.sort(new Comparator<Recommendation>() {

			@Override
			public int compare(Recommendation r1, Recommendation r2) {
				return r1.getRecNum()-r2.getRecNum();
			}
		});

		if (!recs.isEmpty())
			return recs.get(recs.size()-1).getRecNum() + 1;
		return 1;
	}
	
	/**
	 * producing View Recommendations report
	 * @param user
	 * @return the report itself
	 */
	//TODO
	public JFrame produceViewRecommendationsReport(User u) {
		try {
			Class.forName(Consts.JDBC_STR);
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR)){
				HashMap<String, Object> params = new HashMap<>();
				params.put("userAddress", u.getPublicAddress());
				params.put("userSignature", u.getSignature());
				JasperPrint print = JasperFillManager.fillReport(
						//getClass().getResourceAsStream("../boundary/TransactionStatusReport.jasper"),
						getClass().getResourceAsStream("/boundary/ViewRecommendations.jasper"),
						params, conn);

				JFrame frame = new JFrame("View Recommendations Report");
				frame.getContentPane().add(new JRViewer(print));
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.pack();
				return frame;
			}
			catch (SQLException | JRException | NullPointerException e) {
				e.printStackTrace();
			}

		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
}
