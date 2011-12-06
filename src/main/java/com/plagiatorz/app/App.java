package com.plagiatorz.app;

import java.sql.Connection;

import com.plagiatorz.db.MySQLConnection;
import com.plagiatorz.login.LoginObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LoginObject lo = new LoginObject();
        lo.setEmail("max@muster.ch");
        lo.setPassword("ll");
        Connection con = null;
        
        try {
			con = MySQLConnection.getConnection(lo);
			System.out.println("connection erfolgreich");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MySQLConnection.connectionClose(con);
    }
}
