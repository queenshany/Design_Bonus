package entity;

import java.sql.Date;
import java.sql.Time;

/**
 * This class represents a Solved Riddle in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class SolvedRiddle {
	private String uniqueAddress;
	private int riddleNum;
	private Date solvedDate;
	private Time solvedTime;

	//---------------------------- Constructors ----------------------------
	public SolvedRiddle(String uniqueAddress, int riddleNum) {
		this.uniqueAddress = uniqueAddress;
		this.riddleNum = riddleNum;
	}
	public SolvedRiddle(String uniqueAddress, int riddleNum, Date solvedDate, Time solvedTime) {
		this.uniqueAddress = uniqueAddress;
		this.riddleNum = riddleNum;
		this.solvedDate = solvedDate;
		this.solvedTime = solvedTime;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public String getUniqueAddress() {
		return uniqueAddress;
	}
	public void setUniqueAddress(String uniqueAddress) {
		this.uniqueAddress = uniqueAddress;
	}
	public int getRiddleNum() {
		return riddleNum;
	}
	public void setRiddleNum(int riddleNum) {
		this.riddleNum = riddleNum;
	}
	public Date getSolvedDate() {
		return solvedDate;
	}
	public void setSolvedDate(Date solvedDate) {
		this.solvedDate = solvedDate;
	}
	public Time getSolvedTime() {
		return solvedTime;
	}
	public void setSolvedTime(Time solvedTime) {
		this.solvedTime = solvedTime;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + riddleNum;
		result = prime * result + ((uniqueAddress == null) ? 0 : uniqueAddress.hashCode());
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
		SolvedRiddle other = (SolvedRiddle) obj;
		if (riddleNum != other.riddleNum)
			return false;
		if (uniqueAddress == null) {
			if (other.uniqueAddress != null)
				return false;
		} else if (!uniqueAddress.equals(other.uniqueAddress))
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "SolvedRiddle Miner Unique Address: " + uniqueAddress + " | Riddle Num: " + riddleNum + " | Solved Date: " + solvedDate
				+ " | Solved Time: " + solvedTime;
	}


}
