package com.miw.persistence.book;

import java.util.List;

import com.miw.model.Book;

public interface BookDataService {

	List<Book> getBooks() throws Exception;
	boolean saveBook(Book book) throws Exception;
	Book getBookById(int book_id);
}