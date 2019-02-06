package entity;

import java.sql.Date;

/**
 * This class represents a Recommendation in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Recommendation {
private int recNum;
private Date creationDate;
private double probability;
private double recommendedFee;

//---------------------------- Constructors ----------------------------
public Recommendation(int recNum) {
	this.recNum = recNum;
}
public Recommendation(int recNum, Date creationDate, double probability, double recommendedFee) {
	this.recNum = recNum;
	this.creationDate = creationDate;
	this.probability = probability;
	this.recommendedFee = recommendedFee;
}

//---------------------------- Getters & Setters ----------------------------
public int getRecNum() {
	return recNum;
}
public void setRecNum(int recNum) {
	this.recNum = recNum;
}
public Date getCreationDate() {
	return creationDate;
}
public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}
public double getProbability() {
	return probability;
}
public void setProbability(double probability) {
	this.probability = probability;
}
public double getRecommendedFee() {
	return recommendedFee;
}
public void setRecommendedFee(double recommendedFee) {
	this.recommendedFee = recommendedFee;
}

//---------------------------- Hash & Equals ----------------------------
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + recNum;
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
	Recommendation other = (Recommendation) obj;
	if (recNum != other.recNum)
		return false;
	return true;
}

//---------------------------- toString ----------------------------
@Override
public String toString() {
	return "Recommendation Num: " + recNum + " | Creation Date: " + creationDate + " | Probability: " + probability
			+ " | Recommended Fee: " + recommendedFee;
}
}
