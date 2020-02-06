package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Jedi;
import com.revature.service.JediService;

public class Main {
	public static void main(String[] args) {
		/* Pulling out Application Context. */
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/* Getting JediService Bean with dependencies injected. */
		JediService jediService = appContext.getBean("jediService", JediService.class);
		
		/* Registering Jedis */
		System.out.println("Registering Jedis.");
		jediService.register(new Jedi(0,"Obi Wan","Blue"));
		jediService.register(new Jedi(0,"Yoda","Green"));
		jediService.register(new Jedi(0,"Anakin","Red"));
		
		/* Printing all jedis from database. */
		System.out.println("All Jedis: " + jediService.getAllJedis());
		
		/* Get Anakin only from database */
		System.out.println("Getting Anakin: " + jediService.getJedi(new Jedi("Anakin")));
		
		/* Get %i% Jedis */
		System.out.println("Getting %i% Jedis: " + jediService.getJedisByPattern("%i%"));
		
		/* Get Yoda with Native Query */
		System.out.println("Getting Yoda with Native Query: " + jediService.getJediNative(new Jedi("Yoda")));
		
		/* Insert with Stored Procedure */
		System.out.println("Registering Jedi with Stored Procedure: ");
		jediService.registerSecure(new Jedi(45346, "Darth Vader", "Red"));
		
		/* Calling Dual from Oracle */
		System.out.println("Getting current Jedi Time: " + jediService.getCurrentJediTime());
	}
}
