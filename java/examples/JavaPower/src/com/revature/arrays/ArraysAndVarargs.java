package com.revature.arrays;

import java.util.Arrays;

public class ArraysAndVarargs {

	private void initArrays() {
		//LEFT
		int[] intArray;
		int intArraySecond[];
		
		//RIGHT
		intArray = new int[5];
		int[] intArrayThird = {1, 2, 3, 4, 5}; //Needs left and right
		intArraySecond = new int[]{5, 4, 3, 2, 1};
		Arrays.sort(intArraySecond); // Important utility class
		
		// Sizes of rows may not be the same (OCA)
		int[][] multiArray = {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println("-> Single Sorted");
		for(int i: intArraySecond) {
			System.out.println(i);
		}
		
		System.out.println("-> Multi Dimensional");
		for(int[] i: multiArray) {
			for(int j: i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	
	//private void varargs(String... parameters, int i) { //Won't compile: LAST PARAMETER!
	private void varargs(String... parameters) {
		System.out.println("The length is: " + parameters.length);
		for(String s: parameters) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	public static void main(String... args) {
		new ArraysAndVarargs().initArrays();
		new ArraysAndVarargs().varargs(new String[]{"Hello","varargs"});
		new ArraysAndVarargs().varargs("Not","Array","1","2");
	}
}
