package com.miw.business;

import com.miw.infrastructure.Factories;
import com.miw.model.User;

public class UserDataServiceHelper {
	public void saveUser(User user) {
		(Factories.dataServices.getUserDataService()).saveUser(user);
	}
	
	public User getUserByUsername(String username) throws Exception {
		return (Factories.dataServices.getUserDataService()).getUserByUsername(username);
	}
	
	public boolean userExists(String login, String password) {
		return (Factories.dataServices.getUserDataService()).userExists(login, password);
	}
}
