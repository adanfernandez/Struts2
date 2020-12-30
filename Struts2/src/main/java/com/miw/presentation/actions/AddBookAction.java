package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.Book;
import com.miw.model.VAT;
import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Results({
		@Result(name = "success", location = "/WEB-INF/content/show-books.jsp"),
		@Result(name = "error", location = "/index.jsp"),
		@Result(name = "input", location = "/WEB-INF/content/add-book-form.jsp")
})

@Validations(requiredStrings = {
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "bookInfo.title", message = "You must enter a value for the title"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "bookInfo.author", message = "You must enter a value for the author"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "bookInfo.description", message = "You must enter a value for the description")
		},
requiredFields = {
		@RequiredFieldValidator(fieldName = "bookInfo.basePrice", message = "You must enter a value for the basePrice"),
		@RequiredFieldValidator(fieldName = "vat.taxGroup", message = "You must enter a value for the taxGroup of VAT")
})


public class AddBookAction extends ActionSupport implements RequestAware {

	Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 2651261795976314789L;
	
	private Book bookInfo = null;
	private VAT vat = null;
	private String prueba = null;
	
	private Map<String, Object> request;

	public String getPrueba() {
		return prueba;
	}
	
	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}
	
	public Book getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(Book bookInfo) {
		this.bookInfo = bookInfo;
	}
	
	public VAT getVat() {
		return vat;
	}
	
	public void setVat(VAT vat) {
		this.vat = vat;
	}

	@Override
	public void validate() {
		logger.debug("Validating the input data to add the book");
		super.validate();
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public String execute() throws Exception {
		logger.debug("Execute RegisterAction");
		bookInfo.setVat(vat);
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		boolean is_saved = helper.saveBook(bookInfo);
		if (is_saved) {
			return SUCCESS;
		}
		logger.debug("Book not saved");
		request.put("bookError", "The Book could not be saved");
		return ERROR;
	}

}
