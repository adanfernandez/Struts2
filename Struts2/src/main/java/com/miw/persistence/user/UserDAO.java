package com.miw.persistence.user;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import com.miw.model.User;
import com.miw.persistence.Dba;

public class UserDAO implements UserDataService {

	protected Logger logger = Logger.getLogger(getClass());

	public void saveUser(User user) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.persist(user);
			em.getTransaction().commit();
			logger.debug("User saved");
		} catch(Exception e) {
			
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
}
