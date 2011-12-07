package com.plagiatorz.db;

import junit.framework.TestCase;


public class MySQLConnectionTest extends TestCase {

//	public void testConnection() {
//		String query = "SELECT 1 FROM dual";
//		Connection connection = null;
//		try {
//			Class.forName(Constants.CONNECTIONDRIVER);
//			connection = DriverManager.getConnection(Constants.DBURL,Constants.USERNAME, Constants.PW);
//			
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery(query);
//			
//			resultSet.next();
//
//	        assertTrue( resultSet.getLong(1) == 1);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//	        assertTrue( false );
//		} catch (SQLException e) {
//			e.printStackTrace();
//	        assertTrue( false );
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//		        assertTrue( false );
//			}
//		}
//		
//	}
//	
//	public void testSuccessLogin() {
//
//        LoginObject lo = new LoginObject();
//        lo.setEmail("max@muster.ch");
//        lo.setPassword("passwort");
//        
//        Connection con = null;
//        try {
//			con =  MySQLConnection.getConnection(lo);
//			assertTrue(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//			assertTrue(false);
//		}
//		MySQLConnection.connectionClose(con);
//	}
//	
//	public void testInvalidLogin() {
//
//        LoginObject lo = new LoginObject();
//        lo.setEmail("max@muster.ch");
//        lo.setPassword("ein falsches");
//
//        Connection con = null;
//        try {
//			con = MySQLConnection.getConnection(lo);
//			assertTrue(false);
//			MySQLConnection.connectionClose(con);
//		} catch (Exception e) {
//			assertTrue(true);
//		}
//	}
}
