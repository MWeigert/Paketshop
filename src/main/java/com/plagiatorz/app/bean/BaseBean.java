package com.plagiatorz.app.bean;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.plagiatorz.app.exception.ValidationException;

/**
 * baseKlasse zur sicherstellung, dass jedes Bean eine Validate-Methode besitzt
 * beim Init wird der contentPanel im frame geloescht
 * beinhaltet das frame und den contentPanle
 * @author MARIUS
 *
 */
public abstract class BaseBean {

	private JFrame frame = new JFrame();
	private JPanel contentPanel = new JPanel();
	private NaviBar menuBar = new NaviBar();

	/**
	 * contentpanel wird aus dem Frame geloescht, damit das neue GUI dieses benutzen kann
	 * @param frame
	 * @param contentPanel
	 */
	public BaseBean(JFrame frame, JPanel contentPanel) {
		super();
		this.frame = frame;
		this.contentPanel = contentPanel;
		this.frame.remove(this.contentPanel);
	}

	/**
	 * Bei Validierung beachten:
	 * 1. Format richtig
	 * 2. Mandatory-Felder abgefuellt
	 * 3. Feld-Laenge beachten
	 * @throws ValidationException
	 */
	public abstract void validate() throws ValidationException;


	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JPanel getContentPanel() {
		return contentPanel;
	}
	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
	}
	
	public NaviBar getMenuBar() {
		return menuBar;
	}

	/**
	 * Defaultanzeige, contentPanel wird dem Frame hinzugefuegt und angezeigt
	 */
	public void setFrameVisible(){
		frame.add(contentPanel);
//		frame.setSize(300, 400);
		frame.setPreferredSize(new Dimension(300,400));
		frame.pack();
		frame.setVisible(true);
	}
	
	
}
