package com.plagiatorz.app.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.plagiatorz.app.actions.actionListener.LoginAction;
import com.plagiatorz.app.bean.LoginBean;

/**
 * Login Maske, wird als default beim Programmstart aufgerufen
 * @author MARIUS
 *
 */
public class LoginGUI implements BaseGUIInterface{

	private LoginBean loginBean;
	private LoginAction action;

	public LoginGUI(JFrame jFrame, JPanel jPanel) {
		super();
		loginBean = new LoginBean(jFrame, jPanel);
		action = new LoginAction(loginBean);
	}

	public void displayContentPanel() {

		MenuBarBuilder.buildMenubar(loginBean);
		
		loginBean.setContentPanel(new JPanel(new GridBagLayout()));

		loginBean.getContentPanel().setBorder(new EmptyBorder(3, 3, 3, 3));
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 20;
		gc.weighty = 18;
		gc.gridy = 0;
		gc.gridx = 0;
		gc.gridheight = 1;
		gc.gridwidth = 10;

		JLabel mailLbl = new JLabel("E-Mail:");
		loginBean.getContentPanel().add(mailLbl, gc);

		gc.gridx = 10;
		gc.gridy = 0;
		loginBean.getContentPanel().add(loginBean.getEmail(), gc);


		gc.gridx = 0;
		gc.gridy = 1;
		JLabel spacer3 = new JLabel(" ");
		loginBean.getContentPanel().add(spacer3, gc);
		
		// Siebzehnte Zeile Label Passwort
		gc.gridx = 0;
		gc.gridy = 2;
		JLabel pwdLbl = new JLabel("Passwort");
		loginBean.getContentPanel().add(pwdLbl, gc);
		
		// Achzehnte Zeile Field Passwort
		gc.gridx = 10;
		gc.gridy = 2;
		loginBean.getContentPanel().add(loginBean.getPasswort(), gc);

		gc.gridx = 0;
		gc.gridy = 3;
		loginBean.getCreateBtn().addActionListener(action);
		loginBean.getContentPanel().add(loginBean.getCreateBtn(), gc);

		gc.gridx = 10;
		loginBean.getLoginBtn().addActionListener(action);
		loginBean.getContentPanel().add(loginBean.getLoginBtn(), gc);
		
		loginBean.setFrameVisible();
		
	}

}
