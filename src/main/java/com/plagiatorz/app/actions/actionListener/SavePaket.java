package com.plagiatorz.app.actions.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;

import com.plagiatorz.app.bean.AdressBean;
import com.plagiatorz.app.bean.PaketBean;
import com.plagiatorz.app.exception.ValidationException;
import com.plagiatorz.db.dao.AdressDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.AdressDTO;
import com.plagiatorz.db.dto.PaketDTO;
import com.plagiatorz.global.Constants;
import com.plagiatorz.global.Utils;

/**
 * Speichert die neue Adresse
 * 1. Validierung (Popup mit Fehlerbeschreib, falls fehlgeschlagen)
 * 2. DTO abfuellen
 * 3. Save-Funktion aufrufen
 * @author Plagiatorz
 *
 */
public class SavePaket implements ActionListener {

	private PaketBean paketBean;
	
	public SavePaket(PaketBean paket) {
		super();
		this.paketBean = paket;
	}

	public void setPaket(PaketBean pkt) {
		paketBean = pkt;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			paketBean.validate();
				
			PaketDTO paket = new PaketDTO();
//			paket.setEingangsDatum(paketBean.getEingangsDatum().getText());
//			paket.setKundenId(paketBean.getKunde());
			
		} catch (ValidationException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), "Fehlerhafte eingabe", JOptionPane.ERROR_MESSAGE);
		}
		
		
//		frame.dispose();
	}

}
