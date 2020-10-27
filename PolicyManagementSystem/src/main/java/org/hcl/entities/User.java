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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	@NotBlank(message = "First name is required")
	private String firstName;
	@NotBlank(message = "Last name is required")
	private String lastName;
	@NotNull(message = "Age is required")
	private Integer age;
	private String gender;
	@NotBlank(message = "Contactdetails are required")
	private String contactNumber;
	@NotBlank(message = "Username is required")
	private String userName;
	@NotBlank(message = "password is required")
	private String password;

	@ManyToMany(cascade = CascadeType.ALL)

	@JoinTable(name = "user_policy", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = {

			@JoinColumn(name = "pid") })

	private Set<Policies> polices = new HashSet<>();

	public User() {

	}

	public User(int uId, String firstName, String lastName, Integer age, String gender, String contactNumber,
			String userName, String password, Set<Policies> polices) {
		super();
		this.uId = uId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.userName = userName;
		this.password = password;
		this.polices = polices;
	}

	
	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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
