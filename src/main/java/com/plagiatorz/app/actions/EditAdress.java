package com.plagiatorz.app.actions;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.plagiatorz.app.bean.AdressBean;
import com.plagiatorz.app.gui.ClientGUI;
import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.global.Constants;
import com.plagiatorz.global.Utils;
import com.plagiatorz.login.LoginObject;

/**
 * Speichert die neue Adresse
 * 1. Validierung (Popup mit Fehlerbeschreib, falls fehlgeschlagen)
 * 2. DTO abfuellen
 * 3. Save-Funktion aufrufen
 * @author Plagiatorz
 *
 */
public class EditAdress {

	private AdressBean adressBean;
	
	public EditAdress(JFrame frame, JPanel contentPanel) {
		super();
		adressBean = new AdressBean(frame, contentPanel);
		adressBean.setSaveBtn(new JButton("Speichern"));
	}

	public void execute() {

			DAOFactory factory = DAOFactory.getInstance();
			AdressDAO dao = factory.getAdressDAO();

			System.out.println(System.getProperty(Constants.EMAILPROPERTY));
			
			try {
				LoginObject lo = Utils.getLoginObject();
				AdressDTO dto = dao.getAdressByEmail(lo, lo.getEmail());
				adressBean.getName().setText(dto.getName());
				adressBean.getVorname().setText(dto.getVorname());
				adressBean.getStrasse().setText(dto.getStrasse());
				adressBean.getStrassenNr().setText(dto.getStrassenNr());
				adressBean.getLand().setText(dto.getLand());
				adressBean.getPlz().setText(dto.getPlz());
				adressBean.getOrt().setText(dto.getOrt());
				adressBean.getTelefon().setText(dto.getTelefon());
				adressBean.getEmail().setText(dto.getEmail());
				adressBean.getPasswort().setText(dto.getPasswort());
				
				ClientGUI gui = new ClientGUI(adressBean);
				gui.displayContentPanel();
			} catch (DAOException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			
	}

}
