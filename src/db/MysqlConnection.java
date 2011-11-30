package db;

import java.sql.*;


public class MysqlConnection {
	public static void main(String[] args) {
		String serverName = "localhost";
		String mydatabase = "mydatabase";
		String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
		String username = "username";
		String password = "password";

		try {
			// Load the JDBC driver
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);

			// Create a connection to the database
			Connection connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// Could not find the database driver
		} catch (SQLException e) {
			// Could not connect to the database
		}
	}
}
