package com.plagiatorz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;


public class MySQLConnectionTest extends TestCase {

	public void testConnection() {
		String dbUrl = "jdbc:mysql://www.fun-diver.ch/paketshop";
		String dbClass = "com.mysql.jdbc.Driver";
		String username = "mdpAdmin";
		String password = "mdppaketshop";
		String query = "SELECT 1 FROM dual";
		Connection connection = null;
		try {

			new com.mysql.jdbc.Driver();
			Class.forName(dbClass);
			connection = DriverManager.getConnection(dbUrl,
					username, password);
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			resultSet.next();

	        assertTrue( resultSet.getLong(1) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	        assertTrue( false );
		} catch (SQLException e) {
			e.printStackTrace();
	        assertTrue( false );
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
		        assertTrue( false );
			}
		}
	}
}