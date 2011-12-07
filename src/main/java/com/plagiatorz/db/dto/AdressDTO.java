package com.plagiatorz.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdressDTO implements BaseDTO{

	private int id;
	private String name;
	private String vorname;
	private String strasse;
	private String strassenNr;
	private String zusatzteile;
	private String land;
	private String plz;
	private String ort;
	private String mobile;
	private String telefon;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getStrassenNr() {
		return strassenNr;
	}
	public void setStrassenNr(String strassenNr) {
		this.strassenNr = strassenNr;
	}
	public String getZusatzteile() {
		return zusatzteile;
	}
	public void setZusatzteile(String zusatzteile) {
		this.zusatzteile = zusatzteile;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public void fillUpRecord(ResultSet result) throws SQLException {
		//TODO alle abfüllen
		id = result.getInt(1);
	}
	
}
