package com.revature.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public void invokeDualIntegerMethod(Class<?> theClass, int i, int j) throws Exception {
		for(Method m: theClass.getMethods()) {
			if(m.getParameterTypes().length == 2) {
				int integerCount = 0;
				for(Class<?> c: m.getParameterTypes()) {
					if(c.equals(int.class)) {
						integerCount++;
					}
				}
				
				//theClass.getConstructors()[0].newInstance()
				// -> new Inspect()
				System.out.println((integerCount == 2) ? 
						m.getName() + ": " + m.invoke(theClass.getConstructors()[0].newInstance(), i, j) :
						m.getName() + ": Doesn't have two int parameters");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Class<?> inspectClass = Class.forName("com.revature.reflection.Inspect");
		//We get the name printed
		System.out.println(inspectClass);
		
		System.out.println("Reflecting!");
		new Reflection().invokeDualIntegerMethod(inspectClass, 5, 3);
	}
}
