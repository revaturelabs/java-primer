package com.revature.reflection;

public class Inspect {
	
	public int firstMethod(int i) {
		System.out.println("First method (one parameter): " + i);
		return 0;
	}
	
	public int secondMethod(int i, int j) {
		System.out.println("Second method (two parameter): " + i + "," + j);
		return 0;
	}
	
	public int thirdMethod(int i, int j) {
		System.out.println("Third method (two parameter): " + i + "," + j);
		return 0;
	}
}
