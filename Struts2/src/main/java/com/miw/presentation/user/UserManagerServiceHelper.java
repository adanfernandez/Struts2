package com.miw.presentation.user;

import org.apache.log4j.Logger;

import com.miw.infrastructure.Factories;
import com.miw.model.User;

public class UserManagerServiceHelper {
	Logger logger = Logger.getLogger(this.getClass());
	
	public void saveUser(User user) {
		(Factories.services.getUserManagerService()).saveUser(user);
	}
	
	public User getUserByUsername(String username) throws Exception {
		return (Factories.services.getUserManagerService()).getUserByUsername(username);
	}
	
	public User getUserByCredentials(String login, String password) throws Exception {
		return (Factories.services.getUserManagerService()).getUserByCredentials(login, password);
	}
}
