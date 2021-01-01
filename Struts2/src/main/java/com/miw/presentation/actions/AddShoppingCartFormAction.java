package com.miw.presentation.actions;

import java.util.List;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.Book;
import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;


public class AddShoppingCartFormAction extends ActionSupport  implements RequestAware, ApplicationAware {

	private static final long serialVersionUID = 1182040323205334068L;
	Logger logger = Logger.getLogger(this.getClass());
	Map<String,Object> request = null;
	private Map<String, Object> application = null;
	
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;	
	}
	
	@Override
	public String execute() {
		logger.debug("The add book screen is displayed");
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		try {
			List<Book> books = helper.getBooks();
			application.put("books", books);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}