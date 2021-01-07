package com.miw.presentation.actions;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.miw.model.ShoppingCart;
import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "success", location = "/WEB-INF/content/add-shopping-cart-form.jsp"),
		// For validation
		@Result(name = "no-book-selected", location = "/WEB-INF/content/add-shopping-cart-form.jsp") })


public class AddShoppingCartAction extends ActionSupport implements RequestAware, SessionAware {

	private static final long serialVersionUID = -2943503925810275673L;

	Logger logger = Logger.getLogger(this.getClass());

	private Map<String, Object> request;
	private Map<String, Object> session = null;
	private List<String> addBooks;

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public List<String> getAddBooks() {
		return addBooks;
	}

	public void setAddBooks(List<String> addBooks) {
		this.addBooks = addBooks;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	@Override
	public String execute() throws Exception {
		if(addBooks.size() == 0) {
			request.put("noBookSelected", "You have to select at least one book");
			return "no-book-selected";
		}
		ShoppingCart cart = (ShoppingCart) session.get("shopping-cart");
		if(cart == null) {
			cart = new ShoppingCart();
			session.put("shopping-cart", cart);
		}
		for(String book_id : this.addBooks) {
			if(book_id != null) {
				logger.debug("Book has been added to the cart");
				add_book(cart, book_id);
				logger.debug("Cart state: " + cart);
			}
		}
		request.put("bookIntoCart", "The book has been added to the shopping cart");
		return SUCCESS;
	}
	
	private void add_book(ShoppingCart cart, String id) {
		Integer numero = cart.getBooks().get(id);
		if (numero == null) {
			cart.getBooks().put(id, 1);
		} else { 
			cart.getBooks().put(id, ++numero);
		}
	}

}
