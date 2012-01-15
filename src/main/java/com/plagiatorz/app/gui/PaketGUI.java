package com.plagiatorz.app.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.plagiatorz.app.bean.PaketBean;

/**
 * @author M. Weigert
 * Design von M. Ott -> https://zhaw.mybalsamiq.com/projects/mdp_paketshop/Paket-Erfassung
 */
public class PaketGUI implements BaseGUIInterface {

	private PaketBean paketBean;

	public PaketGUI(JFrame jFrame, JPanel jPanel) {
		super();
		paketBean = new PaketBean(jFrame, jPanel);
	}

	/*
	 * Allgemeiner Teil Panel wird erstellt und paketBean übergeben
	 */
	@Override
	public void displayContentPanel() {
		paketBean.setContentPanel(new JPanel(new GridBagLayout()));
		paketBean.getContentPanel().setBorder(new EmptyBorder(3, 3, 3, 3));

		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 20;
		gc.weighty = 18;
		gc.gridy = 0;
		gc.gridx = 0;
		gc.gridheight = 1;
		gc.gridwidth = 5;
		
		// Erste Zeile mit Paket-ID und Datum
		JLabel paketIDLabel = new JLabel("Paket ID");
		paketBean.getContentPanel().add(paketIDLabel, gc);
		
		gc.gridx = 4;
		JTextField paketIDField = new JTextField();
		paketBean.getContentPanel().add(paketIDField, gc);
		
		gc.gridx = 10;
		JTextField datumField = new JTextField();
		paketBean.getContentPanel().add(datumField, gc);
		
		// Zweite Zeile Kunde
		gc.gridy = 1;
		gc.gridx = 0;
		JLabel kundenLabel = new JLabel("Kunde");
		paketBean.getContentPanel().add(kundenLabel, gc);
		
		gc.gridx = 4;
		JComboBox kundenCBox = new JComboBox();
		paketBean.getContentPanel().add(kundenCBox, gc);
		
		// Dritte Zeile Kategorie
		gc.gridy = 2;
		gc.gridx = 0;
		JLabel kategorieLabel = new JLabel("Kategorie");
		paketBean.getContentPanel().add(kategorieLabel, gc);
		
		gc.gridx = 4;
		JComboBox kategorieCBox = new JComboBox();
		paketBean.getContentPanel().add(kategorieCBox, gc);
		
		// Vierte Zeile Paketstatus
		gc.gridy = 3;
		gc.gridx = 0;
		JLabel statusLabel = new JLabel("Paketstatus");
		paketBean.getContentPanel().add(statusLabel, gc);
		
		gc.gridx = 4;
		JComboBox statusCBox = new JComboBox();
		paketBean.getContentPanel().add(statusCBox, gc);
		
		// Fuenfte Zeile Lagerort
		gc.gridy = 4;
		gc.gridx = 0;
		JLabel lagerLabel = new JLabel("Lagerort");
		paketBean.getContentPanel().add(lagerLabel, gc);
		
		gc.gridx = 4;
		JComboBox lagerCBox = new JComboBox();
		paketBean.getContentPanel().add(lagerCBox, gc);
	}

}
