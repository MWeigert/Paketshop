package com.plagiatorz.global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
