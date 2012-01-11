package com.plagiatorz.db.dao.exception;

/**
 * Alle moeglichen uebergabemasken eines DB-Fehlers (z.B. nicht berechtigt)
 * @author MARIUS
 *
 */
public class DAOException extends Exception {

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