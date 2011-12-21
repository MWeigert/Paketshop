package com.plagiatorz.login;

/**
 * Wird beim ersten Login-Check abgefüllt
 * Gibt weitere Informationen über die Berechtigungen des Users
 * Keine Setter, da das Object nur beim Initialisieren abgefüllt werden darf
 * @author MARIUS
 *
 */
public final class LoginEnrichedData {

	private final int id;
	private final int adressTyp;
	public LoginEnrichedData(int id, int adressTyp) {
		super();
		this.id = id;
		this.adressTyp = adressTyp;
	}
	
	public int getId() {
		return id;
	}
	public int getAdressTyp() {
		return adressTyp;
	}
	
	
}
