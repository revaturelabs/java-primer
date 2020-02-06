package com.revature.repository;

import java.util.Set;

import com.revature.model.Celebrity;

/**
 * Celebrity entity DAO
 */
public interface CelebrityRepository {
	
	/**
	 * Inserts a new celebrity in the database
	 */
	public boolean insert(Celebrity celebrity);
	
	/**
	 * Inserts a new celebrity in the database using a CallableStatement
	 * (Stored Procedure)
	 */
	public boolean insertProcedure(Celebrity celebrity);
	
	/**
	 * Select one [first one] Celebrity based on his/her first name.
	 */
	public Celebrity findByFirstName(String firstName);
	
	/**
	 * Select all celebrities from the database.
	 */
	public Set<Celebrity> selectAll();
}
