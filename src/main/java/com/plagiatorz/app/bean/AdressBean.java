package com.plagiatorz.app.bean;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import com.plagiatorz.app.exception.ValidationException;
import com.plagiatorz.global.Utils;

public class AdressBean implements BaseBean {

	private JTextField name = new JTextField();
	private JTextField vorname = new JTextField();
	private JTextField strasse = new JTextField();
	private JTextField strassenNr = new JTextField();
	private JTextField zusatzzeile = new JTextField();
	private JTextField land = new JTextField();
	private JTextField plz = new JTextField();
	private JTextField ort = new JTextField();
	private JTextField mobile = new JTextField();
	private JTextField telefon = new JTextField();
	private JTextField email = new JTextField();
	private JPasswordField passwort = new JPasswordField();

	
	
	public AdressBean() {
		super();
	}

	public JTextField getName() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getVorname() {
		return vorname;
	}

	public void setVorname(JTextField vorname) {
		this.vorname = vorname;
	}

	public JTextField getStrasse() {
		return strasse;
	}

	public void setStrasse(JTextField strasse) {
		this.strasse = strasse;
	}

	public JTextField getStrassenNr() {
		return strassenNr;
	}

	public void setStrassenNr(JTextField strassenNr) {
		this.strassenNr = strassenNr;
	}

	public JTextField getZusatzzeile() {
		return zusatzzeile;
	}

	public void setZusatzzeile(JTextField zusatzzeile) {
		this.zusatzzeile = zusatzzeile;
	}

	public JTextField getLand() {
		return land;
	}

	public void setLand(JTextField land) {
		this.land = land;
	}

	public JTextField getPlz() {
		return plz;
	}

	public void setPlz(JTextField plz) {
		this.plz = plz;
	}

	public JTextField getOrt() {
		return ort;
	}

	public void setOrt(JTextField ort) {
		this.ort = ort;
	}

	public JTextField getMobile() {
		return mobile;
	}

	public void setMobile(JTextField mobile) {
		this.mobile = mobile;
	}

	public JTextField getTelefon() {
		return telefon;
	}

	public void setTelefon(JTextField telefon) {
		this.telefon = telefon;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JPasswordField getPasswort() {
		return passwort;
	}

	public void setPasswort(JPasswordField passwort) {
		this.passwort = passwort;
	}

	@Override
	public void validate() throws ValidationException {

		if(StringUtils.isEmpty(name.getText())){
			throw new ValidationException("Name leer");
		}
		else if(StringUtils.isEmpty(vorname.getText())){
			throw new ValidationException("Vorname leer");
		}
		else if(StringUtils.isEmpty(strasse.getText())){
			throw new ValidationException("Strasse leer");
		}
		else if(StringUtils.isEmpty(strassenNr.getText())){
			throw new ValidationException("Strassen Nummer leer");
		}
		else if(StringUtils.isEmpty(plz.getText())){
			throw new ValidationException("PLZ leer");
		}
		else if(StringUtils.isEmpty(ort.getText())){
			throw new ValidationException("Ort leer");
		}
		else if(StringUtils.isEmpty(land.getText())){
			throw new ValidationException("Land leer");
		}
		else if(StringUtils.isEmpty(email.getText())){
			throw new ValidationException("Emailadresse leer");
		}
		else if(!Utils.checkRegex(email.getText(), "[\\.\\w\\_\\-]+[\\w]+@[\\.\\w\\_\\-]+\\.\\w{2,4}$")) {
			throw new ValidationException("Ungültige Emailadresse");
		}
	}

}
