package com.plagiatorz.db.dao;

import java.util.List;

import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.login.LoginObject;

/**
 * Beinhaltet alle DB-Andbindungen, welche mit Adresse zu tun haben
 * @author MARIUS
 *
 */
public interface AdressDAO extends BaseDAO {

	/**
	 * Adresse anhand von einer Emailadresse holen (z.B. zum bearbeiten)
	 * @param lo
	 * @param email
	 * @return
	 * @throws DAOException
	 */
	public AdressDTO getAdressByEmail(LoginObject lo, String email) throws DAOException;

	/**
	 * Alle Adresstypen der gleichen sorte holen (Bsp: normale Kunden)
	 * @param lo
	 * @param adressType
	 * @return
	 * @throws DAOException
	 */
	public List<AdressDTO> getAdressListByAdressType(LoginObject lo, int adressType) throws DAOException;
	
	/**
	 * Neue Adresse hinzufuegen
	 * @param lo
	 * @param adress
	 * @throws DAOException
	 */
	public void createAdress(LoginObject lo, AdressDTO adress) throws DAOException;

	/**
	 * Spezifische Adresse updaten (wird anhand der Id updated)
	 * @param lo
	 * @param adress
	 * @throws DAOException
	 */
	public void updateAdress(LoginObject lo, AdressDTO adress) throws DAOException;
}
