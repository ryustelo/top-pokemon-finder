package org.top.pokemon.finder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.pokemon.finder.client.PokemonApiClient;
import org.top.pokemon.finder.client.entities.PokemonResource;
import org.top.pokemon.finder.service.PokemonService;
import org.top.pokemon.finder.service.dto.Pokemon;

import java.util.ArrayList;
import java.util.List;

import static org.top.pokemon.finder.service.PokemonMapper.map;

@Service
class PokemonServiceImpl implements PokemonService {

    private static final String RED_VERSION_NAME = "red";

    private final PokemonApiClient pokemonApiClient;

    @Autowired
    public PokemonServiceImpl(PokemonApiClient pokemonApiClient) {
        this.pokemonApiClient = pokemonApiClient;
    }

    @Override
    public List<Pokemon> getPokemonsByWeight() {
        List<Pokemon> pokemonListByWeight = new ArrayList<>();

        List<PokemonResource> pokemonList = pokemonApiClient.getPokemons();
        pokemonList.stream()
                .filter(p -> p.getGameIndices().stream()
                        .anyMatch((gi -> RED_VERSION_NAME.equals(gi.getVersion().getName()))))
                .forEach(p -> pokemonListByWeight.add(map(p)));
        return pokemonListByWeight;
    }
}
