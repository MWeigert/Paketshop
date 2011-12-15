package com.plagiatorz.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseDTO {

	public void fillUpRecord(ResultSet result) throws SQLException;

}
