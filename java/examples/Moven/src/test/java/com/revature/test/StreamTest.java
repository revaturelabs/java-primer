package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.java8.Stream;

public class StreamTest {
	
	private int[] testArray1;
	private int[] testArray2;
	private int[] testArray3;
	private int[] testArrayNull;
	
	//Our own Stream class
	private Stream streamInstance;
	
	/**
	 * Runs before every @Test starts.
	 */
	@Before
	public void setUp() {
		testArray1 = new int[]{5,4,6,36,4,9};
		testArray2 = new int[]{-5,256,7,49,257,8};
		testArray3 = new int[]{1024,1337,32767,40,1,0};
		streamInstance = new Stream();
	}
	
	@Test
	public void maxValueStreamTest() {
		assertEquals(streamInstance.streamMax(testArray1), 36);
		assertEquals(streamInstance.streamMax(testArray2), 257);
		assertEquals(streamInstance.streamMax(testArray3), 32767);
	}
	
	@Test
	public void averageStreamTest() {
		assertTrue(streamInstance.streamAverage(testArray1) >= 10.66
				&& streamInstance.streamAverage(testArray1) < 10.67);
		assertTrue(streamInstance.streamAverage(testArray2) >= 95.33
				&& streamInstance.streamAverage(testArray2) < 95.34);
		assertTrue(streamInstance.streamAverage(testArray3) >= 5861.5
				&& streamInstance.streamAverage(testArray3) < 5861.6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void maxValueStreamNullArgumentTest() {
		streamInstance.streamAverage(testArrayNull);
	}
	
//	@Test(timeout = 1000)
//	public void timeoutTest() {
//		for(;;) {}
//	}
	
	/**
	 * Runs after every @Test ends.
	 */
	@After
	public void tearDown() {
		testArray1 = null;
		testArray2 = null;
		testArray3 = null;
	}
}
