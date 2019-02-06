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
	private String uniqueAddress;
	private String title;
	private String description;
	private Date messageDate;
	private Time messageTime;

	//---------------------------- Constructors ----------------------------
	public Message(int ID, String uniqueAddress) {
		this.ID = ID;
		this.uniqueAddress = uniqueAddress;
	}

	public Message(int ID, String uniqueAddress, String title, String description, Date messageDate, Time messageTime) {
		this.ID = ID;
		this.uniqueAddress = uniqueAddress;
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

	public String getUniqueAddress() {
		return uniqueAddress;
	}

	public void setUniqueAddress(String uniqueAddress) {
		this.uniqueAddress = uniqueAddress;
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
		result = prime * result + ((uniqueAddress == null) ? 0 : uniqueAddress.hashCode());
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
		if (uniqueAddress == null) {
			if (other.uniqueAddress != null)
				return false;
		} else if (!uniqueAddress.equals(other.uniqueAddress))
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Message ID: " + ID + " | Miner Unique Address: " + uniqueAddress + " | Title: " + title + " | Description: "
				+ description + " | Date: " + messageDate + " | Time: " + messageTime;
	}

}
