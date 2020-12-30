package com.miw.business;

import javax.persistence.NoResultException;

import com.miw.infrastructure.Factories;
import com.miw.model.User;

public class UserDataServiceHelper {
	public boolean saveUser(User user) {
		return (Factories.dataServices.getUserDataService()).saveUser(user);
	}
	
	public User getUserByUsername(String username) throws NoResultException {
		return (Factories.dataServices.getUserDataService()).getUserByUsername(username);
	}
	
	public User getUserByUsernameAndPassword(String username, String password) throws NoResultException {
		return (Factories.dataServices.getUserDataService()).getUserByUsernameAndPassword(username, password);
	}
}
