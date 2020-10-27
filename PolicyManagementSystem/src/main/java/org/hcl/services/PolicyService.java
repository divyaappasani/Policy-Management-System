package org.hcl.services;

import java.util.List;

import org.hcl.entities.Policies;

public interface PolicyService {
	public boolean insertPolicy(Policies policy);
	public void update(Policies policy);
	public void delete(Integer policyId);
	public Policies getPolicy(Integer policyId);
	public List<Policies> getAllPolicies();
}
