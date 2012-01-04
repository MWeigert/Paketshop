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
	 * Kontrolliert, ob der Value die im Regex angegebenen Regeln einhält 
	 * @param value
	 * @param regex
	 * @return
	 */
	public static boolean checkRegex(String value, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);
		return m.matches();
	}
	
	public static LoginObject getLoginObject() {

		LoginObject lo = new LoginObject();
		lo.setEmail(System.getProperty(Constants.EMAILPROPERTY));
		lo.setPassword(System.getProperty(Constants.PWPROPERTY));
		
		return lo;
	}
}
