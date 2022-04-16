/**
 * 
 */
package partsLibrary;

import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lekar
 *
 */
public class TestPart {

	Parts m;

	@Test
	public void testConstructorInParts() {
		m = new Parts(1, 12, "ESP32 Feather", "Electrokit", "2021-09-10", 0, 0);
		Assert.assertNotNull(m);
	}

	@Test
	public void testPartNo() {
		m = new Parts(0, 12, "ESP32 Feather", "TestElectrokit", "2020-11-10", 0,
				0);
		int tempPartNo = 12;
		int tempFromGetPartNo = m.getPartNo();
		Assert.assertEquals(tempFromGetPartNo, tempPartNo);
	}

	@Test
	public void testItemId() {
		m = new Parts(0, 12, "ESP32 Feather", "TestElectrokit", "2020-11-10", 0,
				0);
		int idBeforeSetId = m.getItemId();
		System.out.printf("%d%n", idBeforeSetId);
		m.setItemId(99);
		int idAfterSetId = m.getItemId();
		System.out.printf("%d%n", idAfterSetId);
		assertNotEquals(idBeforeSetId, idAfterSetId);
	}

	@Test
	public void testDescription() {
		m = new Parts(0, 12, "ESP32 Feather", "TestElectrokit", "2020-11-10", 0,
				0);
		String tempDescription = "ESP32 Feather";
		String tempFromTestDescription = m.getDescription();
		Assert.assertEquals("ESP32 Feather", tempDescription,
				tempFromTestDescription);
	}

	@Test
	public void testWhereToBuy() {
		m = new Parts(0, 12, "ESP32 Feather", "TestElectrokit", "2020-11-10", 0,
				0);
		String tempWhereToBuy = "TestElectrokit";
		String tempFromWhereToBuy = m.getWhereToBuy();
		Assert.assertEquals("TestElectrokit", tempWhereToBuy,
				tempFromWhereToBuy);
	}

	// @Test
	// public void testRunningTime() {
	// m = new Parts(1, "testTitel", "testActor", 1900, 100);
	// int tempRunningTime = 100;
	// int tempFromRunningTime = m.getRunningTime();
	// Assert.assertEquals(tempRunningTime , tempFromRunningTime);
	// }
	//
	// @Test
	// public void testToString() {
	// m = new Parts(1, "testTitel", "testActor", 1900, 100);
	// String expectedMassage= " [id= 38, title= testTitel , actor= testActor ,
	// productionYear= 1900, runningTime= 100]";
	// String fromToString = m.toString();
	// Assert.assertEquals(expectedMassage, fromToString);
	// }
}
