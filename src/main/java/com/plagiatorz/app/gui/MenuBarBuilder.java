package com.plagiatorz.app.gui;

import com.plagiatorz.app.actions.actionListener.NavigationAction;
import com.plagiatorz.app.bean.BaseBean;

/**
 * Muss bei jedem neuen GUI als erstes aufgerufen werden
 * Stellt die Navigation wie gewuenscht dar
 * @author MARIUS
 *
 */
public final class MenuBarBuilder {

	/**
	 * Generiert den Navibar fuer den MenuBar
	 * @param bean
	 */
	public static void buildMenubar(BaseBean bean) {
		
		NavigationAction action = new NavigationAction(bean);

		bean.getMenuBar().getStartMenu().setMnemonic('T');
		bean.getMenuBar().getInfoMenu().setMnemonic('I');

		bean.getMenuBar().getStartMenu().add(bean.getMenuBar().getLogin());
		bean.getMenuBar().getStartMenu().add(bean.getMenuBar().getEditUser());
		bean.getMenuBar().getStartMenu().add(bean.getMenuBar().getCreatePaket());

		bean.getMenuBar().getBar().add(bean.getMenuBar().getStartMenu());
		bean.getMenuBar().getBar().add(bean.getMenuBar().getInfoMenu());

		bean.getMenuBar().getLogin().addActionListener(action);
		bean.getMenuBar().getCreatePaket().addActionListener(action);
		bean.getMenuBar().getEditUser().addActionListener(action);
		
		bean.getFrame().setJMenuBar(bean.getMenuBar().getBar());
	}
}
