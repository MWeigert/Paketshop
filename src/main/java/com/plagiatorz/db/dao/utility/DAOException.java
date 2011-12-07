package com.plagiatorz.db.dao.utility;

public class DAOException extends Exception {

    // Constructors -------------------------------------------------------------------------------

    /**
     * @param message Fehlerbeschreibung
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * @param cause Grund der Fehlermeldung
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message Fehlerbeschreibung
     * @param cause Grund der Fehlermeldung
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}