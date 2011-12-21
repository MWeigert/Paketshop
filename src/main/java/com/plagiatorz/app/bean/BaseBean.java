package com.plagiatorz.app.bean;

import com.plagiatorz.db.dto.exception.ValidationException;

public interface BaseBean {

	public void validate() throws ValidationException;
}
