package utils;
/**
 * This class represents a Transaction Type in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public enum E_TransType {
	Pay("Pay"),
	Confirm("Confirm");
	
	private String text;
	
	E_TransType(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
	
	public static E_TransType getType(String text) {
		for (E_TransType type : E_TransType.values())
			if (type.text.equalsIgnoreCase(text))
				return type;
		return null;
	}
}
