package com.plagiatorz.app;

import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dao.utility.DAOException;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.login.LoginObject;

/**
 * Hello world!
 *
 */
public class App 
{
	//TODO: unter Dropbox\MdP_Paketshop\00 Rahmenbedingungen daoProperties herunterladen und in das Rootverzeichnis kopieren
    public static void main( String[] args )
    {
    	  
        DAOFactory daof = DAOFactory.getInstance();        
		AdressDAO dao = daof.getAdressDAO();
		
//        LoginObject lo = new LoginObject();
//        lo.setEmail("emil@mail.ch");
//        lo.setPassword("passwort");
//      
//		
//		try {
//			AdressDTO dto = dao.getAdressByEmail(lo, "emil@mail.ch");
////			System.err.println(dto.getId());
//			System.err.println(lo.getEnrichedLoginData().getId());
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
    	
    	AdressDTO ad = new AdressDTO();
    	ad.setEmail("emil@mail.ch");
    	ad.setPasswort("passwort");
    	ad.setName("Eine");
    	ad.setVorname("Emil");
    	
    	try {
			dao.createAdressWithoutAuthorisation(ad);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
