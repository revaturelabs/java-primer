package com.revature.control;

/**
 * We are learning control statements.
 * 
 * Blue kind of comments are JavaDoc (**).
 * 
 * Camel case for classes is the best practice for naming convention.
 * 
 * Control statements alter the flow of execution of our code.
 * 
 * @author Peter
 *
 */
public class Control {
	
	public void ifAndSwitch(int i) {
		
		/**
		 * All expressions in an if statement need to
		 * evaluate into a boolean expression
		 * 
		 * No: 0,1,null.
		 * 
		 * Always provide curly braces.
		 */
		if(i >= 5) {
			System.out.println("The value of i is more or equals to 5.");
		} else if (i == 3) {
			System.out.println("The value of i is 3.");
		} else {
			System.out.println("The value of i is not checked.");
		}
		
		byte b = 3;
		/**
		 * Switch only allows int or lesser values (byte, short, char),
		 * Strings and enums.
		 * 
		 * Be careful with break statements, if you don't use them, you switch
		 * will cascade until next break.
		 * 
		 * Similar to break, you can use return (one or the other).
		 */
		switch(b) {
		case 5:
			System.out.println("Byte is 5");
			break;
		case 3:
			System.out.println("Byte is 3");
		case 7:
			System.out.println("Byte is 7");
			break;
		default:
			System.out.println("Byte is not checked");
		}
		
		char c = '5';
		switch(c) {
		case 5:
			System.out.println("Char is 5");
			break;
		case '5':
			System.out.println("Char is the actual character '5'");
			break;
		}
	}
	
	public void looping() {
		for(int i = 0; i < 10; i++) {
			//I'm skipping the even numbers
			if(i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}
		
		//Infinite for loop
//		for(;;) {
//			
//		}
		
		/* You would use for loop over a while loop if you need more complex
		 * expressions in one line.
		 */
		for(int i = 0; i < 10; System.out.println(i++)) {}
		
		/* You would use a while over a for loop when only a boolean expression
		 * needs to be checked.
		 */
		//Daemon
//		while(true) {
//			
//		}
		
		/*
		 * The only difference is that this block will always execute at LEAST once.
		 */
//		do {
//			
//		} while(true);
	}
	
	/**
	 * Arithmetic: +,-,/,*,%,++,--,+=,-=,/=,*=,%=
	 * Important for OCA: ++ and -- can be post or pre increment (i++ or ++i).
	 * 
	 * Relational: ==, !=, >, <, >=, <= (they evaluate to boolean)
	 * 
	 * Logical: &, | [Non short-circuit] <-> &&, || [short-circuit]
	 * 
	 * Ternary: (boolean) ? [if true]: [if false] {Right side must return a value (no voids)}
	 * 
	 * Bit-wise: >>, <<
	 */
	public void operators() {
		System.out.println("-> Operators");
		
		int i = 3;
		System.out.println(i++); // 3 [This is post-increment]
		System.out.println(++i); //Previous value was 4 and we are pre-incrementing
		
		boolean b = false;
		
		/*
		 * If we use the non-short circuit, all expressions will be evaluated no matter the outcome.
		 * 
		 * If we use a SHORT-circuit operator, as soon as the expression is satisfied it will stop.
		 */
//		if(b | operatorHelper()) {
//			
//		}
		
		if(b && operatorHelper()) {
			
		}
		
	}
	
	public boolean operatorHelper() {
		System.out.println("Im in the helper.");
		return true;
	}
	
	public String ternaryOperator(boolean b) {
		return (b) ? "B is true" : "B is false";
		
		/**
		 * This would look like
		 * if(b) {
		 * 	return "B is true";
		 * } else {
		 * 	return "B is false";
		 * }
		 */
	}
	
	/**
	 * As other control statements we have: break, continue, return (all of these can be used inside of loop constructs).
	 * 
	 * try, catch and finally (exception handling) are also considered control statements.
	 */
	
	public static void main(String[] args) {
		/**
		 * Barebones instantiation of a Class
		 */
		new Control().ifAndSwitch(-8868);
		
		Control control = new Control();
		control.looping();
		control.operators();
		System.out.println(control.ternaryOperator(false));
	}
}
