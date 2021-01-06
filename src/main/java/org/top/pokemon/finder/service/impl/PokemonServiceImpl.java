package org.top.pokemon.finder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.pokemon.finder.client.PokemonApiClient;
import org.top.pokemon.finder.client.entities.PokemonResource;
import org.top.pokemon.finder.repository.PokemonRepository;
import org.top.pokemon.finder.service.PokemonService;
import org.top.pokemon.finder.service.dto.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.top.pokemon.finder.service.PokemonMapper.map;

@Service
class PokemonServiceImpl implements PokemonService {

    private static final String RED_VERSION_NAME = "red";
    private static final int RESPONSE_SIZE = 5;

    private final PokemonApiClient pokemonApiClient;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonApiClient pokemonApiClient, PokemonRepository pokemonRepository) {
        this.pokemonApiClient = pokemonApiClient;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Pokemon> getPokemonsByWeight() {
        loadPokemonsToRepository();

        return this.pokemonRepository.findAllByOrderByWeightDesc()
                .stream()
                .limit(RESPONSE_SIZE)
                .collect(Collectors.toList());
    }

    @Override
    public List<Pokemon> getPokemonsByHeight() {
        loadPokemonsToRepository();

        return this.pokemonRepository.findAllByOrderByHeightDesc()
                .stream()
                .limit(RESPONSE_SIZE)
                .collect(Collectors.toList());
    }

    @Override
    public List<Pokemon> getPokemonsByBaseExperience() {
        loadPokemonsToRepository();

        return this.pokemonRepository.findAllByOrderByBaseExperienceDesc()
                .stream()
                .limit(RESPONSE_SIZE)
                .collect(Collectors.toList());
    }

    private void loadPokemonsToRepository() {
        List<Pokemon> pokemonList = new ArrayList<>();

        List<PokemonResource> pokemonApiList = this.pokemonApiClient.getPokemons();
        pokemonApiList.stream()
                .filter(p -> p.getGameIndices().stream()
                        .anyMatch((gi -> RED_VERSION_NAME.equals(gi.getVersion().getName()))))
                .forEach(p -> pokemonList.add(map(p)));
        pokemonList.forEach(this.pokemonRepository::save);
    }
}
