package utils;
/**
 * This enum class represents a Status in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public enum E_Status {
	Pending("Pending"),
	Executed("Executed"),
	Irrelevant("Irrelevant"),
	Closed("Closed"),
	Waiting("Waiting");
	
	private String text;
	
	E_Status(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
	
	public static E_Status getStatus(String text) {
		for (E_Status status : E_Status.values())
			if (status.text.equalsIgnoreCase(text))
				return status;
		return null;
	}
}
