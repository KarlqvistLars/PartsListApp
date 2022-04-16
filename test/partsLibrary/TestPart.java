/**
 * 
 */
package partsLibrary;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import partsLibrary.Parts;

/**
 * @author lekar
 *
 */
public class TestPart {

	Parts m;

	@Test
	public void testConstructorInMovie() {
		m = new Parts(1, 12, "ESP32 Feather", "Electrokit", "2021-09-10", 0, 0);
		Assert.assertNotNull(m);
	}

//	@Test
//	public void testGetTitle() {
//		m = new Parts(0, 12, "ESP32 Feather", "Electrokit", "2020-11-10");
//		String tempTitle = "testTitel";
//		String tempFromGetTitle = m.getTitle();
//		Assert.assertEquals(tempFromGetTitle, tempTitle);
//	}

//	@Test
//	public void testItemId() {
//		m = new Parts(1, "testTitel", "testActor", 1900, 100);
//		int idBeforeSetId = m.getItemId();
//		System.out.printf("%d%n", idBeforeSetId);
//		m.setItemId(99);
//		int idAfterSetId = m.getItemId();
//		System.out.printf("%d%n", idAfterSetId);
//		assertNotEquals(idBeforeSetId, idAfterSetId);
//	}

//	@Test
//	public void testActor() {
//		m = new Parts(1, "testTitel", "testActor", 1900, 100);
//		String tempActor = "testActor";
//		String tempFromTestActor = m.getActor();
//		Assert.assertEquals(tempActor , tempFromTestActor);
//	}
//
//	@Test
//	public void testProductionYear() {
//		m = new Parts(1, "testTitel", "testActor", 1900, 100);
//		int tempProductionYear = 1900;
//		int tempFromProductionYear = m.getProductionYear();
//		Assert.assertEquals(tempProductionYear , tempFromProductionYear);
//	}
//	
//	@Test
//	public void testRunningTime() {
//		m = new Parts(1, "testTitel", "testActor", 1900, 100);
//		int tempRunningTime = 100;
//		int tempFromRunningTime = m.getRunningTime();
//		Assert.assertEquals(tempRunningTime , tempFromRunningTime);
//	}
//	
//	@Test
//	public void testToString() {
//		m = new Parts(1, "testTitel", "testActor", 1900, 100);
//		String expectedMassage= " [id= 38, title= testTitel                     , actor= testActor       , productionYear= 1900, runningTime= 100]";
//		String fromToString = m.toString();
//		Assert.assertEquals(expectedMassage, fromToString);
//	}
}



