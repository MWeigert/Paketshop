package com.plagiatorz.db.dao;

import com.plagiatorz.db.dao.utility.DAOException;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.login.LoginObject;

public interface AdressDAO extends BaseDAO {

	public AdressDTO getAdressByEmail(LoginObject lo, String email) throws DAOException;
	
	public void createAdress(LoginObject lo, AdressDTO adress) throws DAOException;
}
