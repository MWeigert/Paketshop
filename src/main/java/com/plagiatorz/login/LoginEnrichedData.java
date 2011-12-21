package com.plagiatorz.login;

/**
 * Wird beim ersten Login-Check abgef�llt
 * Gibt weitere Informationen �ber die Berechtigungen des Users
 * Keine Setter, da das Object nur beim Initialisieren abgef�llt werden darf
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
