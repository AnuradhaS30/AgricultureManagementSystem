package com.product.Agriculture.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer id;
	
	@NotEmpty
	@Column(name = "FIRSTNAME",nullable = false)
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(nullable = false, unique = true,name = "EMAIL")
	@NotEmpty
	@Email(message = "{errors.invalid_email}")
	private String email;
	
	/*
	 * @Column(name = "PHNO") private String phNo;
	 */
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
			name = "user_roles",
			joinColumns = { @JoinColumn (
					name = "USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = { @JoinColumn(
					name = "ROLE_ID", referencedColumnName = "ID")})
	private List<Role> roles;

	public User(User user) {
		super();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
//		this.phNo = user.getPhNo();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}

	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	/*
	 * public String getPhNo() { return phNo; }
	 * 
	 * public void setPhNo(String phNo) { this.phNo = phNo; }
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
}
