package com.plagiatorz.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.plagiatorz.app.bean.AdressBean;
import com.plagiatorz.db.dao.exception.ValidationException;

public class AdressBeanTest {

	@Test
	public void testSuccessValidation() {

		AdressBean bean = createAdrBean();
		try {
			bean.validate();
			assertTrue(true);
		} catch (ValidationException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void testErrorValidation() {

		AdressBean bean = createAdrBean();
		bean.getName().setText(null);
		try {
			bean.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		
		bean = createAdrBean();
		bean.getVorname().setText(null);
		try {
			bean.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		bean = createAdrBean();
		bean.getStrasse().setText(null);
		try {
			bean.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		bean = createAdrBean();
		bean.getStrassenNr().setText(null);
		try {
			bean.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		bean = createAdrBean();
		bean.getPlz().setText(null);
		try {
			bean.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		bean = createAdrBean();
		bean.getOrt().setText(null);
		try {
			bean.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}		
		bean = createAdrBean();
		bean.getLand().setText(null);
		try {
			bean.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}		
		bean = createAdrBean();
		bean.getEmail().setText(null);
		try {
			bean.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}		
		bean = createAdrBean();
		bean.getEmail().setText("kwogli@wusch");
		try {
			bean.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
	}
	
    private AdressBean createAdrBean() {
    	
    	AdressBean bean = new AdressBean();
		bean.getEmail().setText("a4b@asdf.ch");
		bean.getName().setText("name");
		bean.getVorname().setText("aa");
		bean.getStrasse().setText("l");
		bean.getStrassenNr().setText("10c");
		bean.getPlz().setText("8000");
		bean.getOrt().setText("Zürich");
		bean.getLand().setText("CH");
		return bean;
    }
}