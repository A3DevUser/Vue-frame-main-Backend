package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="VF_USER_TABLE")
public class UserInfo { 

	@Id
	@Column(name="USERID")
	private String id; 
	
	@Column(name="USERNAME")
	private String name;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name="EMAILID")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="VF_ROLE")
	private String roles;

	public String getId() {
		return id;
	}

	public void setId(String setId) {
		this.id = setId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public UserInfo(String id, String name, String firstName, String lastName, String email, String password,
			String roles) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

} 
