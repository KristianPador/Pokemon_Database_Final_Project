package com.pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Moves {
	
	private Long moveID;
	private String moveName;
	private MoveType moveType;
	private PokemonType moveElement;
	private int attackPower;
	private int attackPP;

}
