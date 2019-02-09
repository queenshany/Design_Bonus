package entity;

import java.sql.Date;

import utils.E_Status;
import utils.E_Type;

/**
 * This class represents a Transaction in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Transaction {
	private int transID;
	private String description;
	private int size;
	private Date creationDate;
	private Date executionDate;
	private double fee;
	private E_Status status;
	private String creatingAddress;
	private String creatingSignature;
	private String destinationAddress;
	private String destinationSignature;
	private String walletAddress;
	private E_Type type;

	//---------------------------- Constructors ----------------------------
	public Transaction(int transID) {
		this.transID = transID;
	}

	public Transaction(int transID, String description, int size, Date creationDate, Date executionDate, double fee,
			E_Status status, String creatingAddress, String creatingSignature, String destinationAddress,
			String destinationSignature, String walletAddress, E_Type type) {
		this.transID = transID;
		this.description = description;
		this.size = size;
		this.creationDate = creationDate;
		this.executionDate = executionDate;
		this.fee = fee;
		this.status = status;
		this.creatingAddress = creatingAddress;
		this.creatingSignature = creatingSignature;
		this.destinationAddress = destinationAddress;
		this.destinationSignature = destinationSignature;
		this.walletAddress = walletAddress;
		this.type = type;
	}

	//---------------------------- Getters & Setters ----------------------------
	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public E_Status getStatus() {
		return status;
	}

	public void setStatus(E_Status status) {
		this.status = status;
	}

	public String getCreatingAddress() {
		return creatingAddress;
	}

	public void setCreatingAddress(String creatingAddress) {
		this.creatingAddress = creatingAddress;
	}

	public String getCreatingSignature() {
		return creatingSignature;
	}

	public void setCreatingSignature(String creatingSignature) {
		this.creatingSignature = creatingSignature;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getDestinationSignature() {
		return destinationSignature;
	}

	public void setDestinationSignature(String destinationSignature) {
		this.destinationSignature = destinationSignature;
	}

	public String getWalletAddress() {
		return walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}
	
	public E_Type getType() {
		return type;
	}

	public void setType(E_Type type) {
		this.type = type;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transID;
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
		if (transID != other.transID)
			return false;
		return true;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Transaction ID: " + transID + " | Description: " + description + " | Size: " + size + " | Creation Date: "
				+ creationDate + " | Execution Date: " + executionDate + " | Fee: " + fee + " | Status: " + status
				+ " | Creating Address: " + creatingAddress + " | Creating Signature: " + creatingSignature
				+ " | Destination Address: " + destinationAddress + " | Destination Signature: " + destinationSignature
				+ " | Wallet Address: " + walletAddress;
	}

}
