package com.plagiatorz.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.plagiatorz.global.Utils;

public class UtilTest{

	public void testSuccessRegexEmail() {
		assertTrue(Utils.checkRegex("asdf@lkj.ch", "\\w+@\\w+\\.\\w+"));
	}
	
	public void testFailRegexEmail() {
		assertFalse(Utils.checkRegex("asdf@lkj", "\\w+@\\w+\\.\\w+"));
		assertFalse(Utils.checkRegex("asdfl.kj", "\\w+@\\w+\\.\\w+"));
	}
}
