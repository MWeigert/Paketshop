package com.plagiatorz.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interface für alle DTO's stellt sicher, dass das DTO mit einem ResultSet abgefüllt werden kann
 * @author MARIUS
 *
 */
public interface BaseDTO {

	/**
	 * 
	 * @param result
	 * @throws SQLException
	 */
	public void fillUpRecord(ResultSet result) throws SQLException;

}
