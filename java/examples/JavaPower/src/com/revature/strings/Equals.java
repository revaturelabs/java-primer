package com.revature.strings;

public class Equals {
	public void equalsTesting() {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		
		System.out.println(s1 == s2); //True, because they are both in the Heap (STRING POOL)
		System.out.println(s1 == s3); //False, they are different objects in the Heap.
		System.out.println(s1.equals(s3)); //True, because String overrides equals to compare characters.
		
		Equals e1 = new Equals();
		Equals e2 = new Equals();
		Equals e3 = e2;
		System.out.println(e1.equals(e2)); //False, because we are not overriding the equals method.
		System.out.println(e2 == e3); //Definitely true
	}
	
	public static void main(String[] args) {
		new Equals().equalsTesting();
	}
}
