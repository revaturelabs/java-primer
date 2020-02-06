package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Hero;
import com.revature.repository.HeroRepository;

public class HeroServiceAlpha implements HeroService {
	
	private static Logger logger = Logger.getLogger(HeroServiceAlpha.class);
	
	//Dependency "Service needs Repository"
	private HeroRepository heroRepository;
	
	public HeroServiceAlpha() {}
	
	public HeroServiceAlpha(HeroRepository heroRepository) {
		logger.trace("Constructor Injection (With parameters)");
		this.heroRepository = heroRepository;
	}
	
	@Override
	public List<Hero> getAllHeroes() {
		return heroRepository.findAll();
	}
	
	//For Setter Injection
	//The name of the setter is important! Needs to match the bean name
	public void setMongo(HeroRepository heroRepository) {
		logger.trace("Setter Injection");
		this.heroRepository = heroRepository;
	}
}
