package com.plagiatorz.db.dao.utility;

public class DAOConfigurationException extends RuntimeException {

    // Constructors -------------------------------------------------------------------------------

    /**
     * @param message Fehlerbeschreibung
     */
    public DAOConfigurationException(String message) {
        super(message);
    }

    /**
     * @param cause Grund der Fehlermeldung
     */
    public DAOConfigurationException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message Fehlerbeschreibung
     * @param cause Grund der Fehlermeldung
     */
    public DAOConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

}
