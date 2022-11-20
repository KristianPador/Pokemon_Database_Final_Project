DROP TABLE IF EXISTS userteam;
DROP TABLE IF EXISTS pokemonteam;
DROP TABLE IF EXISTS moves;
DROP TABLE IF EXISTS region;
DROP TABLE IF EXISTS pokemon;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
user_id int unsigned NOT NULL AUTO_INCREMENT,
first_name varchar(40) NOT NULL,
last_name varchar(40) NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE pokemon (
pokemon_id int unsigned NOT NULL AUTO_INCREMENT,
pokemon_name varchar(40) NOT NULL,
pokemon_species varchar(45) NOT NULL,
pokemon_generation int NOT NULL,
pokemon_type1 enum('NORMAL','FIRE','WATER','GRASS','FLYING','FIGHTING','POISON','ELECTRIC','GROUND','ROCK','PSYCHIC','ICE','BUG','GHOST','STEEL','DRAGON','DARK','FAIRY') NOT NULL,
pokemon_type2 enum('NORMAL','FIRE','WATER','GRASS','FLYING','FIGHTING','POISON','ELECTRIC','GROUND','ROCK','PSYCHIC','ICE','BUG','GHOST','STEEL','DRAGON','DARK','FAIRY'),
pokemon_evolution enum('YES','NO') NOT NULL,
PRIMARY KEY (pokemon_id)
);

CREATE TABLE region (
region_id int unsigned NOT NULL AUTO_INCREMENT,
region_name varchar(45) NOT NULL,
region_generation int NOT NULL,
PRIMARY KEY (region_id)
);

CREATE TABLE moves (
move_id int unsigned NOT NULL AUTO_INCREMENT,
move_name varchar(45) NOT NULL,
move_type enum ('PHYSICAL', 'SPECIAL', 'STATUS') NOT NULL,
move_element enum('NORMAL','FIRE','WATER','GRASS','FLYING','FIGHTING','POISON','ELECTRIC','GROUND','ROCK','PSYCHIC','ICE','BUG','GHOST','STEEL','DRAGON','DARK','FAIRY') NOT NULL,
attack_power int,
attack_pp int NOT NULL,
PRIMARY KEY (move_id)
);

CREATE TABLE pokemonteam (
pkteam_id int unsigned NOT NULL AUTO_INCREMENT,
pkteam_1 int unsigned NOT NULL,
pkteam_2 int unsigned NOT NULL,
pkteam_3 int unsigned NOT NULL,
pkteam_4 int unsigned NOT NULL,
pkteam_5 int unsigned NOT NULL,
pkteam_6 int unsigned NOT NULL,
PRIMARY KEY (pkteam_id),
FOREIGN KEY (pkteam_1) REFERENCES pokemon (pokemon_id) ON DELETE CASCADE,
FOREIGN KEY (pkteam_2) REFERENCES pokemon (pokemon_id) ON DELETE CASCADE,
FOREIGN KEY (pkteam_3) REFERENCES pokemon (pokemon_id) ON DELETE CASCADE,
FOREIGN KEY (pkteam_4) REFERENCES pokemon (pokemon_id) ON DELETE CASCADE,
FOREIGN KEY (pkteam_5) REFERENCES pokemon (pokemon_id) ON DELETE CASCADE,
FOREIGN KEY (pkteam_6) REFERENCES pokemon (pokemon_id) ON DELETE CASCADE
);

CREATE TABLE userteam(
userteam_id int unsigned NOT NULL AUTO_INCREMENT,
user_fk int unsigned NOT NULL,
pkteam_fk int unsigned NOT NULL,
PRIMARY KEY (userteam_id),
FOREIGN KEY (user_fk) REFERENCES users (user_id) ON DELETE CASCADE,
FOREIGN KEY (pkteam_fk) REFERENCES pokemonteam (pkteam_id) ON DELETE CASCADE
);

-- enum('NORMAL','FIRE','WATER','GRASS','FLYING','FIGHTING','POISON','ELECTRIC','GROUND','ROCK','PSYCHIC','ICE','BUG','GHOST','STEEL','DRAGON','DARK','FAIRY') NOT NULL,--