package com.plagiatorz.db.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dao.utility.DAOException;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.global.Constants;
import com.plagiatorz.login.LoginEnrichedData;
import com.plagiatorz.login.LoginObject;

public class AdressDAOImpl extends BaseDAOImpl implements AdressDAO{
	
	private static final String GETADRESSBYEMAIL = "SELECT * FROM Adresse where email=?";
	
	
	public AdressDAOImpl(DAOFactory daoFactory) {
		super(daoFactory);
	}

	@Override
	public AdressDTO getAdressByEmail(LoginObject lo, String email) throws DAOException {
		
		AdressDTO retVal = new AdressDTO();
		
		ResultSet rs = super.executeSelect(lo, GETADRESSBYEMAIL, new Object[]{email});
		
		try {
			while(rs.next()) {
				retVal.fillUpRecord(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return retVal;
	}

	@Override
	public void createAdress(LoginObject lo, AdressDTO adress) throws DAOException {

		int id = super.createAdressWithoutAuthorisation(adress);
		
		lo.setEmail(adress.getEmail());
		lo.setPassword(adress.getPasswort());
		lo.setEnrichedLoginData(new LoginEnrichedData(id, Constants.DEFAULTADRESSTYP));
	}
    
}
