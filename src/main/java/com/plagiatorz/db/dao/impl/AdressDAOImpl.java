package com.plagiatorz.db.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.global.Constants;
import com.plagiatorz.login.LoginEnrichedData;
import com.plagiatorz.login.LoginObject;

public class AdressDAOImpl extends BaseDAOImpl implements AdressDAO{
	
	private static final String GETADRESSBYEMAIL = "SELECT * FROM Adresse where email=?";
	private static final String GETADRESSLISTBYADRTYPE = "SELECT * FROM Adresse where adressTyp=?";
	private static final String UPDADRESS = "UPDATE Adresse SET name = ?, vorname = ?, strasse = ?, strassenNr = ?, zusatzzeile = ?, land = ?,"
																+"plz = ?, ort = ?, mobile = ?, telefonp = ?, email = ?, passwort = ?"
											 +"WHERE id = ?";
	
	
	public AdressDAOImpl(DAOFactory daoFactory) {
		super(daoFactory);
	}

	@Override
	public AdressDTO getAdressByEmail(LoginObject lo, String email) throws DAOException {
		
		AdressDTO retVal = new AdressDTO();
		
		ResultSet rs = super.executeSelect(lo, GETADRESSBYEMAIL, new Object[]{email});
		
		try {
			while(rs.next()) {
				retVal.fillUpRecord(rs, lo);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return retVal;
	}

	@Override
	public List<AdressDTO> getAdressListByAdressType(LoginObject lo, int adressType) throws DAOException {
		
		List<AdressDTO> retVal = new ArrayList<AdressDTO>();
		
		ResultSet rs = super.executeSelect(lo, GETADRESSLISTBYADRTYPE, new Object[]{adressType});
		
		try {
			AdressDTO dto;
			while(rs.next()) {
				dto = new AdressDTO();
				dto.fillUpRecord(rs);
				retVal.add(dto);
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

	@Override
	public void updateAdress(LoginObject lo, AdressDTO adress)
			throws DAOException {
		
		Object[] obj = new Object[]{adress.getName(),adress.getVorname(),adress.getStrasse(),adress.getStrassenNr()
				,adress.getZusatzzeile(),adress.getLand(),adress.getPlz(),adress.getOrt(),adress.getMobile()
				,adress.getTelefon(),adress.getEmail(),adress.getPasswort()};

		super.updateRecord(lo, UPDADRESS, obj, new Object[]{adress.getId()});
		
	}
}
