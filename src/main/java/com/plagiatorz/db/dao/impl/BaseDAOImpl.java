package com.plagiatorz.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.plagiatorz.db.dao.BaseDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dao.utility.DaoUtil;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.login.LoginEnrichedData;
import com.plagiatorz.login.LoginObject;

public abstract class BaseDAOImpl implements BaseDAO{

	private static final String CREATEADRESS = "INSERT INTO Adresse (name, vorname, strasse, strassenNr, zusatzzeile, land,"
																  +"plz, ort, mobile, telefonp, email, passwort)";
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
	public int createRecord(LoginObject loginObj, String query, Object... values) throws DAOException {

        Connection connection = daoFactory.getConnection();
        int id = 0;
        
		try {
			Statement statement = connection.createStatement(
			        Statement.CLOSE_ALL_RESULTS, Statement.RETURN_GENERATED_KEYS);
			StringBuilder sb = new StringBuilder(query);
			sb.append("VALUES(");
			for(Object val :values){
				if(val == null) {
					sb.append("null,");
				}
				else if(val instanceof String) {
					sb.append("'").append(val).append("',");
				}
				else {
					sb.append(val).append(",");
				}
			}
			sb.replace(sb.length()-1, sb.length(), ")"); //letztes "," durch ein ")" ersetzen
			System.out.println(sb);
			id = statement.executeUpdate(sb.toString());
			
		} catch (SQLException e) {
			throw new DAOException(e.getCause());
		}
		
		return id;
	}

	public int createAdressWithoutAuthorisation(AdressDTO adress) throws DAOException {

        Connection connection = daoFactory.getConnection();
        int id = 0;
        
		try {
			Statement statement = connection.createStatement(
			        Statement.CLOSE_ALL_RESULTS, Statement.RETURN_GENERATED_KEYS);
			StringBuilder sb = new StringBuilder(CREATEADRESS);
			sb.append("VALUES('").append(adress.getName() == null ? "" : adress.getName())
			.append("', '").append(adress.getVorname() == null ? "" : adress.getVorname())
			.append("', '").append(adress.getStrasse() == null ? "" : adress.getStrasse())
			.append("', '").append(adress.getStrassenNr() == null ? "" : adress.getStrassenNr())
			.append("', '").append(adress.getZusatzzeile() == null ? "" : adress.getZusatzzeile())
			.append("', '").append(adress.getLand() == null ? "" : adress.getLand())
			.append("', '").append(adress.getPlz() == null ? "" : adress.getPlz())
			.append("', '").append(adress.getOrt() == null ? "" : adress.getOrt())
			.append("', '").append(adress.getMobile() == null ? "" : adress.getMobile())
			.append("', '").append(adress.getTelefon() == null ? "" : adress.getTelefon())
			.append("', '").append(adress.getEmail() == null ? "" : adress.getEmail())
			.append("', '").append(adress.getPasswort() == null ? "" : adress.getPasswort()).append("')");
			
			id = statement.executeUpdate(sb.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

    protected void checkLogin(Connection con, LoginObject lo) throws DAOException{
		String query = "SELECT id, AdressTyp FROM Adresse WHERE email=? and passwort=?;";

		lo.setEnrichedLoginData(null);
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, lo.getEmail());
			statement.setString(2, lo.getPassword());
			ResultSet resultSet = statement.executeQuery();
			
			if(lo.getEnrichedLoginData() == null) {
				while(resultSet.next()) {
					int id = resultSet.getInt(1);
					int adrType = resultSet.getInt(2);
					lo.setEnrichedLoginData(new LoginEnrichedData(id, adrType));
				}
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
