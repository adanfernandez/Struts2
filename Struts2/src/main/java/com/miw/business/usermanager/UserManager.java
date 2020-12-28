package com.miw.business.usermanager;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import com.miw.business.UserDataServiceHelper;
import com.miw.model.User;

public class UserManager implements UserManagerService {

	Logger logger = Logger.getLogger(this.getClass());

	public void saveUser(User user) {
		logger.debug("Saving user");
		(new UserDataServiceHelper()).saveUser(user);
	}

	public User getUserByUsername(String username) throws NoResultException {
		logger.debug("Getting user by username");
		return (new UserDataServiceHelper()).getUserByUsername(username);
	}

	public User getUserByCredentials(String username, String password) throws NoResultException {
		logger.debug("Checking if user exists by username and password");
		User user = (new UserDataServiceHelper()).getUserByUsername(username);
		if(user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
