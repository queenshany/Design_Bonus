package entity;

import java.sql.Date;

import utils.E_Status;
import utils.E_TransType;

/**
 * This class represents a Transaction Confirm in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class TransactionConfirm extends Transaction{
	private Boolean isConfirmed;
	private Date shippmentDate;
	private int transPayID;

	//---------------------------- Constructors ----------------------------
	public TransactionConfirm(int transID, String description, int size, Date creationDate, Date executionDate,
			double fee, E_Status status, String creatingAddress, String creatingSignature, String destinationAddress,
			String destinationSignature, String walletAddress, boolean isConfirmed, Date shippmentDate, int transPayID) {
		super(transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature,
				destinationAddress, destinationSignature, walletAddress, E_TransType.Confirm);
		this.isConfirmed = isConfirmed;
		this.shippmentDate = shippmentDate;
		this.transPayID = transPayID;
	}

	//---------------------------- Getters & Setters ----------------------------
	public Boolean getIsConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public Date getShippmentDate() {
		return shippmentDate;
	}

	public void setShippmentDate(Date shippmentDate) {
		this.shippmentDate = shippmentDate;
	}
	
	public int getTransPayID() {
		return transPayID;
	}

	public void setTransPayID(int transPayID) {
		this.transPayID = transPayID;
	}

	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Confirm " + super.toString()
		+ " | Is Confirmed: " + isConfirmed + " | ShippmentDate: " + shippmentDate + " | Trans Pay ID: " + transPayID;
	}

}
