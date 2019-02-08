package entity;
/**
 * This class represents an Item in Transaction in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class ItemInTransaction {
	private int item;
	private int trans;
	private int quantity;

	//---------------------------- Constructors ----------------------------
	public ItemInTransaction(int item, int trans) {
		this.item = item;
		this.trans = trans;
	}

	public ItemInTransaction(int item, int trans, int quantity) {
		this.item = item;
		this.trans = trans;
		this.quantity = quantity;
	}

	//---------------------------- Getters & Setters ----------------------------
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public int getTrans() {
		return trans;
	}
	public void setTrans(int trans) {
		this.trans = trans;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + item;
		result = prime * result + trans;
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
		ItemInTransaction other = (ItemInTransaction) obj;
		if (item != other.item)
			return false;
		if (trans != other.trans)
			return false;
		return true;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "Item: " + item + " | Transaction: " + trans + " | Quantity: " + quantity;
	}

}
