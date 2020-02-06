package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Hero;

@Repository("heroRepository")
public class HeroRepositoryHibernate implements HeroRepository {

	@Override
	public List<Hero> findAll() {
		List<Hero> heroList = new ArrayList<>();
		heroList.add(new Hero(1, "Dr. Strange", "Knowledge", true));
		heroList.add(new Hero(2, "Flash", "Speed", false));
		heroList.add(new Hero(3, "Batman", "Money", true));
		heroList.add(new Hero(4, "Blade", "Vampire", false));
		heroList.add(new Hero(5, "Dr Manhattan", "Alters Matter", false));
		heroList.add(new Hero(6, "Captain America", "Courage", false));
		
		return heroList;
	}
}
