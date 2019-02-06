package entity;

import java.sql.Date;
import java.sql.Time;

/**
 * This class represents a Message in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Message {
	private int ID;
	private String userAddress;
	private String userSignature;
	private String title;
	private String description;
	private Date messageDate;
	private Time messageTime;

	//---------------------------- Constructors ----------------------------
	public Message(int ID, String userAddress, String userSignature) {
		this.ID = ID;
		this.userAddress = userAddress;
		this.userSignature = userSignature;
	}

	public Message(int ID, String userAddress, String userSignature, String title, String description, Date messageDate, Time messageTime) {
		this.ID = ID;
		this.userAddress = userAddress;
		this.userSignature = userSignature;
		this.title = title;
		this.description = description;
		this.messageDate = messageDate;
		this.messageTime = messageTime;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}


	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public Time getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Time messageTime) {
		this.messageTime = messageTime;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = prime * result + ((userSignature == null) ? 0 : userSignature.hashCode());
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
		Message other = (Message) obj;
		if (ID != other.ID)
			return false;
		if (userAddress == null) {
			if (other.userAddress != null)
				return false;
		} else if (!userAddress.equals(other.userAddress))
			return false;
		if (userSignature == null) {
			if (other.userSignature != null)
				return false;
		} else if (!userSignature.equals(other.userSignature))
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Message ID: " + ID + " | User Address: " + userAddress + " | User Signature: " + userSignature +" | Title: " + title + " | Description: "
				+ description + " | Date: " + messageDate + " | Time: " + messageTime;
	}



}
