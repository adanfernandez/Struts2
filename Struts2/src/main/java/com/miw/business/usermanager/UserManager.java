package com.miw.business.usermanager;

import org.apache.log4j.Logger;

import com.miw.business.UserDataServiceHelper;
import com.miw.model.User;

public class UserManager implements UserManagerService {

	Logger logger = Logger.getLogger(this.getClass());

	public void saveUser(User user) {
		logger.debug("Saving user");
		(new UserDataServiceHelper()).saveUser(user);
	}

	public User getUserByUsername(String username) throws Exception {
		logger.debug("Getting user by login");
		return (new UserDataServiceHelper()).getUserByUsername(username);
	}

	public boolean userExists(String login, String password) {
		logger.debug("Checking if user exists by login and password");
		return (new UserDataServiceHelper()).userExists(login, password);
	}
}
