package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.HeroService;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		//If your config file it's named different, then change the parameter.
		ApplicationContext applicationContext
			= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Passing the second parameter we don't need to cast.
		HeroService heroService = applicationContext.getBean("heroService", HeroService.class);
		
		//Registering Heroes
//		logger.trace((heroService.registerHero(new Hero("Dr. Strange", "Knowledge", true))) 
//				? "Dr. Strange registered successfully." : "Couldn't register hero.");
//		
//		logger.trace((heroService.registerHero(new Hero("Flash", "Speed", false))) 
//				? "Flash registered successfully." : "Couldn't register hero.");
//		
//		logger.trace((heroService.registerHero(new Hero("Batman", "Money", true))) 
//				? "Batman registered successfully." : "Couldn't register hero.");
//		
//		logger.trace((heroService.registerHero(new Hero("Blade", "Vampire", false))) 
//				? "Blade registered successfully." : "Couldn't register hero.");
		
		//Selecting Heroes
		logger.trace("Selecting all heroes: " + heroService.getAllHeroes());
		
		//Finding by names
		logger.trace("Selecting Flash: " +heroService.getHero("Flash"));
	}
}
