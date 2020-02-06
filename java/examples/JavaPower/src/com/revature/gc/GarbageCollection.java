package com.revature.gc;

public class GarbageCollection {
	public String name;
	
	public void gcTesting() {
		GarbageCollection o1 = new GarbageCollection(); //Object 1
		o1.name = "Object 1";
		GarbageCollection o2 = o1;
		o1 = null;
		GarbageCollection o3 = new GarbageCollection(); //Object 2
		o3.name = "Object 2";
		o2 = null; // Object 1 is ready here
		o3 = null; // Object 2 is ready here
		System.gc(); //Remember, we are just suggesting
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(name + " time: " + System.currentTimeMillis());
		super.finalize();
	}
	
	public static void main(String[] args) {
		new GarbageCollection().gcTesting();
	}
}
