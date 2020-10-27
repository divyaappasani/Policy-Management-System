package org.hcl.dao;

import org.hcl.entities.User;

public interface UserDao {

	public boolean insert(User user);
	public User verifyUser(User user);
	public void payment(int id);
}
