package entity;
/**
 * This class represents a Received Bonus in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class GetBonus {
	private int lotteryNum;
	private String uniqueAddress;
	private int bonusNum;

	//---------------------------- Constructors ----------------------------
	public GetBonus(int lotteryNum, String uniqueAddress, int bonusNum) {
		this.lotteryNum = lotteryNum;
		this.uniqueAddress = uniqueAddress;
		this.bonusNum = bonusNum;
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

	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bonusNum;
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
		GetBonus other = (GetBonus) obj;
		if (bonusNum != other.bonusNum)
			return false;
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
		return "GetBonus Lottery Num: " + lotteryNum + " | Unique Address: " + uniqueAddress + " | Bonus Num: " + bonusNum;
	}
}
