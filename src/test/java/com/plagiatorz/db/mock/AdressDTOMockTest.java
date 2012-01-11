package com.plagiatorz.db.mock;

import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.Test;

import com.mockrunner.mock.jdbc.MockResultSet;
import com.plagiatorz.db.dto.AdressDTO;

/**
 * Arbeitet mit Mockrunner und stellt die Persistenz des AdressDTO sicher
 * @author MARIUS
 *
 */
public class AdressDTOMockTest extends TestCase {

	/**
	 * Resultset wird abgefuellt
	 * adressDTO wird mit der fillUpRecord Methode abgefuellt
	 * tests werden mittels asserequals durchgefuehrt
	 */
	@Test
	public void testAdressReadRs() {		
		int id = 123;
		String name = "n";
		String vorname = "v";
		String strasse = "asdf";
		String strassenNr = "eerew";
		String zusatzzeile = "qwer";
		String land = "wqerew";
		String plz = "1234";
		String ort = "feeafq";
		String mobile = "079784";
		String telefon = "254234 3";
		String email = "m.mm@m.ch";
		
		MockResultSet rs = new MockResultSet("NurEinMock");
		rs.addColumn("key", new Integer[]{id});
		rs.addColumn("name", new String[]{name});
		rs.addColumn("vorname", new String[]{vorname});
		rs.addColumn("strasse", new String[]{strasse});
		rs.addColumn("strassenNr", new String[]{strassenNr});
		rs.addColumn("zusatzzeile", new String[]{zusatzzeile});
		rs.addColumn("land", new String[]{land});
		rs.addColumn("plz", new String[]{plz});
		rs.addColumn("ort", new String[]{ort});
		rs.addColumn("mobile", new String[]{mobile});
		rs.addColumn("telefon", new String[]{telefon});
		rs.addColumn("email", new String[]{email});
		
		AdressDTO ad = new AdressDTO();
		try {
			rs.next();
			ad.fillUpRecord(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assertEquals(name, ad.getName());
		assertEquals(vorname, ad.getVorname());
		assertEquals(strasse, ad.getStrasse());
		assertEquals(strassenNr, ad.getStrassenNr()); 
		assertEquals(zusatzzeile, ad.getZusatzzeile());
		assertEquals(land, ad.getLand());
		assertEquals(plz, ad.getPlz());
		assertEquals(ort, ad.getOrt());
		assertEquals(mobile, ad.getMobile());
		assertEquals(telefon, ad.getTelefon());
		assertEquals(email, ad.getEmail());

	}
}
