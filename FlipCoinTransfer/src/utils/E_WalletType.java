package utils;
/**
 * This class represents a Wallet Type in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public enum E_WalletType {
	Wallet("Wallet"),
	WalletBitcoinKnots("WalletBitcoinKnots"),
	WalletBitcoinSpace("WalletBitcoinSpace");

	private String text;

	E_WalletType(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}

	public static E_WalletType getType(String text) {
		for (E_WalletType type : E_WalletType.values())
			if (type.text.equalsIgnoreCase(text))
				return type;
		return null;
	}
}
