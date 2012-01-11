package com.plagiatorz.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 
 * @author MARIUS
 *
 */
public class PaketDTO implements BaseDTO{

	private int kundenId;
	private int kategorie;
	private int status;
	private String buHaStatus;
	private int mahnStatus;
	private Date eingangsDatum;
	private int lagerOrt;

	public int getKundenId() {
		return kundenId;
	}

	public void setKundenId(int kundenId) {
		this.kundenId = kundenId;
	}

	public int getKategorie() {
		return kategorie;
	}

	public void setKategorie(int kategorie) {
		this.kategorie = kategorie;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBuHaStatus() {
		return buHaStatus;
	}

	public void setBuHaStatus(String buHaStatus) {
		this.buHaStatus = buHaStatus;
	}

	public int getMahnStatus() {
		return mahnStatus;
	}

	public void setMahnStatus(int mahnStatus) {
		this.mahnStatus = mahnStatus;
	}

	public Date getEingangsDatum() {
		return eingangsDatum;
	}

	public void setEingangsDatum(Date eingangsDatum) {
		this.eingangsDatum = eingangsDatum;
	}

	public int getLagerOrt() {
		return lagerOrt;
	}

	public void setLagerOrt(int lagerOrt) {
		this.lagerOrt = lagerOrt;
	}

	@Override
	public void fillUpRecord(ResultSet result) throws SQLException {
		// FIXME fuer get abfuellen
		
	}

}

