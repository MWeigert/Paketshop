package com.plagiatorz.app.bean;

import com.plagiatorz.app.exception.ValidationException;

public interface BaseBean {

	public void validate() throws ValidationException;
}
