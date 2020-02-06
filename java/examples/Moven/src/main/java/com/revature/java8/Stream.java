package com.revature.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

public class Stream {

	private static Logger logger = Logger.getLogger(Stream.class);
	
	// Iterate
	public void streamIterate(List<Associate> associateList) {
		// For each receives a Consumer<T> which is expecting an action.
		associateList.stream().forEach((Associate a) -> { System.out.println(a.getFirstName()); });
	}

	//Filter
	public void streamFilter(List<Associate> associateList, String filter) {
		//Filter receives a Predicate<T> as parameter
		associateList.stream().filter((Associate a) -> new StringBuilder(a.getFirstName()).indexOf(filter) != -1)
		.forEach((Associate a) -> { System.out.println(a.getFirstName()); });
	}

	//Max
	public int streamMax(int[] array) throws IllegalArgumentException {
		if(array == null) {
			logger.warn("User sent null array.");
			throw new IllegalArgumentException("Can't process a null array.");
		}
		return Arrays.stream(array).max().getAsInt();
	}

	//Average
	public double streamAverage(int[] array) throws IllegalArgumentException {
		if(array == null) {
			logger.warn("User sent null array.");
			throw new IllegalArgumentException("Can't process a null array.");
		}
		return Arrays.stream(array).average().getAsDouble();
	}

	public static void main(String[] args) {
		Stream stream = new Stream();

		List<Associate> associateList = new ArrayList<>();
		associateList.add(new Associate(1,"Juan","Lopez"));
		associateList.add(new Associate(2,"Ariel","Gomez"));
		associateList.add(new Associate(3,"Peter","Alagna"));
		associateList.add(new Associate(4,"Bobbert","Lesley"));

		/** Iterate **/
		System.out.println("Iterating over all list: ");
		stream.streamIterate(associateList);
		System.out.println();

		/** Filter **/
		String filter = "r";
		System.out.println("Iterating over list with filter(" + filter + ")");
		stream.streamFilter(associateList, filter);
		
		/** Max **/
		//In unit test
		
		/** Average **/
		//In unit test
	}
}
