package entity;
/**
 * This class represents a Bonus in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Bonus {
	private int bonusNum;
	private String description;

	//---------------------------- Constructors ----------------------------
	public Bonus(int bonusNum) {
		this.bonusNum = bonusNum;
	}

	public Bonus(int bonusNum, String description) {
		this.bonusNum = bonusNum;
		this.description = description;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bonusNum;
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
		Bonus other = (Bonus) obj;
		if (bonusNum != other.bonusNum)
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Bonus Num: " + bonusNum + " | Description: " + description;
	}


}
