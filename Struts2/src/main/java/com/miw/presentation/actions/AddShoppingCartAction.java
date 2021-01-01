package com.miw.presentation.actions;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddShoppingCartAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = -2943503925810275673L;


	Logger logger = Logger.getLogger(this.getClass());
	
	
	private Map<String, Object> request;
	private Map<String, Object> session = null;	
	private List<String> addBooks;
	private Map<String, Object> application = null;


	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public List<String> getAddBooks() {
		return addBooks;
	}

	public void setAddedBooks(List<String> addBooks) {
		this.addBooks = addBooks;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	

}
