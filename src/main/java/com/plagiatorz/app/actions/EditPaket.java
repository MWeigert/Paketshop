/**
 * 
 */
package com.plagiatorz.app.actions;

import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.plagiatorz.app.bean.PaketBean;
import com.plagiatorz.app.gui.ClientGUI;
//import com.plagiatorz.db.dao.AdressDAO;
//import com.plagiatorz.db.dao.exception.DAOException;
//import com.plagiatorz.db.dao.factory.DAOFactory;
//import com.plagiatorz.db.dto.AdressDTO;
//import com.plagiatorz.db.dto.PaketDTO;
//import com.plagiatorz.global.Utils;
//import com.plagiatorz.login.LoginObject;

/**
 * @author M. Weigert
 *
 */
public class EditPaket {

	private PaketBean paketBean;
	
	public EditPaket(JFrame frame, JPanel contentPanel) {
		super();
		paketBean = new PaketBean(frame, contentPanel);
	}

	public void execute() {

//		DAOFactory factory = DAOFactory.getInstance();
//		AdressDAO dao = factory.getAdressDAO();
		
//		try {
//			LoginObject lo = Utils.getLoginObject();
//			PaketDTO dto = dao.getAdressByEmail(lo, lo.getEmail());
//			adressBean.setId(dto.getId());
//			adressBean.getName().setText(dto.getName());
//			adressBean.getVorname().setText(dto.getVorname());
//			adressBean.getStrasse().setText(dto.getStrasse());
//			adressBean.getStrassenNr().setText(dto.getStrassenNr());
//			adressBean.getLand().setText(dto.getLand());
//			adressBean.getPlz().setText(dto.getPlz());
//			adressBean.getOrt().setText(dto.getOrt());
//			adressBean.getMobile().setText(dto.getMobile());
//			adressBean.getTelefon().setText(dto.getTelefon());
//			adressBean.getEmail().setText(dto.getEmail());
//			adressBean.getPasswort().setText(dto.getPasswort());
			
//			ClientGUI gui = new ClientGUI(paketBean);
//			gui.displayContentPanel();
//		} catch (DAOException ex) {
//			JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
//		}
	}
}
