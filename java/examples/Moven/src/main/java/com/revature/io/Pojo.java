package com.revature.io;

import java.io.Serializable;

public class Pojo implements Serializable {
	/**
	 * Generated automatically for compatibiblity with Java 2 or less.
	 */
	private static final long serialVersionUID = -7936084817538286906L;
	
	private int id;
	private String username;
	private transient String password;
	
	public Pojo() {
		
	}
	
	public Pojo(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Pojo [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
