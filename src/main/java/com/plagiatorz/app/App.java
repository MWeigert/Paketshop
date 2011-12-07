package com.plagiatorz.app;

import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dao.utility.DAOException;
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
        lo.setPassword("passwort");
        
        DAOFactory daof = DAOFactory.getInstance();
        System.out.println("DAOFactory successfull: " + daof);
        
		AdressDAO ad = daof.getAdressDAO();
		System.out.println("adressDAO:"+ad);
		
		try {
			ad.getAdressByEmail(lo, "max@muster.ch");
		} catch (DAOException e) {
			e.printStackTrace();
		}
//        Connection con = null;
//        
//        try {
//			con = MySQLConnection.getConnection(lo);
//			System.out.println("connection erfolgreich");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		MySQLConnection.connectionClose(con);
        
        
    }
}
