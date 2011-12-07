package com.plagiatorz.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.plagiatorz.db.dao.BaseDAO;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dao.utility.DAOException;
import com.plagiatorz.db.dao.utility.DaoUtil;
import com.plagiatorz.login.LoginEnrichedData;
import com.plagiatorz.login.LoginObject;

public abstract class BaseDAOImpl implements BaseDAO{

    private DAOFactory daoFactory;

	public BaseDAOImpl(DAOFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}


	public ResultSet executeSelect(LoginObject loginObj, String query, Object... values) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Connection connection = daoFactory.getConnection();
        try {
        	checkLogin(connection, loginObj);

			preparedStatement = DaoUtil.prepareStatement(connection, query, false, values);
            resultSet = preparedStatement.executeQuery();

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return resultSet;
	}
	

    protected void checkLogin(Connection con, LoginObject lo) throws DAOException{
		String query = "SELECT id, AdressTyp FROM Adresse WHERE email=? and passwort=?;";

		lo.setEnrichedLoginData(null);
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, lo.getEmail());
			statement.setString(2, lo.getPassword());
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				int adrType = resultSet.getInt(2);
				lo.setEnrichedLoginData(new LoginEnrichedData(id, adrType));
			}
			if(lo.getEnrichedLoginData() == null) {
				con.close();
				throw new DAOException("Login fehlgeschlagen");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}
