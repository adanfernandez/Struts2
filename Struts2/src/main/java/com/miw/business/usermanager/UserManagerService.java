package com.miw.business.usermanager;

import javax.persistence.NoResultException;

import com.miw.model.User;

public interface UserManagerService {

	public boolean registerUser(User user);

	public User getUserByUsername(String login) throws NoResultException;

	public User getUserByCredentials(String login, String password) throws NoResultException;
	
}
