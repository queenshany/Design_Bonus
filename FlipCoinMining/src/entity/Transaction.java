package entity;
/**
 * This class represents a Transaction in the system
 * @author Shany Klein & Ofri Kokush
 *
 */

import java.sql.Date;
import java.sql.Time;

import utils.E_Type;

public class Transaction {
	private int ID;
	private int size;
	private E_Type type;
	private double fee;
	private String blockAddress;
	private Date additionDate;
	private Time additionTime;

	// ---------------------------- Constructors ----------------------------
	public Transaction(int ID) {
		this.ID = ID;
	}

	public Transaction(int ID, int size, E_Type type, double fee, String blockAddress, Date additionDate,
			Time additionTime) {
		super();
		this.ID = ID;
		this.size = size;
		this.type = type;
		this.fee = fee;
		this.blockAddress = blockAddress;
		this.additionDate = additionDate;
		this.additionTime = additionTime;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public E_Type getType() {
		return type;
	}

	public void setType(E_Type type) {
		this.type = type;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getBlockAddress() {
		return blockAddress;
	}

	public void setBlockAddress(String blockAddress) {
		this.blockAddress = blockAddress;
	}

	public Date getAdditionDate() {
		return additionDate;
	}

	public void setAdditionDate(Date additionDate) {
		this.additionDate = additionDate;
	}

	public Time getAdditionTime() {
		return additionTime;
	}

	public void setAdditionTime(Time additionTime) {
		this.additionTime = additionTime;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
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
		Transaction other = (Transaction) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Transaction ID: " + ID + " | Size: " + size + " | Type: " + type + " | Fee: " + fee + " | Block Address: "
				+ blockAddress + " | Addition Date: " + additionDate + " | Addition Time: " + additionTime;
	}
}
