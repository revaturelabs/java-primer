package com.revature.java8;

import java.io.Serializable;

public class Associate implements Serializable {

	/** Compatibility with Java 2.x **/
	private static final long serialVersionUID = 2677624230797211320L;

	private int id;
	private String firstName;
	private String lastName;
	
	public Associate() {}
	
	public Associate(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Associate [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
