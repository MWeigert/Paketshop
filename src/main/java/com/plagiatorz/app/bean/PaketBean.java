package com.plagiatorz.app.bean;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.plagiatorz.app.exception.ValidationException;

public class PaketBean extends BaseBean {

	private JTextField paketID = new JTextField();
	private JTextField eingangsDatum = new JTextField();
	private JTextField kunde = new JTextField();
	private JComboBox kategorie = new JComboBox();
	private JComboBox status = new JComboBox();
	private JComboBox lager = new JComboBox();
	
	public PaketBean(JFrame frame, JPanel contentPanel) {
		super(frame, contentPanel);
	}
	
	public PaketBean(JFrame frame, JPanel contentPanel, JComboBox kategorie, JComboBox status) {
		super(frame, contentPanel);
		this.kategorie = kategorie;
		this.status = status;
	}

	public JTextField getPaketID() {
		return paketID;
	}
	
	public void setPaketID(JTextField paketID) {
		this.paketID = paketID;
	}
	
	public JTextField getEingangsDatum() {
		return eingangsDatum;
	}
	
	public void setEingangsDatum(JTextField eingangsDatum) {
		this.eingangsDatum = eingangsDatum;
	}
	
	public JTextField getKunde() {
		return kunde;
	}


	public void setKunde(JTextField kunde) {
		this.kunde = kunde;
	}


	public JComboBox getKategorie() {
		return kategorie;
	}


	public void setKategorie(JComboBox kategorie) {
		this.kategorie = kategorie;
	}


	public JComboBox getStatus() {
		return status;
	}


	public void setStatus(JComboBox status) {
		this.status = status;
	}
	
	public JComboBox getLager() {
		return lager;
	}

	public void setLager(JComboBox lager) {
		this.lager = lager;
	}

	@Override
	public void validate() throws ValidationException {
		// TODO Auto-generated method stub
		
	}
	
}
