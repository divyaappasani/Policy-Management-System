package org.hcl.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Policies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	@NotBlank(message = "Policy Name is required")
	private String policyName;
	@NotBlank(message = "PolicyType is required")
	private String policyType;
	@NotBlank(message = "Company Name is required")
	private String companyName;
	private Integer duration;
	private Double amount;

	@ManyToMany(mappedBy = "polices")
	private Set<User> users = new HashSet<>();

	@ManyToMany(mappedBy = "polices")
	private Set<Vendor> vendors = new HashSet<>();

	public Policies() {

	}

	public Policies(Integer pid, String policyName, String policyType, String companyName, Integer duration,
			Double amount) {
		super();
		this.pid = pid;
		this.policyName = policyName;
		this.policyType = policyType;
		this.companyName = companyName;
		this.duration = duration;
		this.amount = amount;

	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}

	public void add(User user) {
		users.add(user);
	}

	public void addVendor(Vendor vendor) {
		vendors.add(vendor);
	}

}
