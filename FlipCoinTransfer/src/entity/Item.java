package entity;
/**
 * This class represents an Item in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class Item {
	private int catalogNumber;
	private String itemName;
	private String image;
	private String description;
	private double price;
	private int quantity;
	private int category;
	private String sellerAddress;
	private String sellerSignature;

	//---------------------------- Constructors ----------------------------
	public Item(int catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public Item(int catalogNumber, String itemName, String image, String description, double price, int quantity,
			int category, String sellerAddress, String sellerSignature) {
		this.catalogNumber = catalogNumber;
		this.itemName = itemName;
		this.image = image;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.sellerAddress = sellerAddress;
		this.sellerSignature = sellerSignature;
	}

	//---------------------------- Getters & Setters ----------------------------
	public int getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(int catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerSignature() {
		return sellerSignature;
	}

	public void setSellerSignature(String sellerSignature) {
		this.sellerSignature = sellerSignature;
	}

	// ---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + catalogNumber;
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
		Item other = (Item) obj;
		if (catalogNumber != other.catalogNumber)
			return false;
		return true;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		//TODO
		Category c = new Category(category);
		return "Catalog Number:" + catalogNumber + " | Item Name: " + itemName + " | Description: " + description
				+ " | Price: " + price + " | Quantity: " + quantity + " | Category: " + c.getCategoryName() + " | Seller Address: "
				+ sellerAddress + " | Seller Signature: " + sellerSignature;
	}

}
