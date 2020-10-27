package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Policies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PolicyDaoImpl implements PolicyDao {
	@Autowired
	SessionFactory factory;

	@Override
	public boolean insert(Policies policy) {
		boolean isInserted = false;
		Session session = factory.openSession();
		Integer i = (Integer) session.save(policy);
		if (i == policy.getPid())
			isInserted = true;
		session.close();
		return isInserted;
	}

	@Override
	public void update(Policies policy) {
		factory.getCurrentSession().update(policy);
	}

	@Override
	public void delete(Integer policyId) {

		factory.getCurrentSession().delete(getPolicy(policyId));
	}

	@Override
	public Policies getPolicy(Integer policyId) {
		Session session = factory.getCurrentSession();
		String query = "from org.hcl.entities.Policies p where p.pid=:pid";
		Policies verifiedUser = (Policies) session.createQuery(query).setParameter("pid",policyId)
		.uniqueResult();
		if (verifiedUser != null) {
			System.out.println("policy found");
			return verifiedUser;
		}else {
		return null; 
		}
		//return (Policies)session.get(Policies.class,policyId);
	}

	@Override
	public List<Policies> getAllPolicies() {
		return factory.getCurrentSession().createQuery("from org.hcl.entities.Policies").list();
	}

}
