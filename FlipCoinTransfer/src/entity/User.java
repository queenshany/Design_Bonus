package entity;

/**
 * This class represents a User in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class User {
	private String publicAddress;
	private String signature;
	private String username;
	private String password;
	private String phone;
	private String email;
	private boolean isEmployee;

	//---------------------------- Constructors ----------------------------
	public User(String publicAddress, String signature) {
		this.publicAddress = publicAddress;
		this.signature = signature;
	}

	public User(String publicAddress, String signature, String username, String password, String phone, String email,
			boolean isEmployee) {
		this.publicAddress = publicAddress;
		this.signature = signature;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.isEmployee = isEmployee;
	}

	//---------------------------- Getters & Setters ----------------------------
	public String getPublicAddress() {
		return publicAddress;
	}

	public void setPublicAddress(String publicAddress) {
		this.publicAddress = publicAddress;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	
	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((publicAddress == null) ? 0 : publicAddress.hashCode());
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
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
		User other = (User) obj;
		if (publicAddress == null) {
			if (other.publicAddress != null)
				return false;
		} else if (!publicAddress.equals(other.publicAddress))
			return false;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
			return false;
		return true;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "User Public Address: " + publicAddress + " | Signature: " + signature + " | Username: " + username
				+ " | Password: " + password + " | Phone: " + phone + " | Email: " + email + " | isEmployee: " + isEmployee;
	}

}
