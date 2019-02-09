package entity;

/**
 * This class represents the Sys Parameters
 * @author Shany Klein & Ofri Kokush
 *
 */
public class SystemParams {
	private double version;
	private int lastTransferredTrans;

	//---------------------------- Constructors ----------------------------
	public SystemParams(double version) {
		this.version = version;
	}

	public SystemParams(double version, int lastTransferredTrans) {
		this.version = version;
		this.lastTransferredTrans = lastTransferredTrans;
	}

	//---------------------------- Getters & Setters ----------------------------
	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public int getLastTransferredTrans() {
		return lastTransferredTrans;
	}

	public void setLastTransferredTrans(int lastTransferredTrans) {
		this.lastTransferredTrans = lastTransferredTrans;
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
		return "SystemParams [version=" + version + ", lastTransferredTrans="
				+ lastTransferredTrans + "]";
	}

}
