package com.plagiatorz.db.dao.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.plagiatorz.db.dao.exception.DAOConfigurationException;

/**
 * Liest beim Verbindungsaufbau alle benoetigten Daten aus dem "daoProperties"-File,
 * welches sich im Root-Verzeichnis des Projekts befinden muss
 * @author MARIUS
 *
 */
public class DAOProperties {

    private static final String PROPERTIES_FILE = "daoProperties";
    private static final Properties PROPERTIES = new Properties();

    private String specificKey;

    /**
     * Inizialisiert DAOProperties und liest die connection-Variablen in PROPERTIES
     * @throws DAOConfigurationException
     */
    public DAOProperties() throws DAOConfigurationException {
        this.specificKey = "paketshop.jdbc";
        InputStream propertiesFile = null;
		
        try {
			propertiesFile = new FileInputStream(PROPERTIES_FILE);
			PROPERTIES.load(propertiesFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * Liest die Properties aus dem daoProperties-File
     * @param key
     * @param mandatory
     * @return property
     * @throws DAOConfigurationException
     */
    public String getProperty(String key, boolean mandatory) throws DAOConfigurationException {
        String fullKey = specificKey + "." + key;
        String property = PROPERTIES.getProperty(fullKey);

        if (property == null || property.equals("")) {
            property = null;
        }

        return property;
    }

}
