package com.miw.presentation.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class ViewShoppingCartAction extends ActionSupport {

	private static final long serialVersionUID = 1182040323205334068L;
	Logger logger = Logger.getLogger(this.getClass());
	
	public String execute() {
		logger.debug("The screen of the view of the sopping cart is displayed");
		return SUCCESS;
	}
}
