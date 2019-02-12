package utils;
/**
 * This class represents a Riddle Level in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public enum E_Level {
	Beginner("Beginner"),
	Easy("Easy"),
	Medium("Medium"),
	Hard("Hard"),
	Challenging("Challenging");
	
	private String text;
	
	E_Level(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
	
	public static E_Level getLevel(String text) {
		for (E_Level level : E_Level.values())
			if (level.text.equalsIgnoreCase(text))
				return level;
		return null;
	}
}
