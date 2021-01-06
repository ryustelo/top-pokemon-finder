package org.top.pokemon.finder.service;

import org.top.pokemon.finder.client.entities.PokemonResource;
import org.top.pokemon.finder.service.dto.Pokemon;

public class PokemonMapper {

    public static Pokemon map(PokemonResource pokemonResource){
        return Pokemon.builder()
                .baseExperience(pokemonResource.getBaseExperience())
                .height(pokemonResource.getHeight())
                .id(pokemonResource.getId())
                .isDefault(pokemonResource.getIsDefault())
                .name(pokemonResource.getName())
                .order(pokemonResource.getOrder())
                .weight(pokemonResource.getWeight())
                .build();
    }
}
