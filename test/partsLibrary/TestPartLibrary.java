/**
 * 
 */
package partsLibrary;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lekar
 */

public class TestPartLibrary {

	@Test
	public void testAddItem() {
		Library<Parts> testLibrary = new PartsLibrary();

		int sizeBeforeAdd = testLibrary.getNoOfItems();
		System.out.printf("size before add %d%n", sizeBeforeAdd);

		Parts temp = new Parts(0, 12, "testPart", "test", "2020-11-10", 0, 0);
		testLibrary.addItem(temp);

		int sizeAfterAdd = testLibrary.getNoOfItems();
		System.out.printf("size after add %d%n", sizeAfterAdd);

		assertNotEquals(sizeBeforeAdd, sizeAfterAdd);
	}

	@Test
	public void testRemoveItem() {

		Library<Parts> partsList = new PartsLibrary();

		Parts temp = new Parts(0, 41015302, "Teensy 3.5", "Electrokit",
				"2020-11-10", 379, 0);

		Parts[] myParts = new Parts[6];

		myParts[0] = new Parts(0, 41015979, "ESP32 Feather", "Electrokit",
				"2020-11-10", 279, 0);
		myParts[1] = new Parts(0, 41015302, "Teensy 3.5", "Electrokit",
				"2020-11-10", 379, 0);
		myParts[2] = new Parts(0, 41015979, "ESP32 Feather", "Electrokit",
				"2021-05-15", 279, 0);
		myParts[3] = new Parts(0, 41015979, "ESP32 Feather", "Electrokit",
				"2020-11-10", 279, 0);
		myParts[4] = new Parts(0, 41015979, "ESP32 Feather", "Electrokit",
				"2020-11-10", 279, 0);
		myParts[5] = new Parts(0, 41015979, "ESP32 Feather", "Electrokit",
				"2020-11-10", 279, 0);

		for (Parts m : myParts) {
			partsList.addItem(m);
		}

		int sizeBeforeRemove = partsList.getNoOfItems();
		System.out.printf("Före %d%n", sizeBeforeRemove);

		partsList.removeItem(temp);

		int sizeAfterRemove = partsList.getNoOfItems() - 1;

		System.out.printf("Size before %d%n", sizeBeforeRemove);
		System.out.printf("Size after %d%n", sizeAfterRemove);

		assertNotEquals(sizeBeforeRemove, sizeAfterRemove);

	}

	@Test
	public void testSearchItem() {
		// Skapar Movielista att testa
		Library<Parts> testLibrary = new PartsLibrary();

		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));
		testLibrary.addItem(new Parts(0, 41015302, "Teensy 3.5", "Electrokit",
				"2020-11-10", 379, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2021-05-15", 279, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));

		// Skapar lista att spara sökresultatet i
		List<Parts> searchResult = new ArrayList<>();

		// in: Sök strängen
		String search = "ESP32";

		// ut: List<Movie>
		searchResult = testLibrary.searchItem(search);
		for (Parts parts : searchResult) {
			System.out.println(parts);
		}
		System.out.printf(" sök resultat storlek %d\n", searchResult.size());
		Assert.assertTrue(searchResult.size() != 0);
	}

	@Test
	public void testSearchItemNotfound() {
		// Skapar Movielista att testa
		Library<Parts> testLibrary = new PartsLibrary();

		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));
		testLibrary.addItem(new Parts(0, 41015302, "Teensy 3.5", "Electrokit",
				"2020-11-10", 379, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2021-05-15", 279, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));

		// Skapar lista att spara sökresultatet i
		List<Parts> searchResult = new ArrayList<>();

		// in: Sök strängen
		String search = "Teensy 2.5";

		// ut: List<Movie>
		searchResult = testLibrary.searchItem(search);
		System.out.println("print not found");

		Assert.assertTrue(searchResult == null);
	}

	@Test
	public void testStoreItems() {
		// Skapar Movielista att testa
		Library<Parts> testLibrary = new PartsLibrary();
		Library<Parts> testReadLibrary = new PartsLibrary();

		// List <Movie> testLibrary = new ArrayList<>();
		// List <Movie> testReadLibrary = new ArrayList<>();

		boolean ok = false;
		String filename = "testfilename.txt";

		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));
		testLibrary.addItem(new Parts(0, 41015302, "Teensy 3.5", "Electrokit",
				"2020-11-10", 379, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2021-05-15", 279, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));
		testLibrary.addItem(new Parts(0, 41015979, "ESP32 Feather",
				"Electrokit", "2020-11-10", 279, 0));

		testLibrary.storeItems(filename);

		testLibrary.storeItems(filename);
		testReadLibrary.readItems(filename);

		if (testLibrary.getNoOfItems() == testReadLibrary.getNoOfItems()) {
			ok = true;
		}
		Assert.assertTrue(ok);
	}
}
