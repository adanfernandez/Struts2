package com.miw.business;

import javax.persistence.NoResultException;

import com.miw.infrastructure.Factories;
import com.miw.model.User;

public class UserDataServiceHelper {
	public void saveUser(User user) {
		(Factories.dataServices.getUserDataService()).saveUser(user);
	}
	
	public User getUserByUsername(String username) throws NoResultException {
		return (Factories.dataServices.getUserDataService()).getUserByUsername(username);
	}
}
