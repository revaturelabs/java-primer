package com.revature.threads;

public class Deadlock extends Thread {
	static Object obj1 = new Object();
	static Object obj2 = new Object();

	public void m1() {
		//I want the monitor of object 1
		synchronized(obj1) {
			//I got it
			System.out.println("1 ");
			//I want the monitor of boject 2... ???
			synchronized(obj2) {
				System.out.println("2 ");
			}
		}
	}

	/**
	 * Solution: none.
	 * Avoid it by locking obj1 and then obj2 as m1() does on this method.
	 */
	public void m2() {
		//I want the monitor of object 1
		synchronized(obj2) {
			//I got it
			System.out.println("2 ");
			//I want the monitor of boject 2... ???
			synchronized(obj1) {
				System.out.println("1 ");
			}
		}
	}
	
	@Override
	public void run() {
		m1();
		m2();
	}
	
	public static void main(String[] args) {
		new Deadlock().start();
		new Deadlock().start();
	}
}
