package com.plagiatorz.app.exception;

/**
 * Alle möglichen Übergabemasken eines Validierungs-Fehlers (z.B. Pflichtfeld ist leer)
 * @author MARIUS
 *
 */
public class ValidationException extends Exception {

    /**
     * @param message Fehlerbeschreibung
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * @param cause Grund der Fehlermeldung
     */
    public ValidationException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message Fehlerbeschreibung
     * @param cause Grund der Fehlermeldung
     */
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}