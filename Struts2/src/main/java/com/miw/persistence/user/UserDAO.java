package com.miw.persistence.user;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.miw.model.User;
import com.miw.persistence.Dba;

public class UserDAO implements UserDataService {

	protected Logger logger = Logger.getLogger(getClass());

	public void saveUser(User user) {
		// TODO Auto-generated method stub
	}

	public User getUserByUsername(String username) throws Exception {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			User user = em.createQuery("SELECT u FROM User u WHERE u.username = ?", User.class)
					.setParameter(1, username)
					.getSingleResult();
			return user;
		} catch(Exception e) {
			return null;
		} finally {
			dba.closeEm();
		}
	}

	public boolean userExists(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
