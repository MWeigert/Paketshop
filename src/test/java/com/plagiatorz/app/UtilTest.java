package com.plagiatorz.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.plagiatorz.db.dao.utility.DaoUtil;
import com.plagiatorz.global.Utils;

public class UtilTest{

	@Test
	public void testSuccessRegexEmail() {
		assertTrue(Utils.checkRegex("asdf@lkj.ch", "\\w+@\\w+\\.\\w+"));
	}
	
	@Test
	public void testFailRegexEmail() {
		assertFalse(Utils.checkRegex("asdf@lkj", "\\w+@\\w+\\.\\w+"));
		assertFalse(Utils.checkRegex("asdfl.kj", "\\w+@\\w+\\.\\w+"));
	}
	
	@Test
	public void testDaoUtilFillUpValStr() {
		assertEquals("'str'", DaoUtil.fillUpValue("str"));
	}
	
	@Test
	public void testDaoUtilFillUpDate() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.YEAR, 2011);
		assertEquals("STR_TO_DATE('1.1.2011', '%d.%m.%Y')", DaoUtil.fillUpValue(cal.getTime()));
	}
}
