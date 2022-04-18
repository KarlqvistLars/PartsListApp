
package partsLibrary;

public class Parts implements Comparable<Parts> {

	private int itemId = 1;
	private final int partNo;
	private final String name;
	private final String whereToBuy;
	private final String buyDate;
	private final float price;
	private final int stored;
	public static int uniqId = 1;
	public Object toStringNoID;
	public int maxItem = 0;

	/**
	 * Constructor for the class Parts
	 * 
	 * @param itemId
	 *            - uniq id on the data post (Not viseble in toPrint() method
	 * @param partNo
	 *            - Part number on the part
	 * @param name
	 *            - name on the part
	 * @param whereToBuy
	 *            - Info where to buy the part
	 * @param buyDate
	 *            - The date of purchase
	 * @param price
	 *            - The price on the part
	 * @param stored
	 *            - flag that tells if the Parts is previously stored or if it's
	 *            a new instance
	 */
	public Parts(int itemId, int partNo, String name, String whereToBuy,
			String buyDate, float price, int stored) {
		if (itemId == 0) {
			this.itemId = uniqId++;
		} else {
			this.itemId = itemId;
		}
		this.partNo = partNo;
		this.name = name;
		this.whereToBuy = whereToBuy;
		this.buyDate = buyDate;
		this.stored = stored;
		this.price = price;
	}
	/**
	 * Getter to the: public static int uniqId
	 * 
	 * @return Returns the value on the uniqId.
	 */
	public int getUniqId() {
		return uniqId;
	}
	/**
	 * Setter to the: public static int uniqId
	 * 
	 * @param val
	 *            Sets the value on the uniqId.
	 */
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
	/**
	 * Setter to the: public int maxItem
	 * 
	 * @param val
	 *            Sets the value on the maxItem.
	 */
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
	 * Getter to the: private final String getname
	 * 
	 * @return Returns the value on the parts name.
	 */
	public String getname() {
		return name;
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
	/**
	 * toString()
	 * 
	 * @return A String with s row containing [itemId, partNo, name, whereToBuy,
	 *         buyDate, price, stored]
	 */
	public String toString() {
		return String.format(
				"[itemId= %-3d, partNo= %-10d, name= %-20s, whereToBuy= %-15s, buyDate= %10s, price= %5.2f, stored= %3d]",
				itemId, partNo, name, whereToBuy, buyDate, price, stored);
	}
	/**
	 * toRemove()
	 * 
	 * @return A String with s row containing [itemId, partNo, name, whereToBuy,
	 *         buyDate, price]
	 */
	public String toRemove() {
		return String.format(
				"[Id= %-3d, pNo= %-10d, name= %-20s, wBuy= %-15s, Date= %10s, $= %5.2f]",
				itemId, partNo, name, whereToBuy, buyDate, price);
	}
	/**
	 * toPrint()
	 * 
	 * @return A String with s row containing [partNo, name, whereToBuy,
	 *         buyDate, price]
	 */
	public String toPrint() {
		return String.format(
				"[partNo= %-10d, name= %-20s, whereToBuy= %-15s, buyDate= %10s, price= %8.2f]",
				partNo, name, whereToBuy, buyDate, price);
	}

	@Override
	public int compareTo(Parts o) {
		// Prepare for comparence of price.
		// return this.price - that.price;
		return 0;
	}
}
