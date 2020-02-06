package com.revature.repository;

import java.util.List;

import com.revature.model.Pokemon;
import com.revature.model.PokemonType;

public interface PokemonRepository {
	public int save(Pokemon pokemon);
	public List<Pokemon> findAll();
	public Pokemon findByName(String name);
	public List<Pokemon> findByType(PokemonType pokemonType);
	public List<Pokemon> findByNameLike(String pattern);
	public Pokemon findByNameNative(String name);
}
