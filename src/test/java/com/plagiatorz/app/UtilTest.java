package com.plagiatorz.app;

import com.plagiatorz.global.Utils;

import junit.framework.TestCase;

public class UtilTest extends TestCase{

	public void testSuccessRegexEmail() {
		assertTrue(Utils.checkRegex("asdf@lkj.ch", "\\w+@\\w+\\.\\w+"));
	}
	
	public void testFailRegexEmail() {
		assertFalse(Utils.checkRegex("asdf@lkj", "\\w+@\\w+\\.\\w+"));
		assertFalse(Utils.checkRegex("asdfl.kj", "\\w+@\\w+\\.\\w+"));
	}
}
