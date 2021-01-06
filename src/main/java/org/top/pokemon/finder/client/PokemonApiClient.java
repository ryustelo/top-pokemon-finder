package org.top.pokemon.finder.client;

import org.top.pokemon.finder.client.entities.PokemonResource;

import java.util.List;

public interface PokemonApiClient {

    List<PokemonResource> getPokemons();
}
