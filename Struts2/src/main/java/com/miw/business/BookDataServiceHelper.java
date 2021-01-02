package com.miw.business;

import java.util.List;

import com.miw.infrastructure.Factories;
import com.miw.model.Book;

public class BookDataServiceHelper {

	public List<Book> getBooks() throws Exception {
		return (Factories.dataServices.getBookDataService()).getBooks();
	}
	
	public boolean saveBook(Book book) throws Exception {
		return (Factories.dataServices.getBookDataService()).saveBook(book);
	}
	

	public Book getBookById(int book_id) {
		return (Factories.dataServices.getBookDataService()).getBookById(book_id);
	}
}
