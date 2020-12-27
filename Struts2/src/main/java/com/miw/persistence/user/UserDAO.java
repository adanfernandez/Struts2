package com.miw.persistence.user;

import org.apache.log4j.Logger;

import com.miw.model.User;

public class UserDAO implements UserDataService {

	protected Logger logger = Logger.getLogger(getClass());

	public void saveUser(User user) {
		// TODO Auto-generated method stub
	}

	public User getUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean userExists(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
