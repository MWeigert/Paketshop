package com.plagiatorz.app.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.plagiatorz.app.bean.PaketBean;

/**
 * @author M. Weigert
 *
 */
public class PaketGUI implements BaseGUIInterface {

	private PaketBean paketBean;

	/**
	 * 
	 */
	public PaketGUI(JFrame jFrame, JPanel jPanel) {
		super();
		paketBean = new PaketBean(jFrame, jPanel);
	}

	/* (non-Javadoc)
	 * @see com.plagiatorz.app.gui.BaseGUIInterface#displayContentPanel()
	 */
	@Override
	public void displayContentPanel() {
		paketBean.setContentPanel(new JPanel(new GridBagLayout()));
		paketBean.getContentPanel().setBorder(new EmptyBorder(3, 3, 3, 3));

		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 20;
		gc.weighty = 18;
		gc.gridy = 0;
		gc.gridx = 0;
		gc.gridheight = 1;
		gc.gridwidth = 10;
		
		// Erste Zeile mit Paket-ID und Datum
		

	}

}
