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
		
		//Getting special hero
		Hero specialHero = applicationContext.getBean("specialHero", Hero.class);
		specialHero.setHasCape(false);
		logger.trace("Special hero with modified cape: " + specialHero);
		
		/* Note how we are getting the "true" value of the property again,
		* because of the prototype scope, which is behaving as a factory.
		* NOTE: If you change the scope to singleton, note how both logs
		* print "false", because there is only one instance on the heap.
		*/
		Hero freshSpecialHero = applicationContext.getBean("specialHero", Hero.class);
		logger.trace("Fresh special hero: " + freshSpecialHero);
	}
}
