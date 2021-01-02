package com.miw.persistence.book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import com.miw.model.Book;
import com.miw.persistence.Dba;

public class BookDAO implements BookDataService {

	protected Logger logger = Logger.getLogger(getClass());

	public List<Book> getBooks() throws Exception {

		List<Book> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			resultList = em.createQuery("Select a From Book a", Book.class).getResultList();

			logger.debug("Result list: " + resultList.toString());
			for (Book next : resultList) {
				logger.debug("next book: " + next);
			}

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return resultList;
	}

	public boolean saveBook(Book book) throws Exception {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			em.createNativeQuery("INSERT INTO BOOK(TITLE,DESCRIPTION,AUTHOR,TAXGROUP,BASEPRICE) VALUES (?,?,?,?,?)", Book.class)
			.setParameter(1, book.getTitle())
			.setParameter(2, book.getDescription())
			.setParameter(3, book.getAuthor())
			.setParameter(4, book.getVat().getTaxGroup())
			.setParameter(5, book.getBasePrice())
			.executeUpdate();
            em.getTransaction().commit();
			logger.debug("Book saved");
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			dba.closeEm();
		}
	}

	public Book getBookById(String book_id) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			Book book = em.createQuery("SELECT b FROM Book b WHERE b.id = ?", Book.class)
					.setParameter(1, Integer.parseInt(book_id))
					.getSingleResult();
			return book;
		} catch(NoResultException e) {
			return null;
		} finally {
			dba.closeEm();
		}
	}
}