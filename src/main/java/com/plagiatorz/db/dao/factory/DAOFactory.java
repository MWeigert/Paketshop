package com.plagiatorz.db.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.PaketDAO;
import com.plagiatorz.db.dao.exception.DAOConfigurationException;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.impl.AdressDAOImpl;
import com.plagiatorz.db.dao.impl.PaketDAOImpl;
import com.plagiatorz.db.dao.utility.DAOProperties;

public abstract class DAOFactory {

    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * Liest die Parameter aus dem daoProperties File und gibt eine DAOFactory zurück
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {

        DAOProperties properties = new DAOProperties();
        String url = properties.getProperty(PROPERTY_URL, true);
        String driverClassName = properties.getProperty(PROPERTY_DRIVER, false);
        String password = properties.getProperty(PROPERTY_PASSWORD, false);
        String username = properties.getProperty(PROPERTY_USERNAME, password != null);
        DAOFactory instance;

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new DAOConfigurationException("Classpath nicht gefunden", e);
        }
        instance = new DriverManagerDAOFactory(url, username, password);

        return instance;
    }

    /**
     * @return Eine connection zur Datenbank.
     * @throws SQLException Falls connection fail.
     * @throws Exception 
     */
    public abstract Connection getConnection() throws DAOException;

    public AdressDAO getAdressDAO() {
        return new AdressDAOImpl(this);
    }
    
    public PaketDAO getPaketDAO() {
        return new PaketDAOImpl(this);
    }

}
