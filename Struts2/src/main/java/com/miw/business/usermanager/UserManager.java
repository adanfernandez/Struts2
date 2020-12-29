package com.miw.business.usermanager;

import org.apache.log4j.Logger;

import com.miw.business.UserDataServiceHelper;
import com.miw.model.User;

public class UserManager implements UserManagerService {

	Logger logger = Logger.getLogger(this.getClass());

	public boolean registerUser(User user) {
		logger.debug("Saving user");
		User user_by_username = (new UserDataServiceHelper()).getUserByUsername(user.getUsername());
		if(user_by_username == null) {
			(new UserDataServiceHelper()).saveUser(user);
			return true;
		}
		return false;
	}


	public User getUserByUsernameAndPassword(String username, String password) {
		logger.debug("Checking if user exists by username and password");
		return (new UserDataServiceHelper()).getUserByUsernameAndPassword(username, password);
	}
}
