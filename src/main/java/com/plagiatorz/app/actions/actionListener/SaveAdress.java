package com.plagiatorz.app.actions.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;

import com.plagiatorz.app.bean.AdressBean;
import com.plagiatorz.app.exception.ValidationException;
import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.global.Constants;

/**
 * Speichert die neue Adresse
 * 1. Validierung (Popup mit Fehlerbeschreib, falls fehlgeschlagen)
 * 2. DTO abfuellen
 * 3. Save-Funktion aufrufen
 * @author Plagiatorz
 *
 */
public class SaveAdress implements ActionListener {

	private AdressBean adressBean;
	
	public SaveAdress(AdressBean adress) {
		super();
		this.adressBean = adress;
	}

	public void setAdress(AdressBean adr) {
		adressBean = adr;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			adressBean.validate();
				
			AdressDTO adress = new AdressDTO();
			adress.setName(adressBean.getName().getText());
			adress.setVorname(adressBean.getVorname().getText());
			adress.setStrasse(adressBean.getStrasse().getText());
			adress.setStrassenNr(adressBean.getStrassenNr().getText());
			adress.setLand(adressBean.getLand().getText());
			adress.setPlz(adressBean.getPlz().getText());
			adress.setOrt(adressBean.getOrt().getText());
			adress.setTelefon(adressBean.getTelefon().getText());
			adress.setMobile(adressBean.getMobile().getText());
			adress.setEmail(adressBean.getEmail().getText());
			adress.setPasswort(adressBean.getPasswortVal());
			
			DAOFactory factory = DAOFactory.getInstance();
			AdressDAO dao = factory.getAdressDAO();
			
			try {
				dao.createAdress(null, adress);
				JOptionPane.showMessageDialog(null, "User efolgreich angelegt", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
			} catch (DAOException e1) {
				if(StringUtils.equals(Constants.LOGINERROR, e1.getMessage())) {
					JOptionPane.showMessageDialog(null, "User efolgreich angelegt", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					e1.printStackTrace();
				}
			}
		} catch (ValidationException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), "Fehlerhafte eingabe", JOptionPane.ERROR_MESSAGE);
		}
		
		
//		frame.dispose();
	}

}
