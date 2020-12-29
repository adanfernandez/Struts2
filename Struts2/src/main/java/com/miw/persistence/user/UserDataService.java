package com.miw.persistence.user;

import javax.persistence.NoResultException;

import com.miw.model.User;

public interface UserDataService {
	public void saveUser(User user);	
	public User getUserByUsername(String username) throws NoResultException;
	public User getUserByUsernameAndPassword(String username, String password) throws NoResultException;
}
