package com.revature.threads;

public class Driver {

	public static void main(String[] args) throws Exception {
		Thread peter = new MyThread();
		
		//Setting a name to the Thread
		peter.setName("Peter");
		peter.start();
		
		//Wait for peter to end
		peter.join();
		
		Thread bobbert = new MyThread();
		bobbert.setName("Bobbert");
		bobbert.start();
		
		Runnable runnable = new MyRunnable();
		//You need the Thread class
		new Thread(runnable).start();
		
		/**
		 * Third way to implement a thread
		 */
		new Thread(() -> {
			for(int i = 0; i < 100; i++) {
				System.out.println("Third way: " + i);
			}
		}).start();
	}

}
