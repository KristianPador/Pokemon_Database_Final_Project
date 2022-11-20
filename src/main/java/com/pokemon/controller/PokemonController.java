package com.pokemon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pokemon.entity.Evolution;
import com.pokemon.entity.Pokemon;
import com.pokemon.entity.PokemonType;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/pokemon")
@OpenAPIDefinition(info = @Info(title = "Pokemon Database Service"), servers = {
			@Server(url = "http://localhost:8080", description = "Local server.")})
public interface PokemonController {
	
	
	//@formatter:off
	@Operation(
			summary = "Returns a Pokemon",
			description = "Returns a list of Pokemon given a type and generation",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "A list of Pokemon is returned",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Pokemon.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No Pokemon were found with that criteria",
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occured",
							content = @Content(
									mediaType = "application/json"))
			},
			parameters = {
					@Parameter(
							name = "name",
							allowEmptyValue = false,
							required = false,
							description = "The name of the Pokemon"),
					@Parameter(
							name = "type1",
							allowEmptyValue = false,
							required = false,
							description = "A Pokemon type(i.e Grass)"),
					@Parameter(
							name = "pokemonGen",
							allowEmptyValue = false,
							required = false,
							description = "A Generation number")
			}
		)
		
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Pokemon> fetchPokemon(
			@RequestParam(required = false)
			String name,
			@RequestParam(required = false)
			PokemonType type1,
			@RequestParam(required = false)
			int pokemonGen);
	//@formatter:on
	
	//@formatter:off
	@Operation(
			summary = "Creates a new Pokemon",
			description = "Creates a new Pokemon Entity ",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "A New Pokemon is created",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Pokemon.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "Pokemon could not be created with that criteria",
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occured",
							content = @Content(
									mediaType = "application/json"))
			},
			parameters = {
					@Parameter(
							name = "name",
							allowEmptyValue = false,
							required = false,
							description = "Enter Pokemon Name"),
					@Parameter(
							name = "pokemonSpecies",
							allowEmptyValue = false,
							required = false,
							description = "Enter Pokemon Species"),
					@Parameter(
							name = "pokemonGen",
							allowEmptyValue = false,
							required = false,
							description = "Enter the Generation the Pokemon was introduced"),
					@Parameter(
							name = "type1",
							allowEmptyValue = false,
							required = false,
							description = "Enter the Pokemon type"),
					@Parameter(
							name = "type2",
							allowEmptyValue = true,
							required = false,
							description = "Enter a second type (if any)"),
					@Parameter(
							name = "pokemonEvo",
							allowEmptyValue = false,
							required = false,
							description = "Determine if the Pokemon is an Evolution of another")
			}
		)
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<Pokemon> createPokemon(
			@RequestParam(required = false)
			String name,
			@RequestParam(required = false)
			String pokemonSpecies,
			@RequestParam(required = false)
			int pokemonGen,
			@RequestParam(required = false)
			PokemonType type1,
			@RequestParam(required = false)
			PokemonType type2,
			@RequestParam(required = false)
			Evolution pokemonEvo);
	//@formatter:on
	
	
	//@formatter:off
	@Operation(
			summary = "Update Pokemon",
			description = "Update a Pokemon Entity ",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "A Pokemon is updated",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Pokemon.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "Pokemon could not be updated with that criteria",
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occured",
							content = @Content(
									mediaType = "application/json"))
			},
			parameters = {
					@Parameter(
							name = "name",
							allowEmptyValue = false,
							required = false,
							description = "Enter Pokemon Name"),
					@Parameter(
							name = "pokemonSpecies",
							allowEmptyValue = false,
							required = false,
							description = "Enter Pokemon Species"),
					@Parameter(
							name = "pokemonGen",
							allowEmptyValue = false,
							required = false,
							description = "Enter the Generation the Pokemon was introduced"),
					@Parameter(
							name = "type1",
							allowEmptyValue = false,
							required = false,
							description = "Enter the Pokemon type"),
					@Parameter(
							name = "type2",
							allowEmptyValue = true,
							required = false,
							description = "Enter a second type (if any)"),
					@Parameter(
							name = "pokemonEvo",
							allowEmptyValue = false,
							required = false,
							description = "Determine if the Pokemon is an Evolution of another")
			}
		)
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<Pokemon> updatePokemon(
			@RequestParam(required = false)
			String name,
			@RequestParam(required = false)
			String pokemonSpecies,
			@RequestParam(required = false)
			int pokemonGen,
			@RequestParam(required = false)
			PokemonType type1,
			@RequestParam(required = false)
			PokemonType type2,
			@RequestParam(required = false)
			Evolution pokemonEvo);
	//@formatter:on
}
