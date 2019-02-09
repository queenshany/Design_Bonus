package entity;

import java.sql.Date;

import utils.E_Status;
import utils.E_Type;
/**
 * This class represents a Transaction Pay in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class TransactionPay extends Transaction{
	private double payValue;

	//---------------------------- Constructors ----------------------------
	public TransactionPay(int transID, String description, int size, Date creationDate, Date executionDate, double fee,
			E_Status status, String creatingAddress, String creatingSignature, String destinationAddress,
			String destinationSignature, String walletAddress, double payValue) {
		super(transID, description, size, creationDate, executionDate, fee, status, creatingAddress, creatingSignature,
				destinationAddress, destinationSignature, walletAddress, E_Type.Pay);
		this.payValue = payValue;
	}

	//---------------------------- Getters & Setters ----------------------------
	public double getPayValue() {
		return payValue;
	}

	public void setPayValue(double payValue) {
		this.payValue = payValue;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Pay " + super.toString() + " | Pay Value: " + payValue ;
	}

}
