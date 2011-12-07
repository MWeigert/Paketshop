package com.plagiatorz.db.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dao.utility.DAOException;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.login.LoginObject;

public class AdressDAOImpl extends BaseDAOImpl implements AdressDAO{
	
	public AdressDAOImpl(DAOFactory daoFactory) {
		super(daoFactory);
	}

	@Override
	public AdressDTO getAdressByEmail(LoginObject lo, String email) throws DAOException {
		
		AdressDTO retVal = new AdressDTO();
		String query = "SELECT * FROM Adresse where email=?";
		
		ResultSet rs = super.executeSelect(lo, query, new Object[]{email});
		
		try {
			while(rs.next()) {
				retVal.fillUpRecord(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return retVal;
	}
    
}
