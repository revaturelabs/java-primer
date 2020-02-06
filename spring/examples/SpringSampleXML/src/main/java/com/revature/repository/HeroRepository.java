package com.revature.repository;

import java.util.List;

import com.revature.model.Hero;

public interface HeroRepository {
	List<Hero> findAll();
}
