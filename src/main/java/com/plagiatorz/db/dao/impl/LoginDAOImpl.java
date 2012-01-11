package com.plagiatorz.db.dao.impl;

import com.plagiatorz.db.dao.LoginDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.login.LoginObject;

/**
 * Fuehrt ein select 1 from dual aus, um ein Login durchzufuehren
 * @author MARIUS
 *
 */
public class LoginDAOImpl extends BaseDAOImpl implements LoginDAO{
	
	private static final String DUMMYSELECT = "SELECT 1 FROM dual";
	
	public LoginDAOImpl(DAOFactory daoFactory) {
		super(daoFactory);
	}


	@Override
	public void login(LoginObject lo) throws DAOException {

		super.executeSelect(lo, DUMMYSELECT, new Object[]{});
		
	}

}
