package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.revature.model.Celebrity;
import com.revature.repository.CelebrityRepository;
import com.revature.repository.CelebrityRepositoryJdbc;

/**
 * 
 * This test case's purpose is to make sure all
 * data access operations of CelebrityRepository
 * work properly.
 *
 * I invite you investigate Mockito,
 * which works better for testing data access code.
 * 
 * With Mockito you can create MOCK: Connections, ResultSet.
 * 
 * We are going to test against the real database
 * only the read operations.
 * 
 * Another way without Mockito is to have a static TEST database.
 * 
 * ***********MAVEN GOALS************
 * To run these tests with a maven goal execute: -----> mvn test (or package to generate the jar)
 * Make sure you are standing in the directory of the project which has the pom.xml
 */
public class CelebrityDataAccessTest {
	
	private static Logger logger = Logger.getLogger(CelebrityDataAccessTest.class);
	
	private CelebrityRepository repository;
	
	//Mock objects
	private Celebrity celebrityTest;
	
	//Will execute before every @Test
	@Before
	public void setUp() {
		repository = CelebrityRepositoryJdbc.getInstance();
		celebrityTest = new Celebrity(0, "Beyonce", "Giselle", "Beyonce", "F");
	}
	
	//Unit test
	@Test
	public void selectAllTest() {
		logger.trace("Testing selectAll celebrities.");
		assertEquals(repository.selectAll().size(), 4);
	}
	
	@Test
	public void findByNameTest() {
		logger.trace("Testing findByName celebrity.");
		assertEquals(repository.findByFirstName("Beyonce"), celebrityTest);
	}
}
