package com.plagiatorz.app.actions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.lang.StringUtils;

import com.plagiatorz.app.bean.PaketBean;
import com.plagiatorz.app.gui.PaketGUI;
import com.plagiatorz.db.dao.ReferenzDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.global.Constants;
import com.plagiatorz.global.Utils;
import com.plagiatorz.login.LoginObject;

public class DisplayPaket {

	private PaketBean bean;
	
	
	
	public DisplayPaket(JFrame frame, JPanel panel) {
		super();
		bean = new PaketBean(frame, panel);
	}



	public void execute() {
		

		DAOFactory factory = DAOFactory.getInstance();
		ReferenzDAO dao = factory.getReferenzDAO();
		
		LoginObject lo = Utils.getLoginObject();

		try {
			dao.getAllLager(lo);
			dao.getAllMahnStatus(lo);
			dao.getAllPaketKategorien(lo);
			dao.getAllPaketStatus(lo);
			
		} catch (DAOException e) {

			if(StringUtils.equals(Constants.LOGINERROR, e.getMessage())) {
				JOptionPane.showMessageDialog(null, Constants.LOGINERROR, "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				e.printStackTrace();
			}
		}
		
		PaketGUI paket = new PaketGUI(bean);
		paket.displayContentPanel();
	}
}
