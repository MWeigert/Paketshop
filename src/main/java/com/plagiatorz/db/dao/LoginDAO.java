package com.plagiatorz.db.dao;

import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.login.LoginObject;

public interface LoginDAO extends BaseDAO {

	public void login(LoginObject lo) throws DAOException;
}
