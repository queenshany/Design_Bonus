package entity;
/**
 * This class represents a Recommendation For User in the system
 * @author Shany Klein & Ofri Kokush
 *
 */

import utils.E_Level;

public class RecommendedFor {
	private String userAddress;
	private String userSignature;
	private int recommendation;
	private E_Level commitmentLevel;

	//---------------------------- Constructors ----------------------------

	public RecommendedFor(String userAddress, String userSignature, int recommendation) {
		this.userAddress = userAddress;
		this.userSignature = userSignature;
		this.recommendation = recommendation;
	}

	public RecommendedFor(String userAddress, String userSignature, int recommendation, E_Level commitmentLevel) {
		this.userAddress = userAddress;
		this.userSignature = userSignature;
		this.recommendation = recommendation;
		this.commitmentLevel = commitmentLevel;
	}

	//---------------------------- Getters & Setters ----------------------------
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public E_Level getCommitmentLevel() {
		return commitmentLevel;
	}

	public void setCommitmentLevel(E_Level commitmentLevel) {
		this.commitmentLevel = commitmentLevel;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recommendation;
		result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = prime * result + ((userSignature == null) ? 0 : userSignature.hashCode());
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
		RecommendedFor other = (RecommendedFor) obj;
		if (recommendation != other.recommendation)
			return false;
		if (userAddress == null) {
			if (other.userAddress != null)
				return false;
		} else if (!userAddress.equals(other.userAddress))
			return false;
		if (userSignature == null) {
			if (other.userSignature != null)
				return false;
		} else if (!userSignature.equals(other.userSignature))
			return false;
		return true;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Recommended For | User Address: " + userAddress + ", User Signature: " + userSignature + " | Recommendation: "
				+ recommendation + " | Commitment Level: " + commitmentLevel;
	}
}
