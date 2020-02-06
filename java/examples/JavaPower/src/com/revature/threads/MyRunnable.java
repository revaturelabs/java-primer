package com.revature.threads;

/**
 * Second way of creating a thread
 *
 */
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
}
