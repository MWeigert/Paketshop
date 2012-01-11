package com.plagiatorz.app.actions.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.plagiatorz.app.bean.LoginBean;
import com.plagiatorz.app.gui.ClientGUI;
import com.plagiatorz.db.dao.LoginDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.global.Constants;
import com.plagiatorz.login.LoginObject;

/**
 * LoginAction
 * Moegliche Taetigkeiten
 * 	1. Neuen Benutzer anlegen
 *  2. erfolgreiches Login
 *  3. Login mit Fehlermeldung
 * @author MARIUS
 *
 */
public class LoginAction implements ActionListener {

	private LoginBean bean;
	
	public LoginAction(LoginBean bean) {
		this.bean = bean;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getActionCommand().equals(bean.getCreateBtn().getText())) {
			ClientGUI client= new ClientGUI(bean.getFrame(), bean.getContentPanel());
			client.displayContentPanel();
		}
		
		else {
			LoginObject lo = new LoginObject();
			lo.setEmail(bean.getEmail().getText());
			lo.setPassword(bean.getPasswortVal());
			
			DAOFactory factory = DAOFactory.getInstance();
			LoginDAO dao = factory.getLoginDAO();

			try {
				dao.login(lo);
			    System.setProperty(Constants.EMAILPROPERTY, lo.getEmail());
			    System.setProperty(Constants.PWPROPERTY, lo.getPassword());
			    
				JOptionPane.showMessageDialog(null, "Guten Tag "+lo.getEmail(), "Erfolgreiche Anmeldung", JOptionPane.INFORMATION_MESSAGE);
				bean.getEmail().setText("");
				bean.getPasswort().setText("");

			} catch (DAOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}


}
