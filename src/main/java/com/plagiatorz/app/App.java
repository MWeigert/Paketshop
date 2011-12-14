package com.plagiatorz.app;

import java.util.Date;
import java.util.List;

import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.PaketDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.db.dto.PaketDTO;
import com.plagiatorz.global.Constants;
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
    	
    	AdressDTO ad = new AdressDTO();
    	ad.setEmail("emil@mail.ch");
    	ad.setPasswort("passwort");
    	ad.setName("Eine");
    	ad.setVorname("Emil");

		//createAdressWithoutAuthorisation Aufruf-Beispiel
    	try {
			dao.createAdressWithoutAuthorisation(ad);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        LoginObject lo = new LoginObject();
        lo.setEmail("emil@mail.ch");
        lo.setPassword("passwort");
      

		//getAdressByEmail Aufruf-Beispiel
		try {
			AdressDTO dto = dao.getAdressByEmail(lo, "emil@mail.ch");
			System.err.println(lo.getEnrichedLoginData().getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}

    
		//getAdressListByAdressType Aufruf-Beispiel
		try {
			List<AdressDTO> list = dao.getAdressListByAdressType(lo, Constants.DEFAULTADRESSTYP);
			System.out.println(list.size());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		PaketDAO pa = daof.getPaketDAO();
		PaketDTO pdto = new PaketDTO();
		pdto.setKundenId(3);
		pdto.setMahnStatus(2);
		pdto.setBuHaStatus("kein plan");
		pdto.setKategorie(4);
		pdto.setStatus(2);
		pdto.setLagerOrt(1);

		//createPaket Aufruf-Beispiel
		try {
			pa.createPaket(lo, pdto);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
