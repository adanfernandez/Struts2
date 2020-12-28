package com.miw.persistence.user;

import com.miw.model.User;

public interface UserDataService {
	public void saveUser(User user);
	
	public User getUserByUsername(String username);
	
	public boolean userExists(String login, String password);
}
