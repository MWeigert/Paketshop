package com.plagiatorz.db.dao;

import java.util.List;

import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dto.ValuePairDTO;
import com.plagiatorz.login.LoginObject;

/**
 * DAO fuer Referenzdaten, generell ohne zusaetzliche WHERE einschraenkungen
 * @author MARIUS
 *
 */
public interface ReferenzDAO extends BaseDAO {

	/**
	 * 
	 * @param lo
	 * @return Liste mit allen gueltigen PaketKategorien
	 * @throws DAOException
	 */
	public List<ValuePairDTO> getAllPaketKategorien(LoginObject lo) throws DAOException;

	/**
	 * 
	 * @param lo
	 * @return Liste mit allen moeglichen Paket Status
	 * @throws DAOException
	 */
	public List<ValuePairDTO> getAllPaketStatus(LoginObject lo) throws DAOException;

	/**
	 * 
	 * @param lo
	 * @return Liste mit allen moeglichen Mahn Status
	 * @throws DAOException
	 */
	public List<ValuePairDTO> getAllMahnStatus(LoginObject lo) throws DAOException;

	/**
	 * 
	 * @param lo
	 * @return Liste mit verfuegbaren Lager
	 * @throws DAOException
	 */
	public List<ValuePairDTO> getAllLager(LoginObject lo) throws DAOException;
}
