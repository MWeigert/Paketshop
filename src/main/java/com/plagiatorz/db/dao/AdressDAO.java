package com.plagiatorz.db.dao;

import java.util.List;

import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.login.LoginObject;

public interface AdressDAO extends BaseDAO {

	public AdressDTO getAdressByEmail(LoginObject lo, String email) throws DAOException;

	public List<AdressDTO> getAdressListByAdressType(LoginObject lo, int adressType) throws DAOException;
	
	public void createAdress(LoginObject lo, AdressDTO adress) throws DAOException;
}
