package com.miw.persistence.user;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import com.miw.model.User;
import com.miw.persistence.Dba;

public class UserDAO implements UserDataService {

	protected Logger logger = Logger.getLogger(getClass());

	public boolean saveUser(User user) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.persist(user);
			em.getTransaction().commit();
			logger.debug("User saved");
			return true;
		} catch(Exception e) {
			return false;
		} finally {
			dba.closeEm();
		}
	}

	public User getUserByUsername(String username) throws NoResultException {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			User user = em.createQuery("SELECT u FROM User u WHERE u.username = ?", User.class)
					.setParameter(1, username)
					.getSingleResult();
			return user;
		} catch(NoResultException e) {
			return null;
		} finally {
			dba.closeEm();
		}
	}
	
	public User getUserByUsernameAndPassword(String username, String password) throws NoResultException {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			User user = em.createQuery("SELECT u FROM User u WHERE u.username = ? AND u.password = ?", User.class)
					.setParameter(1, username)
					.setParameter(2, password)
					.getSingleResult();
			return user;
		} catch(Exception e) {
			return null;
		} finally {
			dba.closeEm();
		}
	}
}
