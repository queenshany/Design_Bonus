package entity;
/**
 * This class represents a Wallet Bitcoin Knots in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class WalletBitcoinKnots extends Wallet{
	private double discountPercent;

	//---------------------------- Constructors ----------------------------
	public WalletBitcoinKnots(String uniqueAddress, double price, boolean isOnPC, boolean isOnPhone, boolean isOnTablet,
			double amount, double pendingAmount, String userAddress, String userSignature, double discountPercent) {
		super(uniqueAddress, price, isOnPC, isOnPhone, isOnTablet, amount, pendingAmount, userAddress, userSignature);
		this.discountPercent = discountPercent;
	}

	//---------------------------- Getters & Setters ----------------------------
	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	//---------------------------- toString ----------------------------
	public String toString() {
		return "Bitcoin Knots " + super.toString() + " | Discount Percent: " + discountPercent;
	}
}
