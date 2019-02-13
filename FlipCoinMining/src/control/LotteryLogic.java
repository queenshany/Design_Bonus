package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import entity.Block;
import entity.Bonus;
import entity.Consts;
import entity.GetBonus;
import entity.Lottery;
import entity.Miner;
import entity.Participant;
import entity.Riddle;
import entity.SolvedRiddle;
import entity.Transaction;

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

	/**
	 * Updates Lottery values
	 * @param lot
	 */
	public void updateParticipant(Participant p) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPD_PARTICIPANT)) {

				int i = 1;

				stmt.setBoolean(i++, p.isWinner());

				if (p.getUniqueAddress() == null)
					stmt.setNull(i++, java.sql.Types.VARCHAR);
				else
					stmt.setString(i++, p.getUniqueAddress());

				stmt.setInt(i++, p.getLotteryNum());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UPDATE " + p);
	}


	// ***************************** SELECT QUERIES ***************************** 
	/**
	 * Loading Lotteries from the DB to the system
	 * @return ALL of the Lotteries from the DB
	 */
	public ArrayList<Lottery> getLotteries() {
		ArrayList<Lottery> results = new ArrayList<Lottery>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_LOTTERIES);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Lottery(rs.getInt(i++),
							rs.getDate(i++),
							rs.getInt(i++),
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
	 * Loading Lotteries from the DB to the system
	 * @return ALL of the Lotteries from the DB
	 */
	public ArrayList<Bonus> getBonuses() {
		ArrayList<Bonus> results = new ArrayList<Bonus>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_BONUSES);
					ResultSet rs = stmt.executeQuery())
			{
				while (rs.next()) {
					int i = 1;
					results.add(new Bonus(rs.getInt(i++),
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
	 * Loading lotteries by date from the DB to the system
	 * @return lotteries by date from the DB
	 */
	public ArrayList<Lottery> getLotteriesByDate(Date date) {
		ArrayList<Lottery> results = new ArrayList<Lottery>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_GET_LOTTERIES_BY_DATE)){
				if (date != null) 
					stmt.setDate(1, date);
				else 
					return results;

				ResultSet rs = stmt.executeQuery();
				{
					while (rs.next()) {
						int i = 1;
						results.add(new Lottery(rs.getInt(i++),
								rs.getDate(i++),
								rs.getInt(i++),
								rs.getInt(i++),
								rs.getInt(i++))
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
	 * Loading lotteries by date from the DB to the system
	 * @return lotteries by date from the DB
	 */
	public ArrayList<Participant> getLotteryParticipants(Lottery lot) {
		ArrayList<Participant> results = new ArrayList<Participant>();

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_GET_LOTTERY_PARTICIPANTS)){
				if (lot.getLotteryNum() < 0) 
					stmt.setInt(1, lot.getLotteryNum());
				else 
					return results;

				ResultSet rs = stmt.executeQuery();
				{
					while (rs.next()) {
						int i = 1;
						results.add(new Participant(rs.getInt(i++),
								rs.getString(i++),
								rs.getBoolean(i++))
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
	// ***************************** GENERAL METHODS *****************************
	/**
	 * generating id for new bonus
	 * @return id for new bonus
	 */
	public int getBonusID() {
		ArrayList<Bonus> bonuses = getBonuses();
		bonuses.sort(new Comparator<Bonus>() {

			@Override
			public int compare(Bonus b1, Bonus b2) {
				return b1.getBonusNum()-b2.getBonusNum();
			}
		});

		if (!bonuses.isEmpty())
			return bonuses.get(bonuses.size()-1).getBonusNum() + 1;
		return 1;
	}

	/**
	 * generating id for new lottery
	 * @return id for new lottery
	 */
	public int getLotteryID() {
		ArrayList<Lottery> lots = getLotteries();
		lots.sort(new Comparator<Lottery>() {

			@Override
			public int compare(Lottery l1, Lottery l2) {
				return l1.getLotteryNum()-l2.getLotteryNum();
			}
		});

		if (!lots.isEmpty())
			return lots.get(lots.size()-1).getLotteryNum() + 1;
		return 1;
	}

	/**
	 * this method generates random bonuses for winner
	 */
	//TODO
	public void generateBonusForWinnerInLottery(Miner miner, Lottery lottery) {

	}
	/**
	 * this method chooses who won in a lottery
	 */
	//TODO
	public void generateWinnersInLottery(Lottery lottery) {
		ArrayList<Participant> p = getLotteryParticipants(lottery);
		ArrayList<Participant> winners = new ArrayList<>();
		if (p.size() < lottery.getNumOfWinners())
			winners.addAll(p);
		else {
			do {
				Random randomGenerator = new Random();
				int index = randomGenerator.nextInt(p.size());
				if (!winners.contains(p.get(index)))
					winners.add(p.get(index));
			}while(winners.size() < lottery.getNumOfWinners());
		}
		
		for (Participant par : winners) {
			par.setWinner(true);
			updateParticipant(par);
		}
	}
	/**
	 * this method performs a lottery, if its date has arrived
	 */
	public void performLottery() {
		ArrayList<Lottery> lotteries = getLotteriesByDate(Date.valueOf(LocalDate.now()));
		for (Lottery lot: lotteries) {
			generateWinnersInLottery(lot);
		}
	}

	/**
	 * this method allows a miner to join a lottery, if there's enough room
	 */
	//TODO
	public void joinLottery(Miner miner, Lottery lottery) {

	}
}
