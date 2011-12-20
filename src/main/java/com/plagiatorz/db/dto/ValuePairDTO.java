package com.plagiatorz.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Benutzt für Referenz-Daten (Schlüssel, Anzeige-Value übergabe)
 * @author MARIUS
 *
 */
public class ValuePairDTO implements BaseDTO {

	private String key;
	private String value;
	
	
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public void fillUpRecord(ResultSet result) throws SQLException {
		key = result.getString(1);
		value = result.getString(2);

	}

}
