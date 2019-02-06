package entity;
/**
 * This class represents a Solution in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Solution {
	private int riddleNum;
	private int solutionNum;
	private double result;

	// ---------------------------- Constructors ----------------------------
	public Solution(int riddleNum, int solutionNum) {
		this.riddleNum = riddleNum;
		this.solutionNum = solutionNum;
	}

	public Solution(int riddleNum, int solutionNum, double result) {
		this.riddleNum = riddleNum;
		this.solutionNum = solutionNum;
		this.result = result;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public int getRiddleNum() {
		return riddleNum;
	}

	public void setRiddleNum(int riddleNum) {
		this.riddleNum = riddleNum;
	}

	public int getSolutionNum() {
		return solutionNum;
	}

	public void setSolutionNum(int solutionNum) {
		this.solutionNum = solutionNum;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + riddleNum;
		result = prime * result + solutionNum;
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
		Solution other = (Solution) obj;
		if (riddleNum != other.riddleNum)
			return false;
		if (solutionNum != other.solutionNum)
			return false;
		return true;
	}
	
	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Solution Riddle Num: " + riddleNum + " | Solution Num: " + solutionNum + " | Result: " + result;
	}
}
