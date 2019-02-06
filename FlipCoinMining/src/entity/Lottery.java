package entity;

import java.sql.Date;

/**
 * This class represents a Lottery in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Lottery {
	private int lotteryNum;
	private Date lotteryDate;
	private int maxParticipants;
	private int numOfWinners;
	private int numOfBonuses;

	//---------------------------- Constructors ----------------------------
	public Lottery(int lotteryNum) {
		this.lotteryNum = lotteryNum;
	}

	public Lottery(int lotteryNum, Date lotteryDate, int maxParticipants, int numOfWinners, int numOfBonuses) {
		this.lotteryNum = lotteryNum;
		this.lotteryDate = lotteryDate;
		this.maxParticipants = maxParticipants;
		this.numOfWinners = numOfWinners;
		this.numOfBonuses = numOfBonuses;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public int getLotteryNum() {
		return lotteryNum;
	}

	public void setLotteryNum(int lotteryNum) {
		this.lotteryNum = lotteryNum;
	}

	public Date getLotteryDate() {
		return lotteryDate;
	}

	public void setLotteryDate(Date lotteryDate) {
		this.lotteryDate = lotteryDate;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public int getNumOfWinners() {
		return numOfWinners;
	}

	public void setNumOfWinners(int numOfWinners) {
		this.numOfWinners = numOfWinners;
	}

	public int getNumOfBonuses() {
		return numOfBonuses;
	}

	public void setNumOfBonuses(int numOfBonuses) {
		this.numOfBonuses = numOfBonuses;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lotteryNum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lottery other = (Lottery) obj;
		if (lotteryNum != other.lotteryNum)
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Lottery Num: " + lotteryNum + " | Date: " + lotteryDate + ", Max Participants: " + maxParticipants
				+ " | Num of Winners: " + numOfWinners + " | Num of Bonuses: " + numOfBonuses;
	}
}
