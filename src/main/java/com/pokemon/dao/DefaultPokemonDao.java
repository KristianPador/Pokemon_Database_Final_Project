package com.pokemon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.pokemon.entity.Evolution;
import com.pokemon.entity.Pokemon;
import com.pokemon.entity.PokemonType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPokemonDao implements PokemonDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Pokemon> fetchPokemon(String name,PokemonType type1, int pokemonGen) {
		log.info("DAO: pokemonName={} type1={}, pokemonGen={}", name, type1, pokemonGen);
		
		//@formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM pokemon "
				+ "WHERE pokemon_name = :pokemon_name AND pokemon_type1 = :pokemon_type1 AND pokemon_generation = :pokemon_generation";
		//@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("pokemon_name", name);
		params.put("pokemon_type1", type1.toString());
		params.put("pokemon_generation", pokemonGen);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
				//@formatter:off
				return Pokemon.builder()
						.pokemonID(rs.getLong("pokemon_id"))
						.pokemonName(rs.getString("pokemon_name"))
						.pokemonSpecies(rs.getString("pokemon_species"))
						.pokemonGen(rs.getInt("pokemon_generation"))
						.type1(PokemonType.valueOf(rs.getString("pokemon_type1")))
						.type2(PokemonType.valueOf(rs.getString("pokemon_type2")))
						.pokemonEvo(Evolution.valueOf(rs.getString("pokemon_evolution")))
						.build();
				//@formatter:on
			}});
	}

	@Override
	public Optional<Pokemon> createPokemon(String name, String pokemonSpecies, int pokemonGen, PokemonType type1,
			PokemonType type2, Evolution pokemonEvo) {
		
		log.info("DAO: pokemonName={}, pokemonSpecies={}, pokemonGen={}, type1={}, type2={}, pokemonEvo={}", name, pokemonSpecies, pokemonGen, type1, type2, pokemonEvo);
		
		//@formatter:off
		String sql = " "
				+ "INSERT INTO pokemon "
				+ "(pokemon_name, pokemon_species, pokemon_generation, pokemon_type1, pokemon_type2, pokemon_evolution) VALUES "
				+ "(:pokemon_name, :pokemon_species, :pokemon_generation, :pokemon_type1, :pokemon_type2, :pokemon_evolution)";
		//@formatter:on
		
		Map<String, Object> params = allParamsToHashMap(name, pokemonSpecies, pokemonGen, type1, type2, pokemonEvo);
		
		jdbcTemplate.update(sql, params);
		
		return Optional.ofNullable(Pokemon.builder()
				.pokemonName(name)
				.pokemonSpecies(pokemonSpecies)
				.pokemonGen(pokemonGen)
				.type1(type1)
				.type2(type2)
				.pokemonEvo(pokemonEvo)
				.build());
	}


	@Override
	public Optional<Pokemon> updatePokemon(String name, String pokemonSpecies, int pokemonGen, PokemonType type1,
			PokemonType type2, Evolution pokemonEvo) {
		log.info("DAO: pokemonName={}, pokemonSpecies={}, pokemonGen={}, type1={}, type2={}, pokemonEvo={}", pokemonSpecies, pokemonGen, type1, type2, pokemonEvo);

		//@formatter:off
		String sql = " "
				+ "UPDATE pokemon "
				+ "SET pokemon_species = :pokemon_species, pokemon_generation = :pokemon_generation, pokemon_type1 = :pokemon_type1, "
				+ "pokemone_type2 = :pokemon_type2, pokemon_evolution = :pokemon_evolution "
				+ "WHERE pokemon_name = :pokemon_name";
		return Optional.ofNullable(Pokemon.builder()
				.pokemonName(name)
				.pokemonSpecies(pokemonSpecies)
				.pokemonGen(pokemonGen)
				.type1(type1)
				.type2(type2)
				.pokemonEvo(pokemonEvo)
				.build());
	}
	
	private Map<String, Object> allParamsToHashMap(String name, String pokemonSpecies, int pokemonGen, PokemonType type1,
			PokemonType type2, Evolution pokemonEvo) {
		Map<String, Object> params = new HashMap<>();
		params.put("pokemon_name", name);
		params.put("pokemon_species", pokemonSpecies);
		params.put("pokemon_generation", pokemonGen);
		params.put("pokemon_type1", type1);
		params.put("pokemon_type2", type2);
		params.put("pokemon_evolution", pokemonEvo);
		return params;
	}
	

}
