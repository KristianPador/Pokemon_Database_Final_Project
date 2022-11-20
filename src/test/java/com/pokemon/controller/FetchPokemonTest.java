package com.pokemon.controller;

import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.pokemon.entity.Evolution;
import com.pokemon.entity.Pokemon;
import com.pokemon.entity.PokemonType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
		"classpath:flyway/migration/Pokemon_Schema.sql",
		"classpath:flyway/migration/Pokemon_Data.sql"},
		config = @SqlConfig(encoding = "utf-8"))

public class FetchPokemonTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;
	
	@Test
	void testThatAListOfPokemonIsReturnedWhenGivenATypeAndGeneration() {
		
		String name = "Bulbasaur";
		PokemonType type1 = PokemonType.GRASS;
		int pokemonGen = 1;
		String uri = 
				String.format("http://localhost:%d/pokemon?name=%s&type1=%s&pokemonGen=%s", serverPort, name, type1, pokemonGen );
		
		ResponseEntity<List<Pokemon>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		List<Pokemon> expected = buildExpected();
		assertThat(response.getBody()).isEqualTo(expected);
		
	}

	protected List<Pokemon> buildExpected() {
		
		List<Pokemon> list = new LinkedList<>();
		
		//@formatter:off
		list.add(Pokemon.builder()
				.pokemonName("Bulbasaur")
				.pokemonSpecies("Seed Pokemon")
				.pokemonGen(1)
				.type1(PokemonType.GRASS)
				.type2(PokemonType.POISON)
				.pokemonEvo(Evolution.NO)
				.build());		
		//@formatter:on
		
		return list;
	}
	
}