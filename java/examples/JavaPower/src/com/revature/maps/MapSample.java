package com.revature.maps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapSample {

	public void iterateMap(Map<Integer, String> map) {
		/*
		 * We can iterate:
		 */
		
		//By the key
		System.out.println("By the key:");
		for(Integer key: map.keySet()) {
			System.out.println(key + "=" + map.get(key));
		}
		
		//By the values
		System.out.println("By the value");
		for(String value: map.values()) {
			System.out.println(value);
		}
		
		//Fastest way
		System.out.println("By entry-set");
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		/**
		 * There is no add(object) method, we use put(key,value) for maps
		 */
		
		/**
		 * Note that put replaces the value if the key exists.
		 */
		map.put(1, "Peter");
		map.put(1, "Petronilo");
		map.put(6, "Robert");
		map.put(3, "Bobbert");
		map.put(5, "Edward");
		map.put(4, "Parker");
		map.put(2, "Carlos");
		//Add more to see that order is no guaranteed
		map.put(234, "Carlos");
		map.put(2553, "Carlos");
		map.put(434, "Carlos");
		map.put(2242, "Carlos");
		map.put(43232, "Carlos");
		map.put(null, "Yes");
		
		new MapSample().iterateMap(map);
		
		/**
		 * No keys nor values!
		 */
		map = new Hashtable<>();
//		map.put(null, "Yes");
		map.put(5, null);
	}
}
