package com.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com"})
@EnableAutoConfiguration (exclude = { DataSourceAutoConfiguration.class })
public class PokemonDatabase {

	public static void main(String[] args) {

		SpringApplication.run(PokemonDatabase.class, args);
		
	}

}
