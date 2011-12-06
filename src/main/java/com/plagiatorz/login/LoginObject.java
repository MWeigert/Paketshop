package com.plagiatorz.login;

public class LoginObject {

	private LoginEnrichedData enrichedLoginData;
	
	private String email;
	private String password;

	public LoginEnrichedData getEnrichedLoginData() {
		return enrichedLoginData;
	}
	public void setEnrichedLoginData(LoginEnrichedData enrichedLoginData) {
		this.enrichedLoginData = enrichedLoginData;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String userName) {
		this.email = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
