package com.revature.repository;

import java.util.Set;

import com.revature.model.Celebrity;

/**
 * This is why we define Interfaces.
 * 
 * We might add a Hibernate implementation of it and use it
 * in our system in the future.
 *
 */
public class CelebrityRepositoryHibernate implements CelebrityRepository {

	@Override
	public boolean insert(Celebrity celebrity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertProcedure(Celebrity celebrity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Celebrity findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Celebrity> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
