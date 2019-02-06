package entity;
/**
 * This class represents a Wallet in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Wallet {
	private String uniqueAddress;
	private double price;
	private boolean isOnPC;
	private boolean isOnPhone;
	private boolean isOnTablet;
	private double amount;
	private double pendingAmount;
	private String userAddress;
	private String userSignature;

	//---------------------------- Constructors ----------------------------
	public Wallet(String uniqueAddress) {
		this.uniqueAddress = uniqueAddress;
	}

	public Wallet(String uniqueAddress, double price, boolean isOnPC, boolean isOnPhone, boolean isOnTablet, double amount,
			double pendingAmount, String userAddress, String userSignature) {
		this.uniqueAddress = uniqueAddress;
		this.price = price;
		this.isOnPC = isOnPC;
		this.isOnPhone = isOnPhone;
		this.isOnTablet = isOnTablet;
		this.amount = amount;
		this.pendingAmount = pendingAmount;
		this.userAddress = userAddress;
		this.userSignature = userSignature;
	}

	//---------------------------- Getters & Setters ----------------------------
	public String getUniqueAddress() {
		return uniqueAddress;
	}

	public void setUniqueAddress(String uniqueAddress) {
		this.uniqueAddress = uniqueAddress;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isOnPC() {
		return isOnPC;
	}

	public void setOnPC(boolean isOnPC) {
		this.isOnPC = isOnPC;
	}

	public boolean isOnPhone() {
		return isOnPhone;
	}

	public void setOnPhone(boolean isOnPhone) {
		this.isOnPhone = isOnPhone;
	}

	public boolean isOnTablet() {
		return isOnTablet;
	}

	public void setOnTablet(boolean isOnTablet) {
		this.isOnTablet = isOnTablet;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

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
		Wallet other = (Wallet) obj;
		if (uniqueAddress == null) {
			if (other.uniqueAddress != null)
				return false;
		} else if (!uniqueAddress.equals(other.uniqueAddress))
			return false;
		return true;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Wallet Unique Address: " + uniqueAddress + " | Price: " + price + " | isOnPC: " + isOnPC + " | isOnPhone: "
				+ isOnPhone + " | isOnTablet: " + isOnTablet + " | Amount: " + amount + " | Pending Amount: " + pendingAmount
				+ " | User Address: " + userAddress + " | User Signature: " + userSignature;
	}

}
