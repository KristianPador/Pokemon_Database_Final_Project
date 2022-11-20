package com.pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PokemonTeam {
	
	private Long pkTeamID;
	private int pkTeam1;
	private int pkTeam2;
	private int pkTeam3;
	private int pkTeam4;
	private int pkTeam5;
	private int pkTeam6;

}
