package com.plagiatorz.db.dao.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public final class DaoUtil {

    public static PreparedStatement prepareStatement
    (Connection connection, String sql, boolean returnGeneratedKeys, Object... values)
        throws SQLException
	{
	    PreparedStatement preparedStatement = connection.prepareStatement(sql,
	        returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
	    setValues(preparedStatement, values);
	    return preparedStatement;
	}
	    public static void setValues(PreparedStatement preparedStatement, Object... values)
	    throws SQLException
	{
	    for (int i = 0; i < values.length; i++) {
	        preparedStatement.setObject(i + 1, values[i]);
	    }
	}
	
	public static void close(Connection connection) {
	    if (connection != null) {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            System.err.println("Closing Connection failed: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}
}