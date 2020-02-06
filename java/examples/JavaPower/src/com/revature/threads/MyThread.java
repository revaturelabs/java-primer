package com.revature.threads;

/**
 * 
 * First way to create your own Thread.
 *
 */
public class MyThread extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(getName() + ": " + i);
			//This is the same, we get the methods by inheritance.
			//System.out.println(super.getName() + ": " + i);
		}
	}
}
