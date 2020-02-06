package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Hero;
import com.revature.repository.HeroRepository;

@Service("heroService")
public class HeroServiceAlpha implements HeroService {
	
	private static Logger logger = Logger.getLogger(HeroServiceAlpha.class);
	
	//Dependency "Service needs Repository"
	//Constructor Injection 
	//(Will use no-args or default if available, if not, it will use parameters if available
//	@Autowired
	private HeroRepository heroRepository;
	
	public HeroServiceAlpha() {
		logger.trace("Constructor Injection (no-args)");
	}
	
	//Still constructor injection, but forcing with parameters
//	@Autowired
	public HeroServiceAlpha(HeroRepository heroRepository) {
		logger.trace("Constructor Injection (with parameters)");
		this.heroRepository = heroRepository;
	}
	
	@Override
	public List<Hero> getAllHeroes() {
		return heroRepository.findAll();
	}
	
	//For Setter Injection
	@Autowired
	public void setHeroRepository(HeroRepository heroRepository) {
		logger.trace("Setter Injection");
		this.heroRepository = heroRepository;
	}
}
