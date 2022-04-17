
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

	/**
	 * Getter to the: public int maxItem
	 * 
	 * @return Returns the value on the the highest number used on itemId.
	 */
	public int getMaxItem() {

		return maxItem;
	}

	public void setMaxItem(int val) {
		maxItem = val;
	}

	/**
	 * Getter to the: private int itemId
	 * 
	 * @return Returns the value on the itemId witch is the partslist uniqId or
	 *         key.
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * Setter to the: private int itemId
	 * 
	 * @param itemId
	 *            Sets the itemId to a value. Is used by JUnit testing.
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * Getter to the: private final int partNo
	 * 
	 * @return Returns the value on the partNo variable.
	 */
	public int getPartNo() {
		return partNo;
	}

	/**
	 * Getter to the: private final String getDescription
	 * 
	 * @return Returns the value on the parts Description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Getter to the: private final String whereToBuy
	 * 
	 * @return Returns the value on the prefered supplier.
	 */
	public String getWhereToBuy() {
		return whereToBuy;
	}

	/**
	 * Getter to the: private final String BuyDate
	 * 
	 * @return Returns the value on the parts purshase date if set.
	 */
	public String getBuyDate() {
		return buyDate;
	}

	/**
	 * Getter to the: private final String getPrice
	 * 
	 * @return Returns the value on the parts price if set..
	 */
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
