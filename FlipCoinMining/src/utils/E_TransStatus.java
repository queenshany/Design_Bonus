package utils;
/**
 * This class represents a Transaction Status in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public enum E_TransStatus {
	Waiting("Waiting"),
	Executed("Executed"),
	Irrelevant("Irrelevant");

	private String text;

	E_TransStatus(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}

	public static E_TransStatus getStatus(String text) {
		for (E_TransStatus status : E_TransStatus.values())
			if (status.text.equalsIgnoreCase(text))
				return status;
		return null;
	}
}
