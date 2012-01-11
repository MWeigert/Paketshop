package com.plagiatorz.app.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.plagiatorz.app.bean.PaketBean;

/**
 * @author M. Weigert
 *
 */
public class CreateParcelGUI implements BaseGUIInterface {

	private PaketBean paketBean;

	/**
	 * 
	 */
	public CreateParcelGUI(JFrame jFrame, JPanel jPanel) {
		super();
		paketBean = new PaketBean(jFrame, jPanel);
	}

	/* (non-Javadoc)
	 * @see com.plagiatorz.app.gui.BaseGUIInterface#displayContentPanel()
	 */
	@Override
	public void displayContentPanel() {
		// TODO Auto-generated method stub

	}

}
