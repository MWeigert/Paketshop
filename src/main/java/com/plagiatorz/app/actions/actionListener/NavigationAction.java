package com.plagiatorz.app.actions.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang.StringUtils;

import com.plagiatorz.app.actions.DisplayPaket;
import com.plagiatorz.app.actions.EditAdress;
import com.plagiatorz.app.bean.BaseBean;
import com.plagiatorz.app.gui.LoginGUI;
import com.plagiatorz.global.Constants;

public class NavigationAction implements ActionListener {

	private BaseBean bean;
	
	public NavigationAction(BaseBean baseBean) {
		bean = baseBean;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if(StringUtils.equals(Constants.LOGIN,event.getActionCommand())) {
			LoginGUI gui = new LoginGUI(bean.getFrame(), bean.getContentPanel());
			gui.displayContentPanel();
		}
		else if(StringUtils.equals(Constants.EDITUSER,event.getActionCommand())) {
			EditAdress action = new EditAdress(bean.getFrame(), bean.getContentPanel());
			action.execute();
		} else if (StringUtils.equals(Constants.ADDPAKET, event.getActionCommand())) {
			DisplayPaket action = new DisplayPaket(bean.getFrame(), bean.getContentPanel());
			action.execute();
		}

	}

}
