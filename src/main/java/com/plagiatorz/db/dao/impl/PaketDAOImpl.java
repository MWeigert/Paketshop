package com.plagiatorz.db.dao.impl;

import com.plagiatorz.db.dao.PaketDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.PaketDTO;
import com.plagiatorz.login.LoginObject;

public class PaketDAOImpl extends BaseDAOImpl implements PaketDAO {

	private static final String CREATEPAKET = "INSERT INTO Paket (Kunde, "
												+"Kategorie, "
												+"Status, "
												+"BuHaStatus, "
												+"MahnStatus, "
												+"EingangDatum, "
												+"LagerOrt)";
	public PaketDAOImpl(DAOFactory daoFactory) {
		super(daoFactory);
	}

	@Override
	public void createPaket(LoginObject lo, PaketDTO paket) throws DAOException {
		Object[] values = new Object[7];
		values[0] = paket.getKategorie();
		values[1] = paket.getKategorie();
		values[2] = paket.getStatus();
		values[3] = paket.getBuHaStatus();
		values[4] = paket.getMahnStatus();
		values[5] = paket.getEingangsDatum();
		values[6] = paket.getLagerOrt();
		
		super.createRecord(lo, CREATEPAKET, values);
	}

}

