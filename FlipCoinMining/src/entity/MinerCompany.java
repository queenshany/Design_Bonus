package entity;
/**
 * This class represents a Miner Company in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class MinerCompany extends Miner {
	private String contactFirstName;
	private String contactLastName;
	private String contactPhone;
	private String contactEmail;

	// ---------------------------- Constructors ----------------------------
	public MinerCompany(String uniqueAddress, String minerName, String password, String email, double digitalProfit,
			String contactFirstName, String contactLastName, String contactPhone, String contactEmail) {
		super(uniqueAddress, minerName, password, email, digitalProfit);
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.contactPhone = contactPhone;
		this.contactEmail = contactEmail;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Override
	public String toString() {
		return "Company " + super.toString() + " | Contact Name: " + contactFirstName + " " + contactLastName
				+ "| Contact Phone: " + contactPhone + " | Contact Email: " + contactEmail;
	}


}
