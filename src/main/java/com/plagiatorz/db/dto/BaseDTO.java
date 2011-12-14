package com.plagiatorz.db.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.plagiatorz.db.dao.exception.ValidationException;

public interface BaseDTO {

	public void fillUpRecord(ResultSet result) throws SQLException;

	public void validate() throws ValidationException;
}
