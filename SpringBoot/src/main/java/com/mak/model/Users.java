package com.mak.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Id
	@Size(min = 1, message = "is required")
	@Column(name = "user_name")
	private String userName;

	@Size(min = 1, message = "is required")
	@Column(name = "email_id")
	private String email;

	@Size(min = 1, message = "is required")
	@Column(name = "password")
	private String password;

	private String address;

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", enabled=" + enabled + ", role=" + role + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private int enabled;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "users")
	private List<Roles> role;

	/*
	 * @OneToMany(cascade = CascadeType.ALL) private List<OrderDetails> orders;
	 */

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public List<Roles> getRole() {
		return role;
	}

	public void setRole(List<Roles> role) {
		this.role = role;
	}
}
