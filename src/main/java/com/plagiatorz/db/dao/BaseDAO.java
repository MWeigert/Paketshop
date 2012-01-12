package com.plagiatorz.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.login.LoginObject;

public interface BaseDAO {

	/**
	 * 1. autorisierungs-Chek
	 * 2. Query mit Werten abfuellen
	 * 3. Query ausfuehren und ResultSet zurueckgeben
	 * @param loginObj LoginDaten
	 * @param query Im spezifischen DAO definierte DB-Query
	 * @param values Filter-Werte der Query
	 * @return ResultSet
	 */
	public ResultSet executeSelect(LoginObject loginObj, String query, Object... values) throws SQLException, DAOException;

	/**
	 * Benutzer mit den uebergebenen Werten erstellen
	 * @param adress Adresswerte
	 * @return id des neuen Records
	 */
	public int createAdressWithoutAuthorisation(AdressDTO adress) throws DAOException;

	/**
	 * 1. autorisierungs-Chek
	 * 2. Query mit Werten abfuellen
	 * 3. Query create ausfuehren
	 * @param loginObj LoginDaten
	 * @param query Im spezifischen DAO definierte Insert-Query
	 * @param values Werte, die hinzugefuegt werden muessen
	 * @return id des neuen Records
	 */
	public int createRecord(LoginObject loginObj, String query, Object... values) throws DAOException;
	
	/**
	 * 1. autorisierungs-Chek
	 * 2. Query mit Werten abfuellen
	 * 3. update-query ausfuehren
	 * @param loginObj LoginDaten
	 * @param query Im spezifischen DAO definierte Insert-Query
	 * @param values Werte, die hinzugefuegt werden muessen
	 */
	public void updateRecord(LoginObject loginObj, String query, Object[] values, Object[] where) throws DAOException;
}
