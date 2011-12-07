package com.plagiatorz.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.plagiatorz.db.dao.utility.DAOException;
import com.plagiatorz.login.LoginObject;

public interface BaseDAO {

	public ResultSet executeSelect(LoginObject loginObj, String query, Object... values) throws SQLException, DAOException;
	
}
