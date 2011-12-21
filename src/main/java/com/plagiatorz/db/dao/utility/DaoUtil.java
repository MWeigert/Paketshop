package com.plagiatorz.db.dao.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Utility Klasse für DB-Calls
 * @author MARIUS
 *
 */
public final class DaoUtil {

	/**
	 * Vervollständigt den DB-Call
	 * @param connection
	 * @param sql
	 * @param returnGeneratedKeys
	 * @param values
	 * @return
	 * @throws SQLException
	 */
    public static PreparedStatement prepareStatement
    (Connection connection, String sql, boolean returnGeneratedKeys, Object... values)
        throws SQLException
	{
	    PreparedStatement preparedStatement = connection.prepareStatement(sql,
	        returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
	    setValues(preparedStatement, values);
	    return preparedStatement;
	}
	    
    /**
     * Füllt alle Values der REIHE nach in die Query
     * @param preparedStatement
     * @param values
     * @throws SQLException
     */
    public static void setValues(PreparedStatement preparedStatement, Object... values)
	    throws SQLException
	{
	    for (int i = 0; i < values.length; i++) {
	        preparedStatement.setObject(i + 1, DaoUtil.fillUpValue(values[i]));
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
	
	/**
	 * gibt den Wert DB-Spezifisch zurück
	 *  1. String: '<value>'
	 *  2. Date-Bsp: STR_TO_DATE('10.10.2011', (%d.%m.%Y')
	 *  3. Rest unverändert
	 * @param value
	 * @return
	 */
	public static Object fillUpValue(Object value) {
		
		if(value == null) {
			return "null";
		}
		else if(value instanceof String) {
			return "'"+value+"'";
		}
		else if(value instanceof Date) {
			Date d = (Date) value;
			Calendar cal = new GregorianCalendar();
			cal.setTime(d);
			
			return "STR_TO_DATE('"+cal.get(Calendar.DAY_OF_MONTH)+"."+cal.get(Calendar.MONTH)+"."+cal.get(Calendar.YEAR)+"', '%d.%m.%Y')";
		}
		return value;
	}
}