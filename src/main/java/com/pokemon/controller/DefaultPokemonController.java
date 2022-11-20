package com.pokemon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.entity.Evolution;
import com.pokemon.entity.Pokemon;
import com.pokemon.entity.PokemonType;
import com.pokemon.service.PokemonService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPokemonController implements PokemonController {
	
	@Autowired
	private PokemonService pokemonService;

	@Override
	public List<Pokemon> fetchPokemon(String name,PokemonType type1, int pokemonGen) {
		log.info("pokemonName ={}, type1={}, pokemonGen={}", name, type1, pokemonGen);
		return pokemonService.fetchPokemon(name, type1, pokemonGen);
	}

	@Override
	public Optional<Pokemon> createPokemon(String name, String pokemonSpecies, int pokemonGen, PokemonType type1,
			PokemonType type2, Evolution pokemonEvo) {
		log.info("pokemonName ={}, pokemonSpecies ={}, pokemonGen ={}, type1 ={}, type2 ={}, pokemonEvo ={}",
				name, pokemonSpecies, pokemonGen, type1, type2, pokemonEvo);
		return pokemonService.createPokemon(name, pokemonSpecies, pokemonGen, type1, type2, pokemonEvo);
	}

	@Override
	public Optional<Pokemon> updatePokemon(String name, String pokemonSpecies, int pokemonGen, PokemonType type1,
			PokemonType type2, Evolution pokemonEvo) {
		log.info("pokemonName ={}, pokemonSpecies ={}, pokemonGen ={}, type1 ={}, type2 ={}, pokemonEvo ={}",
				name, pokemonSpecies, pokemonGen, type1, type2, pokemonEvo);
		return null;
	}
	
	

}
