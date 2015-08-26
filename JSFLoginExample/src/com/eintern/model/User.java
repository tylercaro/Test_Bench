package com.eintern.model;

import javax.persistence.*;

@Entity
@Table(name="USERTABLE")
public class User {
	@Id
	private String username;
	@Column
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
