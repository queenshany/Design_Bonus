package entity;

import java.sql.Date;
/**
 * This class represents the Sys Parameters in the system
 * @author Shany Klein & Ofri Kokush
 *
 */
public class SystemParams {
	private double version;
	private Date versionDate;
	private int transMinSize;
	private int transMaxSize;
	private int transSizeForExpansion;
	private double priceForExpansion;
	private double discountPercentPerFee;
	private double priceForDiscount;
	private int transSizeFree;
	private double maxAllowableDiscount;
	//---------------------------- Constructors ----------------------------
	public SystemParams(double version) {
		this.version = version;
	}

	public SystemParams(double version, Date versionDate, int transMinSize, int transMaxSize, int transSizeForExpansion,
			double priceForExpansion, double discountPercentPerFee, double priceForDiscount, int transSizeFree, double maxAllowableDiscount) {
		this.version = version;
		this.versionDate = versionDate;
		this.transMinSize = transMinSize;
		this.transMaxSize = transMaxSize;
		this.transSizeForExpansion = transSizeForExpansion;
		this.priceForExpansion = priceForExpansion;
		this.discountPercentPerFee = discountPercentPerFee;
		this.priceForDiscount = priceForDiscount;
		this.transSizeFree = transSizeFree;
		this.maxAllowableDiscount = maxAllowableDiscount;
	}

	//---------------------------- Getters & Setters ----------------------------
	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public Date getVersionDate() {
		return versionDate;
	}

	public void setVersionDate(Date versionDate) {
		this.versionDate = versionDate;
	}

	public int getTransMinSize() {
		return transMinSize;
	}

	public void setTransMinSize(int transMinSize) {
		this.transMinSize = transMinSize;
	}

	public int getTransMaxSize() {
		return transMaxSize;
	}

	public void setTransMaxSize(int transMaxSize) {
		this.transMaxSize = transMaxSize;
	}

	public int getTransSizeForExpansion() {
		return transSizeForExpansion;
	}

	public void setTransSizeForExpansion(int transSizeForExpansion) {
		this.transSizeForExpansion = transSizeForExpansion;
	}

	public double getPriceForExpansion() {
		return priceForExpansion;
	}

	public void setPriceForExpansion(double priceForExpansion) {
		this.priceForExpansion = priceForExpansion;
	}

	public double getDiscountPercentPerFee() {
		return discountPercentPerFee;
	}

	public void setDiscountPercentPerFee(double discountPercentPerFee) {
		this.discountPercentPerFee = discountPercentPerFee;
	}

	public double getPriceForDiscount() {
		return priceForDiscount;
	}

	public void setPriceForDiscount(double priceForDiscount) {
		this.priceForDiscount = priceForDiscount;
	}

	public int getTransSizeFree() {
		return transSizeFree;
	}

	public void setTransSizeFree(int transSizeFree) {
		this.transSizeFree = transSizeFree;
	}

	
	public double getMaxAllowableDiscount() {
		return maxAllowableDiscount;
	}

	public void setMaxAllowableDiscount(double maxAllowableDiscount) {
		this.maxAllowableDiscount = maxAllowableDiscount;
	}

	//---------------------------- Hash & Equals ----------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(version);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SystemParams other = (SystemParams) obj;
		if (Double.doubleToLongBits(version) != Double.doubleToLongBits(other.version))
			return false;
		return true;
	}

	//---------------------------- toString ----------------------------
	@Override
	public String toString() {
		return "System [version=" + version + ", versionDate=" + versionDate + ", transMinSize=" + transMinSize
				+ ", transMaxSize=" + transMaxSize + ", transSizeForExpansion=" + transSizeForExpansion
				+ ", priceForExpansion=" + priceForExpansion + ", discountPercentPerFee=" + discountPercentPerFee
				+ ", priceForDiscount=" + priceForDiscount + ", transSizeFree=" + transSizeFree + ", maxAllowableDiscount=" + maxAllowableDiscount + 
				 "]";
	}

}
