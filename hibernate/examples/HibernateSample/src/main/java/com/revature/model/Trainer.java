package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TRAINER")
public class Trainer {
	
	@Id
	@Column(name="T_ID")
	//generator references name on @SequenceGenerator
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="trainerSequence")
	//sequenceName is the actual name of the Sequence in the database
	@SequenceGenerator(name="trainerSequence", sequenceName="TRAINER_SEQ")
	private int id;
	
	@Column(name="T_NAME")
	private String name;
	
	@Column(name="T_AGE")
	private int age;
	
	//Referencing field on Pokemon class
	@ManyToMany
	//Need to specify junction table name if you don't have mappedBy
	@JoinTable(name="POKEMON_TRAINER")
	private List<Pokemon> pokemonOwned;

	public Trainer() {}
	
	public Trainer(String name, int age, List<Pokemon> pokemonOwned) {
		this.name = name;
		this.age = age;
		this.pokemonOwned = pokemonOwned;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Pokemon> getPokemonOwned() {
		return pokemonOwned;
	}

	public void setPokemonOwned(List<Pokemon> pokemonOwned) {
		this.pokemonOwned = pokemonOwned;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
