package com.miw.business.usermanager;

import com.miw.model.User;

public interface UserManagerService {

	public void saveUser(User user);

	public User getUserByUsername(String login) throws Exception;

	public User getUserByCredentials(String login, String password) throws Exception;
	
}
