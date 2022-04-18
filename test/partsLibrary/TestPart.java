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
	public void testName() {
		m = new Parts(0, 12, "ESP32 Feather", "TestElectrokit", "2020-11-10", 0,
				0);
		String tempName = "ESP32 Feather";
		String tempFromTestName = m.getName();
		Assert.assertEquals("ESP32 Feather", tempName, tempFromTestName);
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

	@Test
	public void testBuyDate() {
		m = new Parts(0, 12, "ESP32 Feather", "TestElectrokit", "2020-11-10", 0,
				0);
		String tempBuyDate = "2020-11-10";
		String tempFromBuyDate = m.getBuyDate();
		Assert.assertEquals("2020-11-10", tempBuyDate, tempFromBuyDate);
	}

	@Test
	public void testToString() {
		m = new Parts(3, 41015979, "ESP32 Feather", "TestElectrokit",
				"2021-05-15", 279, 1);
		String expectedMassage = "[itemId= 3  , partNo= 41015979  , description= ESP32 Feather       , whereToBuy= TestElectrokit , buyDate= 2021-05-15, price= 279,00, stored=   1]";
		String fromToString = m.toString();
		Assert.assertEquals(
				"[itemId= 3  , partNo= 41015979  , description= ESP32 Feather       , whereToBuy= TestElectrokit , buyDate= 2021-05-15, price= 279,00, stored=   1]",
				expectedMassage, fromToString);
	}

	@Test
	public void testToPrint() {
		m = new Parts(3, 41015979, "ESP32 Feather", "TestElectrokit",
				"2021-05-15", 279, 1);
		String expectedMassage = "[partNo= 41015979  , description= ESP32 Feather       , whereToBuy= TestElectrokit , buyDate= 2021-05-15, price=   279,00]";
		String fromToPrint = m.toPrint();
		Assert.assertEquals(expectedMassage, fromToPrint);
	}
}
