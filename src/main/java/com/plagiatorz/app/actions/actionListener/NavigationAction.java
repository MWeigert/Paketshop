package com.plagiatorz.app.actions.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang.StringUtils;

import com.plagiatorz.app.actions.EditAdress;
import com.plagiatorz.app.bean.BaseBean;
import com.plagiatorz.global.Constants;

public class NavigationAction implements ActionListener {

	private BaseBean bean;
	
	public NavigationAction(BaseBean baseBean) {
		bean = baseBean;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if(StringUtils.equals(Constants.EDITUSER,event.getActionCommand())) {
			EditAdress action = new EditAdress(bean.getFrame(), bean.getContentPanel());
			action.execute();
		}

	}

}