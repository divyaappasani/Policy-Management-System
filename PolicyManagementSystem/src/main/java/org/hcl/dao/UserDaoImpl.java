package org.hcl.dao;

import javax.transaction.Transactional;

import org.hcl.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public boolean insert(User user) {
		boolean isInserted = false;
		Session session = factory.openSession();
		Integer i = (Integer) session.save(user);
		if (i == user.getuId())
			isInserted = true;
		session.close();
		return isInserted;
	}

	@Override
	@Transactional
	public User verifyUser(User user) {
		

		Session session = factory.getCurrentSession();
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		String query = "from org.hcl.entities.User u where u.userName=:userName and u.password=:password";
		User verifiedUser = (User) session.createQuery(query).setParameter("userName", user.getUserName())
				.setParameter("password", user.getPassword()).uniqueResult();
		if (verifiedUser != null) {
			System.out.println(verifiedUser.getUserName());
			return verifiedUser;
		}else {
		return null; 
		}
	}

	@Override
	public void payment(int id) {
		Session session = factory.getCurrentSession();
		String status="Update User user set user.paymentStatus='paid' where user.uId=:id";
		Query query=session.createQuery(status);
		query.setParameter("id",id);
		query.executeUpdate();
		
		
	}
}
