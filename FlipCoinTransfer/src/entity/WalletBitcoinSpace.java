package entity;
/**
 * This class represents a Wallet Bitcoin Space in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class WalletBitcoinSpace extends Wallet{
	private int transSize;

	//---------------------------- Constructors ----------------------------
	public WalletBitcoinSpace(String uniqueAddress, double price, boolean isOnPC, boolean isOnPhone, boolean isOnTablet,
			double amount, double pendingAmount, String userAddress, String userSignature, int transSize) {
		super(uniqueAddress, price, isOnPC, isOnPhone, isOnTablet, amount, pendingAmount, userAddress, userSignature);
		this.transSize = transSize;
	}

	//---------------------------- Getters & Setters ----------------------------
	public double getTransSize() {
		return transSize;
	}

	public void setTransSize(int transSize) {
		this.transSize = transSize;
	}

	//---------------------------- toString ----------------------------
	public String toString() {
		return "Bitcoin Space " + super.toString() + " | Transaction Size: " + transSize;
	}
}