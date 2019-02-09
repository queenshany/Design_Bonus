package utils;
/**
 * This enum class represents the Net Mode in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public enum E_NetMode {
	High("High"),
	Normal("Normal");
	
	private String text;
	
	E_NetMode(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
	
	public static E_NetMode getNetMode(String text) {
		for (E_NetMode mode : E_NetMode.values())
			if (mode.text.equalsIgnoreCase(text))
				return mode;
		return null;
	}
}
