package com.plagiatorz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import junit.framework.TestCase;


public class MySQLConnectionTest extends TestCase {

	public void testConnection() {
		String dbUrl = "jdbc:mysql://www.fun-diver.ch:3306/paketshop";
		String dbClass = "com.mysql.jdbc.Driver";
		String username = "mdpAdmin";
		String password = "mdppaketshop";
		try {
  
			Class.forName(dbClass);
			Connection connection = DriverManager.getConnection(dbUrl,
					username, password);
			connection.close();

	        assertTrue( true );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	        assertTrue( false );
		} catch (SQLException e) {
			e.printStackTrace();
	        assertTrue( false );
		}
	}
}
