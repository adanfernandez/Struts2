package com.miw.business.usermanager;

import com.miw.model.User;

public interface UserManagerService {

	public void saveUser(User user);

	public User getUserByUsername(String login);

	public boolean userExists(String login, String password);
	
}
