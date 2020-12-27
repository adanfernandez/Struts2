package com.miw.presentation.user;

import org.apache.log4j.Logger;

import com.miw.infrastructure.Factories;
import com.miw.model.User;

public class UserManagerServiceHelper {
	Logger logger = Logger.getLogger(this.getClass());
	
	public void saveUser(User user) {
		(Factories.services.getUserManagerService()).saveUser(user);
	}
	
	public User getUserByLogin(String login) {
		return (Factories.services.getUserManagerService()).getUserByLogin(login);
	}
	
	public boolean userExists(String login, String password) {
		return (Factories.services.getUserManagerService()).userExists(login, password);
	}
}
