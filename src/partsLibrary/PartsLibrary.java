package partsLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PartsLibrary implements Library<Parts> {

	int maxItemID = 1;
	private List<Parts> partsList;

	/**
	 * Tillsammans med Partslibrary : skapar en array av 'partslist'
	 */
	public PartsLibrary() {
		partsList = new ArrayList<>();
	}

	/**
	 * Menu choise 1 - Present complete content
	 */
	@Override
	public void showLibraryContents() {
		for (Parts temp : partsList) {
			System.out.format(" %s%n", temp.toString());
		}
	}

	@Override
	public void showLibraryRowToRemove() {
		for (Parts temp : partsList) {
			System.out.format(" %s%n", temp.toRemove());
		}
	}

	public void showLibraryOnTextConsole() {
		for (Parts temp : partsList) {
			System.out.format(" %s%n", temp.toPrint());
		}
	}

	/**
	 * Menu choise 2 - Add Movie to library
	 */
	@Override
	public boolean addItem(Parts item) {

		partsList.add(item);
		return true;
	}

	/**
	 * Menu choise 3 - Remove Movie from library
	 */
	@Override
	public boolean removeItem(Parts item) {
		partsList.remove(item);

		return true;
	}

	/**
	 * Menu choise 4 - Search for a part by part no, descripton, where to buy,
	 * buy date
	 */
	public List<Parts> searchItem(String searchPattern) {
		boolean ok = false;

		List<Parts> searchResult = new ArrayList<>();

		Iterator<Parts> iter = this.partsList.iterator();

		while (iter.hasNext()) {
			Parts temp = iter.next();
			if (temp.toPrint().toLowerCase()
					.contains(searchPattern.toLowerCase())) {

				searchResult.add(temp);
				ok = true;
			}
		}
		if (!ok) {
			System.out.format(" '%s' not found\n", searchPattern);
			searchResult = null;
		}
		return searchResult;
	}

	/**
	 * Menu choise 5 - Store contens in file
	 */
	@Override
	public void storeItems(String filename) {

		try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
			for (Parts savedMovie : this.partsList) {
				pw.println(savedMovie);
			}
		} catch (IOException ioe) {
			System.out.println("Exception occurred: " + ioe);
		}
	}

	/**
	 * Menu choise 6 - Read contents from file to library
	 */
	@Override
	public void readItems(String filename) {
		try {

			File myObj = new File(filename);
			@SuppressWarnings("resource")
			Scanner myReader = new Scanner(myObj);

			List<Parts> fileInput = new ArrayList<>();

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				// System.out.format(" %s\n", data);
				/**
				 * Parse data from filename to partslist
				 */
				String onePart = data.substring(data.indexOf('[') + 1,
						data.indexOf(']') + 1);
				String[] parts = onePart.split("=");
				String index = parts[1].substring(0,
						parts[1].indexOf(", partNo"));
				String partNum = parts[2].substring(0,
						parts[2].indexOf(", name"));
				String name = parts[3].substring(0,
						parts[3].indexOf(", whereToBuy"));
				String whereToBuy = parts[4].substring(0,
						parts[4].indexOf(", buyDate"));
				String buyDate = parts[5].substring(0,
						parts[5].indexOf(", price"));
				String priceStr = parts[6].substring(0,
						parts[6].indexOf(", stored"));
				int stored = 1;
				// Clean and det values to variables
				index = index.strip();
				partNum = partNum.strip();
				name = name.strip();
				whereToBuy = whereToBuy.strip();
				buyDate = buyDate.strip();

				priceStr = priceStr.strip();
				priceStr = priceStr.replace(",", ".");

				int itemId = Integer.parseInt(index);
				int partNo = Integer.parseInt(partNum);
				float price = Float.parseFloat(priceStr);
				// Keep track on highest uniqID(itemId) value
				if (itemId > maxItemID) {
					maxItemID = itemId;
				}
				fileInput.add(new Parts(itemId, partNo, name, whereToBuy,
						buyDate, price, stored));
			}
			partsList = fileInput;
			System.out.println(
					" ======================== Info Parts Library ========================");
			System.out.println(" File name: " + myObj.getName());
			System.out.println(" Absolute path: \n " + myObj.getAbsolutePath());
			System.out.println(" File size in bytes " + myObj.length());
			System.out.println(
					"=====================================================================");
		} catch (FileNotFoundException err) {
			System.out.println("An error occurred.");
			err.printStackTrace();
		}
	}

	/**
	 * Menu choise 7 - Store contens in file
	 */
	@Override
	public void storeItemsAsCSV(String filename) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
			for (Parts savedMovie : this.partsList) {
				pw.printf("%d,%d,%s,%s,%s\n", savedMovie.getItemId(),
						savedMovie.getPartNo(), savedMovie.getname(),
						savedMovie.getWhereToBuy(), savedMovie.getBuyDate());
			}
		} catch (IOException ioe) {
			System.out.println("Exception occurred: " + ioe);
		}
	}

	@SuppressWarnings("unused")
	public int getNoOfItems() {
		int index = 0;
		// for loopen snurrar x antal varv tills library list är genomsökt
		for (Parts temp : partsList) {
			index++;
		}
		return index;
	}

	@SuppressWarnings("unused")
	public int getMaxItemID() {
		for (Parts temp : partsList) {
			if (temp.getItemId() > maxItemID) {
				maxItemID = temp.getItemId();
			}
		}
		return maxItemID;
	}

	public Parts getItem(int itemId) {
		for (Parts temp : partsList) {
			if (temp.getItemId() == itemId) {
				return temp;
			}
		}
		return null;
	}
}
