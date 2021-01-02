
package com.miw.business.bookmanager;

import java.util.List;

import org.apache.log4j.Logger;

import com.miw.business.BookDataServiceHelper;
import com.miw.business.VATDataServiceHelper;
import com.miw.model.Book;
import com.miw.model.VAT;

public class BookManager implements BookManagerService {
	Logger logger = Logger.getLogger(this.getClass());

	public List<Book> getBooks() throws Exception {
		logger.debug("Asking for books");
		List<Book> books = (new BookDataServiceHelper()).getBooks();

		// We calculate the final price with the VAT value
		for (Book b : books) {
			b.setPrice(b.getBasePrice() * (1 + b.getVat().getValue()));
		}
		return books;
	}

	public Book getSpecialOffer() throws Exception {
		List<Book> books = getBooks();
		int number = (int) (Math.random() * books.size());
		logger.debug("Applying disccount to " + books.get(number).getTitle());
		books.get(number).setPrice((double) books.get(number).getPrice() * 0.85);
		return books.get(number);
	}

	public boolean saveBook(Book book) throws Exception {
		VAT vat = (new VATDataServiceHelper()).getVATByTaxGroup(book.getVat().getTaxGroup());
		if (vat != null) {
			return (new BookDataServiceHelper()).saveBook(book);
		}
		return false;
	}

	public Book getBookById(int book_id) {
		logger.debug("Asking for book");
		Book book = (new BookDataServiceHelper()).getBookById(book_id);
		book.setPrice(book.getBasePrice() * (1 + book.getVat().getValue()));
		return book;
	}
}
