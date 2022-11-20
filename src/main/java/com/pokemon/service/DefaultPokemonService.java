package com.pokemon.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pokemon.dao.PokemonDao;
import com.pokemon.entity.Evolution;
import com.pokemon.entity.Pokemon;
import com.pokemon.entity.PokemonType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPokemonService implements PokemonService {
	
	@Autowired
	private PokemonDao pokemonDao;

	@Transactional(readOnly = true)
	@Override
	public List<Pokemon> fetchPokemon(String name,PokemonType type1, int pokemonGen) {
		log.debug("The fetchPokemon method was called with pokemonName={} type1={} and pokemonGen={}", name, type1, pokemonGen);
		
		List<Pokemon> pokemon = pokemonDao.fetchPokemon(name, type1, pokemonGen);
		
		if(pokemon.isEmpty()) {
			String msg = String.format("No Pokemon found with pokemonName=%s type1=%s and pokemonGen=%s", name, type1, pokemonGen);
			throw new NoSuchElementException(msg);
		}
		return pokemon;
	}	
	

	@Override
	public Optional<Pokemon> createPokemon(String name, String pokemonSpecies, int pokemonGen, PokemonType type1,
			PokemonType type2, Evolution pokemonEvo) {
		log.debug("The createPokemon method was called with pokemonName={}, pokemonSpecies={}, pokemonGen={},"
				+ " type1={}, type2={}, pokemonEvo={}", name, pokemonSpecies, pokemonGen, type1, type2, pokemonEvo);
		return pokemonDao.createPokemon(name, pokemonSpecies, pokemonGen, type1, type2, pokemonEvo);
	}


	@Override
	public Optional<Pokemon> updatePokemon(String name, String pokemonSpecies, int pokemonGen, PokemonType type1,
			PokemonType type2, Evolution pokemonEvo) {
		log.debug("The updatePokemon method was called with pokemonName={}, pokemonSpecies={}, pokemonGen={},"
				+ " type1={}, type2={}, pokemonEvo={}");
		return pokemonDao.updatePokemon(name, pokemonSpecies, pokemonGen, type1, type2, pokemonEvo);
	}
	

}
