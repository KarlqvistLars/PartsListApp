/**
 * 
 */
package partsLibrary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import partsLibrary.Library;
import partsLibrary.Parts;
import partsLibrary.PartsLibrary;

/**
 * @author lekar
 * I detta testet skapas en ny library lista av typen Movie
 * Efter det så kontrolleras listans storlek med hjälp av 
 * metoden getNoOfItems. Därefter läggs den till variabeln sizeBeforeAdd.
 * Som sedan jämförs med variablen sizeAfterAdd. AfterAdd hämtas också genom 
 * library.getNoOfItems.
 */

public class TestPartLibrary {

	@Test
	public void testAddItem() {
		Library<Parts> testLibrary= new PartsLibrary();

		int sizeBeforeAdd = testLibrary.getNoOfItems();
		System.out.printf("%d%n", sizeBeforeAdd);

		Parts temp = new Parts(0, 12, "testPart", "test", "2020-11-10", 0,
				0);
		testLibrary.addItem(temp);

		int sizeAfterAdd = testLibrary.getNoOfItems();
		System.out.printf("%d%n", sizeAfterAdd);
		assertNotEquals(sizeBeforeAdd, sizeAfterAdd);
	}

//	@Test
//	public void testRemoveItem() {		
//
//		Library<Parts> testRemoveItemLibrary= new PartsLibrary();
//
//		int sizeBeforeRemove = testRemoveItemLibrary.getNoOfItems();
//		System.out.printf("%d%n", sizeBeforeRemove);
//
//		Parts temp = new Parts(4,"Golden Eye", "Pierce Brosnan", 1995, 130);
//
//		Parts[] myMovies = new Parts[20];
//
//		myMovies[0] = new Parts(1, "Dr No", "Sean Connory", 1962, 109);
//		myMovies[1] = new Parts(2,"Moonraker", "Roger Moore", 1979, 126);
//		myMovies[2] = new Parts(3,"Octopussy", "Roger Moore", 1983, 131);
//		myMovies[3] = new Parts(4,"Golden Eye", "Pierce Brosnan", 1995, 130);	
//		myMovies[4] = new Parts(5,"Tomorrow Never Dies", "Pierce Brosnan", 1997, 119);
//		myMovies[5] = new Parts(6,"Casino Royale", "Daniel Craig", 2006, 144);			
//
//		for(Parts m: myMovies){			
//			testRemoveItemLibrary.addItem(m);
//		}
//
//		testRemoveItemLibrary.removeItem(temp);
//
//		int sizeAfterRemove = testRemoveItemLibrary.getNoOfItems();
//		System.out.printf("%d%n", sizeAfterRemove);
//		// titta närmare på det här något som inte stämmer?
//		assertNotEquals(sizeBeforeRemove, sizeAfterRemove);
//
//	}
//
//	@Test
//	public void testSearchItem(){
//		//Skapar Movielista att testa
//		Library<Parts> testLibrary = new PartsLibrary();
//
//		testLibrary.addItem(new Parts(1, "Dr No", "Sean Connory", 1962, 109));
//		testLibrary.addItem(new Parts(2,"Moonraker", "Roger Moore", 1979, 126));
//		testLibrary.addItem(new Parts(3,"Octopussy", "Roger Moore", 1983, 131));
//		testLibrary.addItem(new Parts(4,"Golden Eye", "Pierce Brosnan", 1995, 130));	
//		testLibrary.addItem(new Parts(5,"Tomorrow Never Dies", "Pierce Brosnan", 1997, 119));
//		testLibrary.addItem(new Parts(6,"Casino Royale", "Daniel Craig", 2006, 144));
//
//		//Skapar lista att spara sökresultatet i
//		List <Parts> searchResult = new ArrayList<>();
//
//		// in: Sök strängen
//		String search = "moore";
//
//		// ut: List<Movie>		
//		searchResult = testLibrary.searchItem(search);
//		for (Parts parts : searchResult) {
//			System.out.println(parts);
//		}
//		Assert.assertTrue(searchResult.size()!=0);
//	}
//
//	@Test
//	public void testSearchItemNotfound(){
//		//Skapar Movielista att testa
//		Library<Parts> testLibrary = new PartsLibrary();
//
//		testLibrary.addItem(new Parts(1, "Dr No", "Sean Connory", 1962, 109));
//		testLibrary.addItem(new Parts(2,"Moonraker", "Roger Moore", 1979, 126));
//		testLibrary.addItem(new Parts(3,"Octopussy", "Roger Moore", 1983, 131));
//		testLibrary.addItem(new Parts(4,"Golden Eye", "Pierce Brosnan", 1995, 130));	
//		testLibrary.addItem(new Parts(5,"Tomorrow Never Dies", "Pierce Brosnan", 1997, 119));
//		testLibrary.addItem(new Parts(6,"Casino Royale", "Daniel Craig", 2006, 144));
//
//		//Skapar lista att spara sökresultatet i
//		List <Parts> searchResult = new ArrayList<>();
//
//		// in: Sök strängen
//		String search = "Skyfall";
//
//		// ut: List<Movie>		
//		searchResult = testLibrary.searchItem(search);
//		System.out.println("print not found");
//
//		Assert.assertTrue(searchResult==null);
//	}
//
//	@Test
//	public void testStoreItems() {
//		//Skapar Movielista att testa
//		Library<Parts> testLibrary = new PartsLibrary();
//		Library<Parts> testReadLibrary = new PartsLibrary();
//
//		//	List <Movie> testLibrary = new ArrayList<>();
//		//	List <Movie> testReadLibrary = new ArrayList<>();
//
//		boolean ok=false;
//		String filename = "testfilename.txt";
//
//		testLibrary.addItem(new Parts(1, "Dr No", "Sean Connory", 1962, 109));
//		testLibrary.addItem(new Parts(2,"Moonraker", "Roger Moore", 1979, 126));
//		testLibrary.addItem(new Parts(3,"Octopussy", "Roger Moore", 1983, 131));
//		testLibrary.addItem(new Parts(4,"Golden Eye", "Pierce Brosnan", 1995, 130));	
//		testLibrary.addItem(new Parts(5,"Tomorrow Never Dies", "Pierce Brosnan", 1997, 119));
//		testLibrary.addItem(new Parts(6,"Casino Royale", "Daniel Craig", 2006, 144));
//
//		testLibrary.storeItems(filename);
//
//		testLibrary.storeItems(filename);
//		testReadLibrary.readItems(filename);
//
//		if (testLibrary.getNoOfItems()==testReadLibrary.getNoOfItems()) {
//			ok=true;
//		}
//		Assert.assertTrue(ok);
//	}
}
