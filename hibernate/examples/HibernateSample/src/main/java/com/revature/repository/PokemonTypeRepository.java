package com.revature.repository;

import com.revature.model.PokemonType;

public interface PokemonTypeRepository {
	/** Returns generated id **/
	public int save(PokemonType pokemonType);
	public PokemonType findByElement(String element);
}
