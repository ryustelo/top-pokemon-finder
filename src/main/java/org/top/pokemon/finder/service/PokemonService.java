package org.top.pokemon.finder.service;

import org.top.pokemon.finder.service.dto.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getPokemonsByWeight();

    List<Pokemon>  getPokemonsByHeight();
}
