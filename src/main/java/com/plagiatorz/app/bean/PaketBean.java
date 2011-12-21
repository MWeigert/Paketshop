package com.plagiatorz.app.bean;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.plagiatorz.db.dto.exception.ValidationException;

public class PaketBean implements BaseBean {

	private JTextField kunde = new JTextField();
	private JComboBox kategorie = new JComboBox();
	private JComboBox status = new JComboBox();
	private JComboBox lager = new JComboBox();
	
	public PaketBean() {
		super();
	}
	
	public PaketBean(JComboBox kategorie, JComboBox status) {
		super();
		this.kategorie = kategorie;
		this.status = status;
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
