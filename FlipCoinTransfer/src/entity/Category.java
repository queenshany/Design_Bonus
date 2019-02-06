package entity;
/**
 * This class represents a Category in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Category {
	private int serialNumber;
	private String categoryName;

	// ---------------------------- Constructors ----------------------------
	public Category(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Category(int serialNumber, String categoryName) {
		this.serialNumber = serialNumber;
		this.categoryName = categoryName;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	// ---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serialNumber;
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
		Category other = (Category) obj;
		if (serialNumber != other.serialNumber)
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Serial Number: " + serialNumber + " | Category Name: " + categoryName;
	}

}
