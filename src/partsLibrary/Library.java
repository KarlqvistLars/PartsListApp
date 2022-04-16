package partsLibrary;

import java.util.Collections;
import java.util.List;

public interface Library<T> {

	/**
	 * L�gger till nytt item
	 * 
	 * @param item
	 *            Objekt av typen T
	 * @return returnerar boolean true ifall objekt �r tillagt.
	 */
	boolean addItem(T item);

	/**
	 * Tar bort item av typen Movie.
	 * 
	 * @param index
	 *            Objekt av typen Movie.
	 * @return returnerar boolean true ifall objekt �r borttaget.
	 */
	boolean removeItem(T item);

	/**
	 * H�mtar antalet objekt av typen items
	 * 
	 * @param H�mtar
	 *            antalet items
	 * @return returnerar antalet
	 */
	default int getNoOfItems() {
		return 0;
	}

	default int getMaxItemID() {
		return 0;
	}

	/**
	 * Listar eller visar biblioteksinneh�llet
	 */
	void showLibraryContents();

	void showLibraryOnTextConsole();

	/**
	 * Menu choise 5 - Writes content Skriver till databasfilen.
	 * 
	 * @param filename
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
	 * Menu choise 7 - Writes content to *.cvs - Skriver till databasfilen.
	 * 
	 * @param filename
	 */
	void storeItemsAsCSV(String filename);

	/**
	 * S�ker i listan 'librarylist' efter s�kstr�ngen serachPattern
	 * 
	 * @param searchPattern
	 * @return Returnerar listan searchResult
	 */

	default List<T> searchItem(String searchPattern) {
		return Collections.emptyList();
	}

	default T getItem(int itemId) {
		return null;
	}
}
