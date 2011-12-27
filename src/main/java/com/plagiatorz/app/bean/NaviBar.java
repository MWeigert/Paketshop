package com.plagiatorz.app.bean;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

import com.plagiatorz.global.Constants;

/**
 * Teil des BaseBeans
 * Beinhaltet alle relevanten Navigations-Elemente
 * @author MARIUS
 *
 */
public class NaviBar{

	// Different menus
	JMenuBar bar = new JMenuBar();
	private JMenu startMenu = new JMenu("Start");
	private JMenu infoMenu = new JMenu("Info");
	private JRadioButtonMenuItem editUser = new JRadioButtonMenuItem(Constants.EDITUSER);
	private JRadioButtonMenuItem createPaket = new JRadioButtonMenuItem(Constants.ADDPAKET);

	public NaviBar() {
	}

	public JMenuBar getBar() {
		return bar;
	}

	public void setBar(JMenuBar bar) {
		this.bar = bar;
	}

	public JMenu getStartMenu() {
		return startMenu;
	}

	public void setStartMenu(JMenu typeMenu) {
		this.startMenu = typeMenu;
	}

	public JMenu getInfoMenu() {
		return infoMenu;
	}

	public void setInfoMenu(JMenu infoMenu) {
		this.infoMenu = infoMenu;
	}

	public JRadioButtonMenuItem getEditUser() {
		return editUser;
	}

	public void setEditUser(JRadioButtonMenuItem editUser) {
		this.editUser = editUser;
	}

	public JRadioButtonMenuItem getCreatePaket() {
		return createPaket;
	}

	public void setCreatePaket(JRadioButtonMenuItem createPaket) {
		this.createPaket = createPaket;
	}	
	
}
