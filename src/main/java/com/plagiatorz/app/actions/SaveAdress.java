package com.plagiatorz.app.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;

import com.plagiatorz.app.bean.AdressBean;
import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.db.dto.exception.ValidationException;
import com.plagiatorz.global.Constants;
import com.plagiatorz.login.LoginObject;

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
			char[] pwChar = adressBean.getPasswort().getPassword();
			StringBuilder sb = new StringBuilder();
			for(char c : pwChar) {
				sb.append(c);
			}
			adress.setPasswort(sb.toString());
	
			DAOFactory factory = DAOFactory.getInstance();
			AdressDAO dao = factory.getAdressDAO();
			LoginObject lo = new LoginObject();
			lo.setEmail("emil@mail.ch");
			lo.setPassword("passworttt");
			
			try {
				dao.createAdress(lo, adress);
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
