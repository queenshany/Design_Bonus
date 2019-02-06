package entity;

import utils.E_Level;

/**
 * This class represents a Riddle Level in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class RiddleLevel {
	private int levelCode;
	private E_Level levelName;
	private int difficultyLevel;
	private int blockSize;

	// ---------------------------- Constructors ----------------------------
	public RiddleLevel(int levelCode) {
		this.levelCode = levelCode;
	}

	public RiddleLevel(int levelCode, E_Level levelName, int difficultyLevel, int blockSize) {
		this.levelCode = levelCode;
		this.levelName = levelName;
		this.difficultyLevel = difficultyLevel;
		this.blockSize = blockSize;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public int getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(int levelCode) {
		this.levelCode = levelCode;
	}

	public E_Level getLevelName() {
		return levelName;
	}

	public void setLevelName(E_Level levelName) {
		this.levelName = levelName;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + levelCode;
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
		RiddleLevel other = (RiddleLevel) obj;
		if (levelCode != other.levelCode)
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Riddle Level Code: " + levelCode + " | Level Name: " + levelName + " | Difficulty Level: " + difficultyLevel
				+ " | Block Size: " + blockSize;
	}


}
