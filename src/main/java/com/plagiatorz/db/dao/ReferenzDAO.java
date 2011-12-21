package com.plagiatorz.db.dao;

import java.util.List;

import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dto.ValuePairDTO;
import com.plagiatorz.login.LoginObject;

/**
 * DAO f�r Referenzdaten, generell ohne zus�tzliche WHERE einschr�nkungen
 * @author MARIUS
 *
 */
public interface ReferenzDAO extends BaseDAO {

	/**
	 * 
	 * @param lo
	 * @return Liste mit allen g�ltigen PaketKategorien
	 * @throws DAOException
	 */
	public List<ValuePairDTO> getAllPaketKategorien(LoginObject lo) throws DAOException;

	/**
	 * 
	 * @param lo
	 * @return Liste mit allen m�glichen Paket Status
	 * @throws DAOException
	 */
	public List<ValuePairDTO> getAllPaketStatus(LoginObject lo) throws DAOException;

	/**
	 * 
	 * @param lo
	 * @return Liste mit allen m�glichen Mahn Status
	 * @throws DAOException
	 */
	public List<ValuePairDTO> getAllMahnStatus(LoginObject lo) throws DAOException;

	/**
	 * 
	 * @param lo
	 * @return Liste mit verf�gbaren Lager
	 * @throws DAOException
	 */
	public List<ValuePairDTO> getAllLager(LoginObject lo) throws DAOException;
}
