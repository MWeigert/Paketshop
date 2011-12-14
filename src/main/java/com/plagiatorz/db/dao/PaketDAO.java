package com.plagiatorz.db.dao;

import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dto.PaketDTO;
import com.plagiatorz.login.LoginObject;

public interface PaketDAO extends BaseDAO {

	public void createPaket(LoginObject lo, PaketDTO paket) throws DAOException;
}
