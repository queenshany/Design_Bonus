package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Block;
import entity.Bonus;
import entity.Consts;
import entity.GetBonus;
import entity.Lottery;
import entity.Participant;

/**
 * This class represents the Lottery & Bonus Management in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class LotteryLogic {
	private static LotteryLogic instance;

	public static LotteryLogic getInstance() {
		if (instance == null)
			instance = new LotteryLogic();
		return instance;
	}
	

	// ***************************** INSERT QUERIES ***************************** 
		/**
		 * Inserting a bonus to the DB
		 * @param b
		 */
		public void insertBonus(Bonus b) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try {
					Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_BONUS);
					int i = 1;

					stmt.setInt(i++, b.getBonusNum());

					if (b.getDescription() == null)
						stmt.setNull(i++, java.sql.Types.VARCHAR);
					else
						stmt.setString(i++, b.getDescription());
					
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
		 * Inserting a bonus received to the DB
		 * @param b
		 */
		public void insertGetBonus(GetBonus b) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try {
					Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_GET_BONUS);
					int i = 1;

					stmt.setInt(i++, b.getLotteryNum());
					stmt.setString(i++, b.getUniqueAddress());
					stmt.setInt(i++, b.getBonusNum());

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
		 * Inserting a lottery to the DB
		 * @param lot
		 */
		public void insertLottery(Lottery lot) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try {
					Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_LOTTERY);
					int i = 1;

					stmt.setInt(i++, lot.getLotteryNum());

					if (lot.getLotteryDate() == null)
						stmt.setNull(i++, java.sql.Types.DATE);
					else
						stmt.setDate(i++, lot.getLotteryDate());
					
					if (lot.getMaxParticipants() < 0)
						stmt.setNull(i++, java.sql.Types.INTEGER);
					else
						stmt.setInt(i++, lot.getMaxParticipants());
					
					if (lot.getNumOfWinners() < 0)
						stmt.setNull(i++, java.sql.Types.INTEGER);
					else
						stmt.setInt(i++, lot.getNumOfWinners());
					
					if (lot.getNumOfBonuses() < 0)
						stmt.setNull(i++, java.sql.Types.INTEGER);
					else
						stmt.setInt(i++, lot.getNumOfBonuses());
					
					stmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			System.out.println("INSERT " + lot);
		}
		
		/**
		 * Inserting a participant in a lottery received to the DB
		 * @param p
		 */
		public void insertParticipant(Participant p) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try {
					Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_GET_BONUS);
					int i = 1;

					stmt.setInt(i++, p.getLotteryNum());
					stmt.setString(i++, p.getUniqueAddress());
					stmt.setBoolean(i++, p.isWinner());

					stmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			System.out.println("INSERT " + p);
		}
		
		// ***************************** DELETE QUERIES ***************************** 
		
		/**
		 * Deleting a bonus from the DB
		 * @param b
		 */
		public void deleteBonus(Bonus b) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try {
					Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_DEL_BONUS);
					int i = 1;

					stmt.setInt(i++, b.getBonusNum());

					stmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("DELETE " + b);
		}
		
		// ***************************** UPDATE QUERIES *****************************
		
		/**
		 * Updates Bonus values
		 * @param b
		 */
		public void updateBonus(Bonus b) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_BONUS)) {

					int i = 1;
					stmt.setString(i++, b.getDescription());
					stmt.setInt(i++, b.getBonusNum());

					stmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("UPDATE " + b);
		}
		
		/**
		 * Updates Lottery values
		 * @param lot
		 */
		public void updateLottery(Lottery lot) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_LOTTERY)) {

					int i = 1;
					
					if (lot.getLotteryDate() == null)
						stmt.setNull(i++, java.sql.Types.DATE);
					else
						stmt.setDate(i++, lot.getLotteryDate());
					
					if (lot.getMaxParticipants() < 0)
						stmt.setNull(i++, java.sql.Types.INTEGER);
					else
						stmt.setInt(i++, lot.getMaxParticipants());
					
					if (lot.getNumOfWinners() < 0)
						stmt.setNull(i++, java.sql.Types.INTEGER);
					else
						stmt.setInt(i++, lot.getNumOfWinners());
					
					if (lot.getNumOfBonuses() < 0)
						stmt.setNull(i++, java.sql.Types.INTEGER);
					else
						stmt.setInt(i++, lot.getNumOfBonuses());
					
					stmt.setInt(i++, lot.getLotteryNum());

					stmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("UPDATE " + lot);
		}
}
