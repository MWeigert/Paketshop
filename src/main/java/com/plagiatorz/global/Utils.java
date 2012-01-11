package com.plagiatorz.global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.plagiatorz.login.LoginObject;

/**
 * Helperklasse, liest unter anderem die Daten, mit der der User sich eingeloggt hat, aus dem System
 * @author MARIUS
 */
public final class Utils {
	/**
	 * Kontrolliert, ob der Value die im Regex angegebenen Regeln einhaelt 
	 * @param value
	 * @param regex
	 * @return ergebnis true, falls regex erfuellt, sonst false
	 */
	public static boolean checkRegex(String value, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);
		return m.matches();
	}
	
	/**
	 * holt die login-Informationen aus den System-Properties und fuellt sie in ein LoginObject ab
	 * @return lo
	 */
	public static LoginObject getLoginObject() {

		LoginObject lo = new LoginObject();
		lo.setEmail(System.getProperty(Constants.EMAILPROPERTY));
		lo.setPassword(System.getProperty(Constants.PWPROPERTY));
		
		return lo;
	}
}
