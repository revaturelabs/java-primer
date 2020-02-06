package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Hero;

@Transactional
public interface HeroRepository extends JpaRepository<Hero, Long> {
	List<Hero> findByNameIgnoreCase(String name);
}
