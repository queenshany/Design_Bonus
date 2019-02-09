package entity;
/**
 * This class represents a Miner in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Miner {
	private String uniqueAddress;
	private String minerName;
	private String password;
	private String email;
	private double digitalProfit;

	// ---------------------------- Constructors ----------------------------
	public Miner(String uniqueAddress) {
		this.uniqueAddress = uniqueAddress;
	}

	public Miner(String uniqueAddress, String minerName, String password, String email, double digitalProfit) {
		this.uniqueAddress = uniqueAddress;
		this.minerName = minerName;
		this.password = password;
		this.email = email;
		this.digitalProfit = digitalProfit;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public String getUniqueAddress() {
		return uniqueAddress;
	}

	public void setUniqueAddress(String uniqueAddress) {
		this.uniqueAddress = uniqueAddress;
	}

	public String getMinerName() {
		return minerName;
	}

	public void setMinerName(String minerName) {
		this.minerName = minerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getDigitalProfit() {
		return digitalProfit;
	}

	public void setDigitalProfit(double digitalProfit) {
		this.digitalProfit = digitalProfit;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Miner other = (Miner) obj;
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
		return "Miner Unique Address: " + uniqueAddress + " | Miner Name: " + minerName + " | Email: "
				+ email + " | Digital Profit: " + digitalProfit;
	}


}
