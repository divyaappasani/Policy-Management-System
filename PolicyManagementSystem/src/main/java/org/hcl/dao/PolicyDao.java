package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Policies;


public interface PolicyDao {
	public boolean insert(Policies policy);
	public void update(Policies policy);
	public void delete(Integer policyId);
	public Policies getPolicy(Integer policyId);
	public List<Policies> getAllPolicies();
}
