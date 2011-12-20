package com.plagiatorz.db;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.plagiatorz.db.dao.ReferenzDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.ValuePairDTO;
import com.plagiatorz.login.LoginObject;

/**
 * stellt sicher, dass alle Referenzdaten-Queries Werte zurück geben
 * 
 * @author MARIUS
 * 
 */
public class ReferenzDatenTest {

	private LoginObject lo;
	private ReferenzDAO dao;

	@Before
	public void initialize() {
		lo = new LoginObject();
		lo.setEmail("max@muster.ch");
		lo.setPassword("passwort");

		DAOFactory daof = DAOFactory.getInstance();
		dao = daof.getReferenzDAO();
	}

	@Test
	public void testPaketStatus() throws DAOException {
		List<ValuePairDTO> retVal = dao.getAllPaketStatus(lo);
		assertNotNull(retVal);
	}

	@Test
	public void testMahnStatus() throws DAOException {
		List<ValuePairDTO> retVal = dao.getAllMahnStatus(lo);
		assertNotNull(retVal);
	}

	@Test
	public void testLager() throws DAOException {
		List<ValuePairDTO> retVal = dao.getAllLager(lo);
		assertNotNull(retVal);
	}

	@Test
	public void testKategorien() throws DAOException {
		List<ValuePairDTO> retVal = dao.getAllPaketKategorien(lo);
		assertNotNull(retVal);
	}
}
