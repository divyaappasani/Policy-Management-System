package org.hcl.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hcl.dao.PolicyDao;
import org.hcl.entities.Policies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	PolicyDao dao;

	@Override
	@Transactional
	public boolean insertPolicy(Policies policy) {
		boolean b=dao.insert(policy);
		return b;
		
	}

	@Override
	@Transactional
	public void update(Policies policy) {
		dao.update(policy);
	}

	@Override
	@Transactional
	public void delete(Integer policyId) {
		dao.delete(policyId);
	}

	@Override
	@Transactional
	public Policies getPolicy(Integer policyId) {
		
		return dao.getPolicy(policyId);
	}

	@Override
	@Transactional
	public List<Policies> getAllPolicies() {
		return dao.getAllPolicies();
	}
	
}
