package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="POKEMON")
public class Pokemon {
	
	@Id
	@Column(name="P_ID")
	private int number;
	
	@Column(name="P_NAME", nullable = false, unique = true)
	private String name;
	
	/* By default eager */
	@OneToOne
	private PokemonType type;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Pokemon evolution;
	
	//By default is LAZY
	@ManyToMany(mappedBy = "pokemonOwned")
	//@JoinTable(name="POKEMON_TRAINER")
	private List<Trainer> trainersThatOwn;

	public Pokemon() {}
	
	public Pokemon(int number, String name, PokemonType type, Pokemon evolution) {
		this.number = number;
		this.name = name;
		this.type = type;
		this.evolution = evolution;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}

	public Pokemon getEvolution() {
		return evolution;
	}

	public void setEvolution(Pokemon evolution) {
		this.evolution = evolution;
	}

	public List<Trainer> getTrainersThatOwn() {
		return trainersThatOwn;
	}

	public void setTrainersThatOwn(List<Trainer> trainersThatOwn) {
		this.trainersThatOwn = trainersThatOwn;
	}

	@Override
	public String toString() {
		return "Pokemon [number=" + number + ", name=" + name + ", type=" + type + "]";
	}
}
