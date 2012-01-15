package com.plagiatorz.db.dao;

import java.util.List;

import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dto.PaketDTO;
import com.plagiatorz.login.LoginObject;

public interface PaketDAO extends BaseDAO {

	public void createPaket(LoginObject lo, PaketDTO paket) throws DAOException;
	
	public List<PaketDTO> getPaketeByUser(LoginObject lo) throws DAOException;
}
