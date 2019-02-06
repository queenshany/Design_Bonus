package entity;

import java.sql.Date;
import java.sql.Time;

/**
 * This class represents a Block in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Block {
	private String blockAddress;
	private Date creationDate;
	private Time creationTime;
	private int size;
	private String previousBlock;
	private String minerAddress;

	// ---------------------------- Constructors ----------------------------
	public Block(String blockAddress) {
		this.blockAddress = blockAddress;
	}

	public Block(String blockAddress, Date creationDate, Time creationTime, int size, String previousBlock,
			String minerAddress) {
		this.blockAddress = blockAddress;
		this.creationDate = creationDate;
		this.creationTime = creationTime;
		this.size = size;
		this.previousBlock = previousBlock;
		this.minerAddress = minerAddress;
	}

	// ---------------------------- Getters & Setters ----------------------------
	public String getBlockAddress() {
		return blockAddress;
	}

	public void setBlockAddress(String blockAddress) {
		this.blockAddress = blockAddress;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Time getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Time creationTime) {
		this.creationTime = creationTime;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getPreviousBlock() {
		return previousBlock;
	}

	public void setPreviousBlock(String previousBlock) {
		this.previousBlock = previousBlock;
	}

	public String getMinerAddress() {
		return minerAddress;
	}

	public void setMinerAddress(String minerAddress) {
		this.minerAddress = minerAddress;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockAddress == null) ? 0 : blockAddress.hashCode());
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
		Block other = (Block) obj;
		if (blockAddress == null) {
			if (other.blockAddress != null)
				return false;
		} else if (!blockAddress.equals(other.blockAddress))
			return false;
		return true;
	}

	// ---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Block Address: " + blockAddress + " | Creation Date: " + creationDate + " | Creation Time: " + creationTime
				+ " | Size: " + size + " | Previous Block: " + previousBlock + " | Miner Address: " + minerAddress;
	}

}
