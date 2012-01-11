package com.plagiatorz.db.mock;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.mockrunner.mock.jdbc.MockResultSet;
import com.plagiatorz.db.dto.ValuePairDTO;

/**
 * Testet die persistenz des ValuePairDTO abfuellens 
 * @author MARIUS
 *
 */
public class ValuePairMockTest {

	/**
	 * Resultset wird abgefuellt
	 * valuePairDTO wird mit der fillUpRecord Methode abgefuellt
	 * tests werden mittels asserequals durchgefuehrt
	 */
	@Test
	public void testVpRsSucc() {
		String testKey = "blubb";
		String testValue = "weeeert";
		MockResultSet rs = new MockResultSet("NurEinMock");
		rs.addColumn("key", new String[]{testKey});
		rs.addColumn("value", new String[]{testValue});
		ValuePairDTO vp = new ValuePairDTO();
		try {
			rs.next();
			vp.fillUpRecord(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assertEquals(testKey, vp.getKey());
		assertEquals(testValue, vp.getValue());
	}
	
}
