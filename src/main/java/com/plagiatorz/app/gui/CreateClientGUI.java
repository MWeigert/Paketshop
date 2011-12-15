/**
 * 
 */
package com.plagiatorz.app.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.exception.ValidationException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.login.LoginObject;

/**
 * @author MWeigert
 *
 */
public class CreateClientGUI {
	
	private JFrame frame = new JFrame("Kunde erfassen");

	public void createClientFrame() {
		// Allgemeiner Teil Frame und Panel werden erstellt & konfiguriert
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(new EmptyBorder(3, 3, 3, 3));
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 20;
		gc.weighty = 18;
		gc.gridy = 0;
		gc.gridx = 0;
		gc.gridheight = 1;
		gc.gridwidth = 10;
		
		// Erste Zeile mit Labels zu Name & Vorname
		JLabel nameLbl = new JLabel("Name");
		panel.add(nameLbl, gc);
		
		gc.gridx = 10;
		JLabel vornameLbl = new JLabel("Vorname");
		panel.add(vornameLbl, gc);
		
		// Zweite Zeile mit Feldern zu Name & Vorname
		gc.gridy = 1;
		gc.gridx = 0;
		final JTextField nameFld = new JTextField();
		panel.add(nameFld, gc);
		
		gc.gridx = 10;
		gc.gridwidth = 10;
		final JTextField vornameFld = new JTextField();
		panel.add(vornameFld, gc);
		
		// Dritte Zeile mit Label zu Strasse & Hausnummer
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 10;
		JLabel strasseLbl = new JLabel("Strasse");
		panel.add(strasseLbl, gc);
		
		gc.gridx = 15;
		gc.gridwidth = 2;
		JLabel nrLbl = new JLabel("Nr.");
		panel.add(nrLbl, gc);
		
		// Vierte Zeile mit Feldern zu Strasse & Hausnummer
		gc.gridy = 3;
		gc.gridx = 0;
		gc.gridwidth = 16;
		final JTextField strasseFld = new JTextField();
		panel.add(strasseFld, gc);
		
		gc.gridx = 15;
		gc.gridwidth = 3;
		final JTextField nrFld = new JTextField();
		panel.add(nrFld, gc);
		
		// Fünfte Zeile mit Label Adress Zusatz
		gc.gridy = 4;
		gc.gridx = 0;
		gc.gridwidth = 20;
		JLabel zusatzLbl = new JLabel("Adress Zusatz");
		panel.add(zusatzLbl, gc);
		
		// Sechste Zeile mit Feld Adress Zusatz
		gc.gridy = 5;
		JTextField zusatzFld = new JTextField();
		panel.add(zusatzFld, gc);
		
		// Siebte Zeile mit den Labeln Land, PLZ und Ort
		gc.gridx = 0;
		gc.gridy = 6;
		gc.gridwidth = 1;
		JLabel landLbl = new JLabel("Land");
		panel.add(landLbl, gc);
		
		gc.gridx = 3;
		gc.gridwidth = 2;
		JLabel plzLbl = new JLabel("PLZ");
		panel.add(plzLbl, gc);
		
		gc.gridx = 6;
		gc.gridwidth = 14;
		JLabel ortLbl = new JLabel("Ort");
		panel.add(ortLbl, gc);
		
		// Achte Zeile mit den Feldern Land, PLZ und Ort
		gc.gridx = 0;
		gc.gridy = 7;
		gc.gridwidth = 1;
		final JTextField landFld = new JTextField();
		panel.add(landFld, gc);
		
		gc.gridx = 3;
		gc.gridwidth = 2;
		final JTextField plzFld = new JTextField();
		panel.add(plzFld, gc);
		
		gc.gridx = 6;
		gc.gridwidth = 14;
		final JTextField ortFld = new JTextField();
		panel.add(ortFld, gc);
		
		// Neunte Zeile Leerzeile
		gc.gridx = 0;
		gc.gridy = 8;
		JLabel spacer2 = new JLabel(" ");
		panel.add(spacer2, gc);
		
		// Zehnte Zeile Label Telefonnummer
		gc.gridx = 0;
		gc.gridy = 9;
		gc.gridwidth = 20;
		JLabel phoneLbl = new JLabel("Telefonnummer");
		panel.add(phoneLbl, gc);
		
		// Elfte Zeile Feld Telefonnummer
		gc.gridx = 0;
		gc.gridy = 10;
		final JTextField phoneFld = new JTextField();
		panel.add(phoneFld, gc);
		
		// Zwölfte Zeile Label Handy Nummer
		gc.gridx = 0;
		gc.gridy = 11;
		JLabel handyLbl = new JLabel("Mobile");
		panel.add(handyLbl, gc);
		
		// Dreizehnte Zeile Feld Handy Nummer
		gc.gridx = 0;
		gc.gridy = 12;
		final JTextField handyFld = new JTextField();
		panel.add(handyFld, gc);
		
		// Vierzehnte Zeile Label E-Mail
		gc.gridx = 0;
		gc.gridy = 13;
		JLabel mailLbl = new JLabel("E-Mail");
		panel.add(mailLbl, gc);
		
		// Fünfzehnte Zeile Feld E-Mail
		gc.gridx = 0;
		gc.gridy = 14;
		final JTextField mailFld = new JTextField();
		panel.add(mailFld, gc);
		
		// Sechszehnte Zeile Leerzeile
		gc.gridx = 0;
		gc.gridy = 15;
		JLabel spacer3 = new JLabel(" ");
		panel.add(spacer3, gc);
		
		
		// Siebzehnte Zeile Label Passwort
		gc.gridx = 0;
		gc.gridy = 16;
		JLabel pwdLbl = new JLabel("Passwort");
		panel.add(pwdLbl, gc);
		
		// Achzehnte Zeile Field Passwort
		gc.gridx = 0;
		gc.gridy = 17;
		final JPasswordField pwdFld = new JPasswordField();
		panel.add(pwdFld, gc);
		
		
		// Neunzehnte Zeile Leerzeile
		gc.gridx = 0;
		gc.gridy = 18;
		JLabel spacer4 = new JLabel(" ");
		panel.add(spacer4, gc);
		
		// Zwanzigste Zeile Button Zeile
		gc.gridx = 0;
		gc.gridy = 19;
		gc.gridwidth = 10;
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		panel.add(cancelBtn, gc);
		
		gc.gridx = 11;
		JButton createBtn = new JButton("Create");
		createBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdressDTO adress = new AdressDTO();
				adress.setName(nameFld.getText());
				adress.setVorname(vornameFld.getText());
				adress.setStrasse(strasseFld.getText());
				adress.setStrassenNr(nrFld.getText());
				adress.setLand(landFld.getText());
				adress.setPlz(plzFld.getText());
				adress.setOrt(ortFld.getText());
				adress.setTelefon(phoneFld.getText());
				adress.setMobile(handyFld.getText());
				adress.setEmail(mailFld.getText());
				adress.setPasswort(pwdFld.getText());
				try {
					adress.validate();

					DAOFactory factory = DAOFactory.getInstance();
					AdressDAO dao = factory.getAdressDAO();
					LoginObject lo = new LoginObject();
					lo.setEmail("emil@mail.ch");
					lo.setPassword("passwort");
					
					try {
						dao.createAdress(lo, adress);
						JOptionPane.showMessageDialog(null, "User efolgreich angelegt", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
					} catch (DAOException e1) {
						e1.printStackTrace();
					}
				} catch (ValidationException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Fehlerhafte eingabe", JOptionPane.ERROR_MESSAGE);
				}
				
				
//				frame.dispose();
			}
		});
		panel.add(createBtn, gc);
		
		// Frame added Panel und wird sichtbar
		frame.add(panel);
		frame.setSize(300, 400);
		frame.setVisible(true);
	}
}
