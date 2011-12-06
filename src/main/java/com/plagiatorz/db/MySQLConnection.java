package com.plagiatorz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.plagiatorz.login.LoginEnrichedData;
import com.plagiatorz.login.LoginObject;

public final class MySQLConnection {

	public static final Connection getConnection(LoginObject lo) throws Exception {
		Connection con = null;

		String dbUrl = "jdbc:mysql://www.fun-diver.ch/paketshop";
		String dbClass = "com.mysql.jdbc.Driver";
		String username = "mdpAdmin";
		String password = "mdppaketshop";
		String query = "SELECT id, AdressTyp FROM Adresse WHERE email=? and passwort=?;";

		lo.setEnrichedLoginData(null);
		try {
			Class.forName(dbClass);
			con = DriverManager.getConnection(dbUrl, username, password);

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
				MySQLConnection.connectionClose(con);
				throw new Exception("Login fehlgeschlagen");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public static final void connectionClose(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
