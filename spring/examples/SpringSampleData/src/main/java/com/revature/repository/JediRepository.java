package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.revature.model.Jedi;

/**
 * 
 * For all available JpaRepository methods:
 * https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
 *
 */
@Transactional
public interface JediRepository extends JpaRepository<Jedi, Long> {
	/* Use the Top keyword if you know that the field is not unique */
	Jedi findTopByName(String name);
	
	/* Use Containing to use the LIKE operator */
	List<Jedi> findByNameContaining(String pattern);
	
	/* For Native SQL */
	@Query(value = "SELECT * FROM JEDI WHERE J_NAME = ?1 AND ROWNUM = 1", nativeQuery = true)
	Jedi findJediNative(String name);
	
	/* Calling Functions */
	@Query(value = "SELECT TO_CHAR(CURRENT_TIMESTAMP, 'MM/DD/YYYY HH:MI:SS') FROM DUAL", nativeQuery = true)
	String currentJediTime();
	
	/* Stored Procedures */
	@Procedure(name="INSERT_JEDI")
	void save(@Param("ID") Integer id, @Param("NAME") String name, @Param("SABER_COLOR") String saberColor);
}
