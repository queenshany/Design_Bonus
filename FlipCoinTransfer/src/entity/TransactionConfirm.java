package entity;

import java.sql.Date;

import utils.E_Status;

/**
 * This class represents a Transaction Confirm in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class TransactionConfirm extends Transaction{
	private boolean isConfirmed;
	private Date shippmentDate;

	//---------------------------- Constructors ----------------------------
	public TransactionConfirm(int transID, String description, int size, Date creationDate, Date executionDate,
			double fee, E_Status status, String creatingAddress, String creatingSignature, String destinationAddress,
			String destinationSignature, String walletAddress, boolean isConfirmed, Date shippmentDate) {
		super(transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature,
				destinationAddress, destinationSignature, walletAddress);
		this.isConfirmed = isConfirmed;
		this.shippmentDate = shippmentDate;
	}

	//---------------------------- Getters & Setters ----------------------------
	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public Date getShippmentDate() {
		return shippmentDate;
	}

	public void setShippmentDate(Date shippmentDate) {
		this.shippmentDate = shippmentDate;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Confirm " + super.toString()
		+ " | Is Confirmed: " + isConfirmed + " | ShippmentDate: " + shippmentDate ;
	}

}