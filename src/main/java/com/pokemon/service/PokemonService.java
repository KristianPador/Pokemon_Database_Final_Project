package com.pokemon.service;

import java.util.List;
import java.util.Optional;

import com.pokemon.entity.Evolution;
import com.pokemon.entity.Pokemon;
import com.pokemon.entity.PokemonType;

public interface PokemonService {
	
	/**
	 * @param name
	 * @param type1
	 * @param pokemonGen
	 * @return
	 */

	List<Pokemon> fetchPokemon(String name, PokemonType type1, int pokemonGen);
	
	/**
	 * 
	 * @param name
	 * @param pokemonSpecies
	 * @param pokemonGen
	 * @param type1
	 * @param type2
	 * @param pokemonEvo
	 * @return
	 */
	
	Optional<Pokemon> createPokemon(String name, String pokemonSpecies, int pokemonGen, PokemonType type1, PokemonType type2, Evolution pokemonEvo);
	
	/**
	 * 
	 * @param name
	 * @param pokemonSpecies
	 * @param pokemonGen
	 * @param type1
	 * @param type2
	 * @param pokemonEvo
	 * @return
	 */
	
	Optional<Pokemon> updatePokemon(String name, String pokemonSpecies, int pokemonGen, PokemonType type1, PokemonType type2, Evolution pokemonEvo);
	
	
	
	
}
