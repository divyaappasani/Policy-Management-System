package org.hcl.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorId;
	@NotBlank(message = "first name is required")
	private String firstName;
	@NotBlank(message = "Last name is required")
	private String lastName;
	@NotNull(message = "Age is required")
	private Integer age;
	private String gender;
	@NotBlank(message = "contactnumber is required")
	private String contactNumber;
	@NotBlank(message = "username is required")
	private String userName;
	@NotBlank(message = "password is required")
	private String password;

	@ManyToMany(cascade = CascadeType.ALL)

	@JoinTable(name = "vendor_policy", joinColumns = { @JoinColumn(name = "vendorid") }, inverseJoinColumns = {

			@JoinColumn(name = "pid") })

	private Set<Policies> polices = new HashSet<>();

	public Vendor() {
	}

	public Vendor(int vendorId, String firstName, String lastName, Integer age, String gender, String contactNumber,
			String userName, String password) {
		super();
		this.vendorId = vendorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.userName = userName;
		this.password = password;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Policies> getPolices() {
		return polices;
	}

	public void setPolices(Set<Policies> polices) {
		this.polices = polices;
	}

	public void add(Policies p) {
		polices.add(p);
	}

}
