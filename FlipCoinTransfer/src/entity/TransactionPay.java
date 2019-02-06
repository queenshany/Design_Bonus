package entity;

import java.sql.Date;

import utils.E_Status;
/**
 * This class represents a Transaction Pay in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class TransactionPay extends Transaction{
	private int payValue;

	//---------------------------- Constructors ----------------------------
	public TransactionPay(int transID, String description, int size, Date creationDate, Date executionDate, double fee,
			E_Status status, String creatingAddress, String creatingSignature, String destinationAddress,
			String destinationSignature, String walletAddress, int payValue) {
		super(transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature,
				destinationAddress, destinationSignature, walletAddress);
		this.payValue = payValue;
	}

	//---------------------------- Getters & Setters ----------------------------
	public int getPayValue() {
		return payValue;
	}

	public void setPayValue(int payValue) {
		this.payValue = payValue;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Pay " + super.toString() + " | Pay Value: " + payValue ;
	}

}
