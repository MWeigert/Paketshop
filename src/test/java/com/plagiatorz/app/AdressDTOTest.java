package com.plagiatorz.app;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.plagiatorz.db.dao.exception.ValidationException;
import com.plagiatorz.db.dto.AdressDTO;

public class AdressDTOTest extends TestCase{

	public AdressDTOTest( String testName )
    {
        super( testName );
    }
    
    public static TestSuite suite()
    {
        return new TestSuite( AdressDTOTest.class );
    }
    
	public void testSuccessValidation() {
		
		AdressDTO dto = createAdrDTO();
		try {
			dto.validate();
			assertTrue(true);
		} catch (ValidationException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	public void testErrorValidation() {

		AdressDTO dto = createAdrDTO();
		dto.setName(null);
		try {
			dto.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		
		dto = createAdrDTO();
		dto.setVorname(null);
		try {
			dto.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		dto = createAdrDTO();
		dto.setStrasse(null);
		try {
			dto.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		dto = createAdrDTO();
		dto.setStrassenNr(null);
		try {
			dto.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		dto = createAdrDTO();
		dto.setPlz(null);
		try {
			dto.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
		dto = createAdrDTO();
		dto.setOrt(null);
		try {
			dto.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}		
		dto = createAdrDTO();
		dto.setLand(null);
		try {
			dto.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}		
		dto = createAdrDTO();
		dto.setEmail(null);
		try {
			dto.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}		
		dto = createAdrDTO();
		dto.setEmail("kwogli@wusch");
		try {
			dto.validate();
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
	}
    private AdressDTO createAdrDTO() {
    	
    	AdressDTO dto = new AdressDTO();
		dto.setEmail("a.b@asdf.ch");
		dto.setName("name");
		dto.setVorname("aa");
		dto.setStrasse("l");
		dto.setStrassenNr("10c");
		dto.setPlz("8000");
		dto.setOrt("Zürich");
		dto.setLand("CH");
		return dto;
    }
}