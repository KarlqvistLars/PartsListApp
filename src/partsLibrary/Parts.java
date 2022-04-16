
package partsLibrary;

public class Parts implements Comparable<Parts> {

	private int itemId = 1;
	private final int partNo;
	private final String description;
	private final String whereToBuy;
	private final String buyDate;
	private final float price;
	private final int stored;

	public static int uniqId = 1;
	public Object toStringNoID;
	public int maxItem = 0;

	// constructor
	public Parts(int itemId, int partNo, String description, String whereToBuy,
			String buyDate, float price, int stored) {
		if (itemId == 0) {
			this.itemId = uniqId++;
		} else {
			this.itemId = itemId;
		}
		this.partNo = partNo;
		this.description = description;
		this.whereToBuy = whereToBuy;
		this.buyDate = buyDate;
		this.stored = stored;
		this.price = price;
	}

	public int getUniqId() {
		return uniqId;
	}

	public void setUniqId(int val) {
		uniqId = val;
	}

	public int getMaxItem() {

		return maxItem;
	}

	public void setMaxItem(int val) {
		maxItem = val;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getPartNo() {
		return partNo;
	}

	public String getDescription() {
		return description;
	}

	public String getWhereToBuy() {
		return whereToBuy;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format(
				"[itemId= %-3d, partNo= %-10d, description= %-20s, whereToBuy= %-15s, buyDate= %10s, price= %5.2f, stored= %3d]",
				itemId, partNo, description, whereToBuy, buyDate, price,
				stored);
	}

	public String toPrint() {
		return String.format(
				"[partNo= %-10d, description= %-20s, whereToBuy= %-15s, buyDate= %10s, price= %8.2f]",
				partNo, description, whereToBuy, buyDate, price);
	}

	@Override
	public int compareTo(Parts o) {
		// Förberedd för jämförelse av filmens speltid.
		// return this.runningTime - that.runningTime;
		return 0;
	}

	// public void showID(boolean b) {
	// showID = b;
	// }
}
