package entity;

import java.sql.Date;
import java.sql.Time;

import utils.E_Status;

/**
 * This class represents a Riddle in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Riddle {
	private int riddleNum;
	private Date publishedDate;
	private Time publishedTime;
	private String description;
	private Date solutionDate;
	private Time solutionTime;
	private E_Status status;
	private int riddleLevel;

	// ---------------------------- Constructors ----------------------------
	public Riddle(int riddleNum) {
		this.riddleNum = riddleNum;
	}

	public Riddle(int riddleNum, Date publishedDate, Time publishedTime, String description, Date solutionDate,
			Time solutionTime, E_Status status, int riddleLevel) {
		this.riddleNum = riddleNum;
		this.publishedDate = publishedDate;
		this.publishedTime = publishedTime;
		this.description = description;
		this.solutionDate = solutionDate;
		this.solutionTime = solutionTime;
		this.status = status;
		this.riddleLevel = riddleLevel;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public int getRiddleNum() {
		return riddleNum;
	}

	public void setRiddleNum(int riddleNum) {
		this.riddleNum = riddleNum;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Time getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(Time publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSolutionDate() {
		return solutionDate;
	}

	public void setSolutionDate(Date solutionDate) {
		this.solutionDate = solutionDate;
	}

	public Time getSolutionTime() {
		return solutionTime;
	}

	public void setSolutionTime(Time solutionTime) {
		this.solutionTime = solutionTime;
	}

	public E_Status getStatus() {
		return status;
	}

	public void setStatus(E_Status status) {
		this.status = status;
	}

	public int getRiddleLevel() {
		return riddleLevel;
	}

	public void setRiddleLevel(int riddleLevel) {
		this.riddleLevel = riddleLevel;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + riddleNum;
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
		Riddle other = (Riddle) obj;
		if (riddleNum != other.riddleNum)
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Riddle Num:" + riddleNum + " | Published Date: " + publishedDate + " | Published Time: " + publishedTime
				+ " | Description: " + description + " | Solution Date: " + solutionDate + " | Solution Time: " + solutionTime
				+ " | Status: " + status + " | Riddle Level Code:" + riddleLevel;
	}
}
