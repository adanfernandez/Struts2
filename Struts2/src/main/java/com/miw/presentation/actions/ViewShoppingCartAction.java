package com.miw.presentation.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.miw.model.Book;
import com.miw.model.ShoppingCart;
import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;

public class ViewShoppingCartAction extends ActionSupport implements SessionAware, RequestAware {

	private static final long serialVersionUID = 1182040323205334068L;
	Logger logger = Logger.getLogger(this.getClass());
	private Map<String, Object> session = null;
	Map<Book, Integer> books;
	Map<String,Object> request = null;

	public String execute() {
		logger.debug("The screen of the view of the sopping cart is displayed");
		books = new HashMap<Book, Integer>();
		ShoppingCart cart = (ShoppingCart)session.get("shopping-cart");
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		for(String id_book : cart.getBooks().keySet()) {
			Book book = helper.getBookById(id_book);
			int numero = cart.getBooks().get(id_book);
			books.put(book, numero);
		}
		request.put("booksInCart", books);
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
