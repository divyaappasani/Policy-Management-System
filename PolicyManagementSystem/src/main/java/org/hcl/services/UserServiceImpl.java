package org.hcl.services;

import javax.transaction.Transactional;

import org.hcl.dao.UserDao;
import org.hcl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	@Transactional
	public boolean insertUser(User user) {
		boolean b=dao.insert(user);
		return b;
	}

	@Override
	@Transactional
	public User verifyUser(User user) {
		return dao.verifyUser(user);
	}

	@Override
	@Transactional
	public void payment(int id) {
		dao.payment(id);
	}

}
