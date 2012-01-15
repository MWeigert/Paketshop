/**
 * 
 */
package com.plagiatorz.app.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.plagiatorz.app.actions.actionListener.SaveAdress;
import com.plagiatorz.app.bean.AdressBean;
import com.plagiatorz.app.bean.PaketBean;

/**
 * Anzeige der Adresse
 * Wird aufgerufen, beim erfassen eines neuen Kunden, sowie beim Editieren eines bestehenden
 * @author Plagiatorz
 *
 */
public class ClientGUI implements BaseGUIInterface{
	
	private AdressBean adressBean;
	private SaveAdress save;
	private PaketBean paketBean;
	
	public ClientGUI(JFrame jFrame, JPanel jPanel) {
		super();
		adressBean = new AdressBean(jFrame, jPanel);
		save = new SaveAdress(adressBean);
	}
	
	public ClientGUI(AdressBean bean) {
		super();
		adressBean = bean;
		save = new SaveAdress(adressBean);
	}

	public ClientGUI(PaketBean bean) {
		super();
		paketBean = bean;
	}
	
	public void displayContentPanel() {
		// Allgemeiner Teil Frame und Panel werden erstellt & konfiguriert
		
		adressBean.setContentPanel(new JPanel(new GridBagLayout()));
		adressBean.getContentPanel().setBorder(new EmptyBorder(3, 3, 3, 3));
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
		adressBean.getContentPanel().add(nameLbl, gc);
		
		gc.gridx = 10;
		JLabel vornameLbl = new JLabel("Vorname");
		adressBean.getContentPanel().add(vornameLbl, gc);
		
		// Zweite Zeile mit Feldern zu Name & Vorname
		gc.gridy = 1;
		gc.gridx = 0;
//		final JTextField nameFld = new JTextField();
//		nameFld.setName(adressBean.getName());
		adressBean.getContentPanel().add(adressBean.getName(), gc);
		
		gc.gridx = 10;
		gc.gridwidth = 10;
		adressBean.getContentPanel().add(adressBean.getVorname(), gc);
		
		// Dritte Zeile mit Label zu Strasse & Hausnummer
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 10;
		JLabel strasseLbl = new JLabel("Strasse");
		adressBean.getContentPanel().add(strasseLbl, gc);
		
		gc.gridx = 15;
		gc.gridwidth = 2;
		JLabel nrLbl = new JLabel("Nr.");
		adressBean.getContentPanel().add(nrLbl, gc);
		
		// Vierte Zeile mit Feldern zu Strasse & Hausnummer
		gc.gridy = 3;
		gc.gridx = 0;
		gc.gridwidth = 16;
		adressBean.getContentPanel().add(adressBean.getStrasse(), gc);
		
		gc.gridx = 15;
		gc.gridwidth = 3;
		adressBean.getContentPanel().add(adressBean.getStrassenNr(), gc);
		
		// Fuenfte Zeile mit Label Adress Zusatz
		gc.gridy = 4;
		gc.gridx = 0;
		gc.gridwidth = 20;
		JLabel zusatzLbl = new JLabel("Adress Zusatz");
		adressBean.getContentPanel().add(zusatzLbl, gc);
		
		// Sechste Zeile mit Feld Adress Zusatz
		gc.gridy = 5;
		adressBean.getContentPanel().add(adressBean.getZusatzzeile(), gc);
		
		// Siebte Zeile mit den Labeln Land, PLZ und Ort
		gc.gridx = 0;
		gc.gridy = 6;
		gc.gridwidth = 1;
		JLabel landLbl = new JLabel("Land");
		adressBean.getContentPanel().add(landLbl, gc);
		
		gc.gridx = 3;
		gc.gridwidth = 2;
		JLabel plzLbl = new JLabel("PLZ");
		adressBean.getContentPanel().add(plzLbl, gc);
		
		gc.gridx = 6;
		gc.gridwidth = 14;
		JLabel ortLbl = new JLabel("Ort");
		adressBean.getContentPanel().add(ortLbl, gc);
		
		// Achte Zeile mit den Feldern Land, PLZ und Ort
		gc.gridx = 0;
		gc.gridy = 7;
		gc.gridwidth = 1;
		adressBean.getContentPanel().add(adressBean.getLand(), gc);
		
		gc.gridx = 3;
		gc.gridwidth = 2;
		adressBean.getContentPanel().add(adressBean.getPlz(), gc);
		
		gc.gridx = 6;
		gc.gridwidth = 14;
		adressBean.getContentPanel().add(adressBean.getOrt(), gc);
		
		// Neunte Zeile Leerzeile
		gc.gridx = 0;
		gc.gridy = 8;
		JLabel spacer2 = new JLabel(" ");
		adressBean.getContentPanel().add(spacer2, gc);
		
		// Zehnte Zeile Label Telefonnummer
		gc.gridx = 0;
		gc.gridy = 9;
		gc.gridwidth = 20;
		JLabel phoneLbl = new JLabel("Telefonnummer");
		adressBean.getContentPanel().add(phoneLbl, gc);
		
		// Elfte Zeile Feld Telefonnummer
		gc.gridx = 0;
		gc.gridy = 10;
		adressBean.getContentPanel().add(adressBean.getTelefon(), gc);
		
		// Zwoelfte Zeile Label Handy Nummer
		gc.gridx = 0;
		gc.gridy = 11;
		JLabel handyLbl = new JLabel("Mobile");
		adressBean.getContentPanel().add(handyLbl, gc);
		
		// Dreizehnte Zeile Feld Handy Nummer
		gc.gridx = 0;
		gc.gridy = 12;
		adressBean.getContentPanel().add(adressBean.getMobile(), gc);
		
		// Vierzehnte Zeile Label E-Mail
		gc.gridx = 0;
		gc.gridy = 13;
		JLabel mailLbl = new JLabel("E-Mail");
		adressBean.getContentPanel().add(mailLbl, gc);
		
		// Fuenfzehnte Zeile Feld E-Mail
		gc.gridx = 0;
		gc.gridy = 14;
		if(adressBean.getId() != 0) {
			adressBean.getEmail().setEnabled(false);
		}
		adressBean.getContentPanel().add(adressBean.getEmail(), gc);
		
		// Sechszehnte Zeile Leerzeile
		gc.gridx = 0;
		gc.gridy = 15;
		JLabel spacer3 = new JLabel(" ");
		adressBean.getContentPanel().add(spacer3, gc);
		
		
		// Siebzehnte Zeile Label Passwort
		gc.gridx = 0;
		gc.gridy = 16;
		JLabel pwdLbl = new JLabel("Passwort");
		adressBean.getContentPanel().add(pwdLbl, gc);
		
		// Achzehnte Zeile Field Passwort
		gc.gridx = 0;
		gc.gridy = 17;
		adressBean.getContentPanel().add(adressBean.getPasswort(), gc);
		
		
		// Neunzehnte Zeile Leerzeile
		gc.gridx = 0;
		gc.gridy = 18;
		JLabel spacer4 = new JLabel(" ");
		adressBean.getContentPanel().add(spacer4, gc);
		
		// Zwanzigste Zeile Button Zeile
		gc.gridx = 0;
		gc.gridy = 19;
		gc.gridwidth = 10;
//		JButton cancelBtn = new JButton("Cancel");
//		cancelBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				frame.dispose();
//			}
//		});
//		panel.add(cancelBtn, gc);
		
		gc.gridx = 11;
		adressBean.getSaveBtn().addActionListener(save);
			
		adressBean.getContentPanel().add(adressBean.getSaveBtn(), gc);
		
		adressBean.setFrameVisible();
	}
}
