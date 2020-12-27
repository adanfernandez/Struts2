package com.miw.presentation.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterFormAction extends ActionSupport {

	private static final long serialVersionUID = 1182040323205334068L;
	Logger logger = Logger.getLogger(this.getClass());
	
	public String execute() {
		logger.debug("The registration screen is displayed");
		return SUCCESS;
	}
}
