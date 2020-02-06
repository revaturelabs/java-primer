package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Hero;
import com.revature.service.HeroService;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		//If your config file it's named different, then change the parameter.
		ApplicationContext applicationContext
			= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Passing the second parameter we don't need to cast.
		HeroService heroService = applicationContext.getBean("heroService", HeroService.class);
		
		logger.trace(heroService.getAllHeroes());
	}
}
