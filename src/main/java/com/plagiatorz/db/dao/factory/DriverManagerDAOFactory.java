package com.plagiatorz.db.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.plagiatorz.db.dao.exception.DAOException;

class DriverManagerDAOFactory extends DAOFactory {
    private String url;
    private String username;
    private String password;

    public DriverManagerDAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws DAOException {
        Connection con = null;
        
        	try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				throw new DAOException("Connection failed", e);
			}
		
        
        return con;
    }
}

