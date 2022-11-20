package com.pokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserTeam {
	
	private Long userTeamID;
	private int userID;
	private int pokemonTeamID;

}
