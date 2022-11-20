package com.pokemon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Pokemon {
	private Long pokemonID;
	private String pokemonName;
	private String pokemonSpecies;
	private int pokemonGen;
	private PokemonType type1;
	private PokemonType type2;
	private Evolution pokemonEvo;
	
	@JsonIgnore
	public Long getPokemonID() {
		return pokemonID;
	}
}
