package org.top.pokemon.finder.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.top.pokemon.finder.client.PokemonApiClient;
import org.top.pokemon.finder.client.entities.PokemonResource;
import org.top.pokemon.finder.client.entities.PokemonResourceList;

import java.util.ArrayList;
import java.util.List;

@Component
class PokemonApiClientImpl implements PokemonApiClient {

    private final RestTemplate restTemplate;
    private final String apiPath;

    @Autowired
    public PokemonApiClientImpl(RestTemplateBuilder builder,
                                @Value("${pokeapi.pokemon.resources.path}") String url) {
        this.restTemplate = builder.build();
        this.apiPath = url;
    }

    @Override
    public List<PokemonResource> getPokemons() {
        List<PokemonResource> pokemonsList = new ArrayList<>();

        final PokemonResourceList pokemonResourceList =
                this.restTemplate.getForObject(apiPath, PokemonResourceList.class);
        pokemonResourceList.getResults().forEach(p ->
                pokemonsList.add(this.restTemplate.getForObject(p.getUrl(), PokemonResource.class)));
        return pokemonsList;
    }
}
