package com.plagiatorz.login;

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
