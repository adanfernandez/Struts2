package com.miw.presentation.actions;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.Book;
import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;

public class AddShoppingCartFormAction extends ActionSupport  implements RequestAware {

	private static final long serialVersionUID = 1182040323205334068L;
	Logger logger = Logger.getLogger(this.getClass());
	Map<String,Object> request = null;
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;	
	}
	
	@Override
	public String execute() {
		logger.debug("The add book screen is displayed");
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		try {
			List<Book> books = helper.getBooks();
			request.put("books", books);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}