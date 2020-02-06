package com.revature.numbers;

import com.revature.control.Control;

public class PrimitivesAndWrappers {
	
	public void primitivesTesting() {
		//Knowing primitives is important for OCA!
		
		// One bit (0-1 behind the scenes) [DO NOT USE 1 OR 0]
		boolean bo = true;
		
		// Signed, 2^8 -> max positive 127
		// 8 bits.
		byte b = 127;
		
		// Signed, 2^16 -> max positive 32767
		short s = 32767;
		
		/* 
		 * Unsigned, 2^16 -> max value 65535
		 * 
		 * If you use a number for a char, is going to be
		 * the ASCII representation of it.
		 * 
		 * Behind the scenes, a char is an int of a different kind.
		 */
		char c = 6;
		c = 's';
		System.out.println("Value of char: " + c);
		
		/* Signed, 2^32 -> max positive value is 4 gigabytes
		 * 
		 * A literal number, is automatically an int if it has no
		 * decimals.
		 */
		int i = 424712947;
		
		/* 
		 * Signed, 2^64 -> max positive value is in the order of quintillions
		 * 
		 * Interesting fact: 2^62 approximate weight of earth in tons.
		 * 
		 * You can declare LITERAL longs with 'L'
		 */
		long l = 4353L;
		
		/*
		 * Signed, 2^32 including the decimal part.
		 * 
		 * You can declare LITERAL floats with 'f'
		 */
		float f = 20.4f;
		//f = 5 works
		
		/*
		 * Signed, 2^64 including decimal part.
		 * 
		 * Any decimal LITERAL is considered a double.
		 */
		double d = 50.4;
		
		/*
		 * Let's play around assigning them to each other
		 */
		
		//b = i; doesn't work!
		i = b;
		i = s;
		i = c;
		//i = l; doesn't work
		//i = d; doesn't work
		//i = f; !!
		
		d = i;
		f = i;
		//f = d; !!
		
		//i = bo; No such thing as this.
		
		/**
		 * Wrapper classes are the OBJECT representation of
		 * primitives.
		 * 
		 * They are useful because now we have methods that we
		 * can execute to meet our needs.
		 * 
		 * Knowing the basics of wrappers is important for OCA.
		 * 
		 * They are immutable in Java.
		 * 
		 * Wrappers extend the Number abstract class.
		 * 
		 * And immutable class (OCP):
		 * 1) Has a final value.
		 * 2) The actual class is final.
		 * 3) There is no setters, you can only initialize the
		 * value through overloaded constructors.
		 */
		
		/**
		 * You can assign primitives directly to wrapper classes
		 * -> BECAUSE of AUTOBOXING.
		 * Behind the scenes what happens is:
		 * -> new Integer(i)
		 * -> new WhicheverWrapper(primitiveValue)
		 * -> It's encapsulating, wrapping the value.
		 */
		
		//Study the boolean constructors for OCA
		Boolean booleanObject = bo;
		Byte byteObject = b;
		Short shortObject = s;
		//Character name is the only one that changes.
		Character charObject = c;
		Integer integerObject = i;
		Long longObject = l;
		Float floatObject = f;
		Double doubleObject = d;
		
		/**
		 * We can assign wrapper objects directly into primitives.
		 * This is called UNBOXING
		 * 
		 * -> Behind the scenes is calling a wrapper method to
		 * return the primitive value.
		 */
		int primitive = integerObject;
	}
	
	public static void main(String[] args) {
		new PrimitivesAndWrappers().primitivesTesting();
	}
}
