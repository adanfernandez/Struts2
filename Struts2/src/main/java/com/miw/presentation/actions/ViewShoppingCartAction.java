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
	Map<Book, Double> books;
	Map<String, Object> request = null;

	public String execute() {
		logger.debug("The screen of the view of the sopping cart is displayed");
		books = new HashMap<Book, Double>();
		ShoppingCart cart = (ShoppingCart) session.get("shopping-cart");
		if (cart != null) {
			BookManagerServiceHelper helper = new BookManagerServiceHelper();
			double price = 0;
			for (String id_book : cart.getBooks().keySet()) {
				Book book = helper.getBookById(Integer.parseInt(id_book));
				double numero = cart.getBooks().get(id_book);
				price += book.getPrice()*numero;
				price = Math.round(price * Math.pow(10, 2))/Math.pow(10, 2);
				books.put(book, numero);
			}
			request.put("booksInCart", books);
			request.put("price", price);
		}
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
