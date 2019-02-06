package entity;
/**
 * This class represents a Participant In a Lottery in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Participant {
	private int lotteryNum;
	private String uniqueAddress;
	private boolean isWinner;

	//---------------------------- Constructors ----------------------------
	public Participant(int lotteryNum, String uniqueAddress) {
		this.lotteryNum = lotteryNum;
		this.uniqueAddress = uniqueAddress;
	}

	public Participant(int lotteryNum, String uniqueAddress, boolean isWinner) {
		this.lotteryNum = lotteryNum;
		this.uniqueAddress = uniqueAddress;
		this.isWinner = isWinner;
	}
	// ---------------------------- Getters & Setters ----------------------------
	public int getLotteryNum() {
		return lotteryNum;
	}

	public void setLotteryNum(int lotteryNum) {
		this.lotteryNum = lotteryNum;
	}

	public String getUniqueAddress() {
		return uniqueAddress;
	}

	public void setUniqueAddress(String uniqueAddress) {
		this.uniqueAddress = uniqueAddress;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lotteryNum;
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
		Participant other = (Participant) obj;
		if (lotteryNum != other.lotteryNum)
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
		return "Participant Lottery Num:" + lotteryNum + " | Unique Address: " + uniqueAddress + " | Is Winner: " + isWinner;
	}

}
