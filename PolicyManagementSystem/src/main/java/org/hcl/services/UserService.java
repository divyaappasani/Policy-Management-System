package org.hcl.services;

import org.hcl.entities.User;

public interface UserService {

	public boolean insertUser(User user);
	public User verifyUser(User user);
	public void payment(int id);
}
