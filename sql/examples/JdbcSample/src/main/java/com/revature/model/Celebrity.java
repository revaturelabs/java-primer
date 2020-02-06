package com.revature.model;

/*
 * Incomplete version of the Celebrity entity.
 * 
 * 	Normally you wan't to represent ALL columns in the database.
 */
public class Celebrity {
	private long id;
	private String firstName;
	private String lastName;
	private String stageName;
	private String gender;
	
	/*
	 * This is how you should represent foreign keys.
	 */
	//private long industryId; THE WORSE!
	//private Industry industry; -> Has A Relationship.
	
	public Celebrity() {}

	public Celebrity(long id, String firstName, String lastName, String stageName, String gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.stageName = stageName;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * Don't use the ID!
	 * 
	 * I want to remove 
	 * PK, First, Last
	 * ----------------
	 * 1, Peter, Alagna, 123rd AVE, 1567-08-29
	 * 2, Peter, Alagna, 123rd AVE, 1567-08-29
	 * 
	 * For the database, this two rows are unique, only because the primary key changes.
	 * In Java, we have the ability to remove that redundancy, that's why we use SETS and
	 * don't use ID for the hashCode or the equals, only the other fields.
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((stageName == null) ? 0 : stageName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celebrity other = (Celebrity) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (stageName == null) {
			if (other.stageName != null)
				return false;
		} else if (!stageName.equals(other.stageName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Celebrity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", stageName="
				+ stageName + ", gender=" + gender + "]";
	}
}
