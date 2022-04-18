package partsLibrary;

import java.util.Collections;
import java.util.List;

public interface Library<T> {

	/**
	 * Adds new item
	 *
	 * @param item
	 *            - Object of type T
	 * @return returns boolean true if item is added.
	 */
	boolean addItem(T item);

	/**
	 * Removes item or type Parts.
	 *
	 * @param item
	 *            - Object of type Parts.
	 * @return returns boolean true if object is removed.
	 */
	boolean removeItem(T item);

	/**
	 * Returns the number of items
	 *
	 * @return returns the number of items
	 */
	default int getNoOfItems() {
		return 0;
	}

	default int getMaxItemID() {
		return 0;
	}

	/**
	 * Lists or displays the library contents
	 */
	void showLibraryContents();

	void showLibraryRowToRemove();

	void showLibraryOnTextConsole();

	String showLibraryOnGUIConsole();

	String showRowToRemoveOnGUI();

	/**
	 * Menu choise 5 - Writes content to the database file.
	 *
	 * @param filename
	 *            - The file partslibrarylist.txt
	 */
	void storeItems(String filename);

	/**
	 * Menu choise 6 - Read contents from file to library from databasefile
	 * 'filename' partslibrarylist.txt.
	 *
	 * @param filename
	 *            partslibrarylist.txt
	 */
	void readItems(String filename);

	/**
	 * Menu choice 7 - Write content in format *.csv
	 * 
	 * @param filename
	 *            - the *.csv file
	 */
	void storeItemsAsCSV(String filename);

	/**
	 * Searches in the 'librarylist' list for the search string serachPattern
	 *
	 * @param searchPattern
	 *            - The search string searchPattern is defined by user input.
	 * @return Returns the searchResult list
	 */

	default List<T> searchItem(String searchPattern) {
		return Collections.emptyList();
	}

	default T getItem(int itemId) {
		return null;
	}
}
