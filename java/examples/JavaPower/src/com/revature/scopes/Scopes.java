package com.revature.scopes;

public class Scopes {
	
	/** 
	 * Class (Static) scope
	 */
	private static int i;
	
	private static void myMethod() {
		System.out.println("Welcome to the static scope.");
		
		/**
		 * Local (Block) scope
		 */
		if(i > 0) {
			String localVariable = "";
			//String localVariable = "hello"; //No!
		}
		
		{
			String localVariable = "";
		}
		//System.out.println(localVariable); //No!
	}
	
	/**
	 * Instance (Object) scope
	 * 
	 */
	private String aNumber;
	
	/**
	 * Method (Parameter[s]) scope
	 * 
	 * Remember: Java is pass-by-value!!
	 */
	private void methodScopePrimitive(int i) {
		i = 7;
	}
	
	private void methodScopeObject(int i[]) {
		i[2] = 32767;
		i = null;
	}
	
	public static void main(String[] args) {
		Scopes.myMethod();
		System.out.println(Scopes.i);
		
		//System.out.println(aNumber); //Doesn't work
		System.out.println(new Scopes().aNumber);
		
		//Testing method scope.
		int anotherInt = 5;
		new Scopes().methodScopePrimitive(anotherInt);
		System.out.println(anotherInt);
		
		//OCP!
		int[] anArray = {1,2,3,4};
		new Scopes().methodScopeObject(anArray);
		//anArray = null;
		for(int i: anArray) {
			System.out.print(i + ",");
		}
	}
}
