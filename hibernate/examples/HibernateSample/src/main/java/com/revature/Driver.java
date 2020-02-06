package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Pokemon;
import com.revature.model.PokemonType;
import com.revature.model.Trainer;
import com.revature.repository.PokemonRepository;
import com.revature.repository.PokemonRepositoryHibernate;
import com.revature.repository.PokemonTypeRepository;
import com.revature.repository.PokemonTypeRepositoryHibernate;
import com.revature.repository.TrainerRepository;
import com.revature.repository.TrainerRepositoryHibernate;
import com.revature.util.ConnectionUtil;

public class Driver {
	private static Logger logger = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		//Forcing session factory build
		ConnectionUtil.getSession();
		
		PokemonTypeRepository pokemonTypeRepository = new PokemonTypeRepositoryHibernate();
		PokemonRepository pokemonRepository = new PokemonRepositoryHibernate();
		TrainerRepository trainerRepository = new TrainerRepositoryHibernate();
		
		/* Types */
		logger.trace("---Types---");
		
		/* Insterting */
		logger.trace("Grass ID: " + pokemonTypeRepository.save(new PokemonType("GRASS")));
		logger.trace("Fire ID: " + pokemonTypeRepository.save(new PokemonType("FIRE")));
		logger.trace("Water ID: " + pokemonTypeRepository.save(new PokemonType("WATER")));
		
		/* Getting */
		PokemonType grass = pokemonTypeRepository.findByElement("GRASS");
		PokemonType fire = pokemonTypeRepository.findByElement("FIRE");
		PokemonType water = pokemonTypeRepository.findByElement("WATER");
		
		/* Pokemons */
		logger.trace("---Pokemons---");
		
		Pokemon bulbasaur = new Pokemon(
				1,
				"BULBASAUR",
				grass,
				new Pokemon(
						2,
						"IVYSAUR",
						grass,
						new Pokemon(
								3,
								"VENUSAUR",
								grass,
								null
								)
						));
		pokemonRepository.save(bulbasaur);
		
		Pokemon charmander = new Pokemon(
				4,
				"CHARMANDER",
				fire,
				new Pokemon(
						5,
						"CHARMELEON",
						fire,
						new Pokemon(
								6,
								"CHARIZARD",
								fire,
								null
								)
						));
		pokemonRepository.save(charmander);
		
		Pokemon squirtle = new Pokemon(
				7,
				"SQUIRTLE",
				water,
				new Pokemon(
						8,
						"WARTORTLE",
						water,
						new Pokemon(
								9,
								"BLASTOISE",
								water,
								null
								)
						));
		pokemonRepository.save(squirtle);
		
		/* Queries */
		logger.trace("---Queries---");
		
		/* All Pokemon */
		logger.trace("ALL POKEMON: " + pokemonRepository.findAll());
		
		/* 
		 * Evolution is set to be Lazily loaded
		 * The query will actually execute before the getter happens. 
		 * Change the FetchType to EAGER to see the difference.
		 * */
		//Persistent wartortle
		Pokemon wartortle = pokemonRepository.findByName("WARTORTLE");
		logger.trace("SELECTED BY NAME: " + wartortle);
		
		logger.trace("GETTING WARTORTLE EVOLUTION: " + wartortle.getEvolution());
		
		/* Select by Type */
		logger.trace("SELECTED BY TYPE" + pokemonRepository.findByType(water));
		
		/* HQL */
		logger.trace("SELECTED BY PATTERN WITH HQL: " + pokemonRepository.findByNameLike("CH_R%"));
		
		/* Native SQL */
		logger.trace("SELECT BY NAME WITH NATIVE QUERY: " + pokemonRepository.findByNameNative("sQuIRtle"));
		
		/* Trainers */
		logger.trace("--Trainers--");
		
		List<Pokemon> ashPokemons = new ArrayList<>();
		//Getting Charizard Persistent instance
		Pokemon charizard = pokemonRepository.findByName("CHARIZARD");
		ashPokemons.add(wartortle);
		ashPokemons.add(charizard);
		
		//Transient Trainer
		Trainer ash = new Trainer("ASH", 150, null);
		Trainer peter = new Trainer("PETER", 210, null);
		
		/* Insert new trainer without pokemons owned */
		trainerRepository.save(ash);
		
		//Ash is already persistent because
		//the save method gave us the ID.
		logger.trace(ash.getId());

		ash.setPokemonOwned(ashPokemons);
		trainerRepository.update(ash);
		
		List<Pokemon> myPokemons = new ArrayList<>(); 
		myPokemons.add(wartortle);
		peter.setPokemonOwned(myPokemons);
		trainerRepository.update(peter);
		
		logger.trace(peter.getId());
		
		//Wartortle was persistent and it also has a mappedBy on his @ManyToMany
		//Which means Hibernate will populate this data as soon as the trainer is updated.
		logger.trace("Trainers that own Wartortle: " + wartortle.getTrainersThatOwn());
	}
}
