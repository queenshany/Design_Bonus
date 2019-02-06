package utils;
/**
 * This class represents a Transaction Type in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public enum E_Type {
	Pay("Pay"),
	Confirm("Confirm");
	
	private String text;
	
	E_Type(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
	
	public static E_Type getType(String text) {
		for (E_Type type : E_Type.values())
			if (type.text.equalsIgnoreCase(text))
				return type;
		return null;
	}
}
