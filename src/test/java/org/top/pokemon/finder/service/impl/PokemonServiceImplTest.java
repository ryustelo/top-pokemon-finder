package org.top.pokemon.finder.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.top.pokemon.finder.client.PokemonApiClient;
import org.top.pokemon.finder.client.entities.GameIndex;
import org.top.pokemon.finder.client.entities.PokemonResource;
import org.top.pokemon.finder.client.entities.Version;
import org.top.pokemon.finder.repository.PokemonRepository;
import org.top.pokemon.finder.service.dto.Pokemon;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceImplTest {

    private static final int BASE_EXPERIENCE = 64;
    private static final int HEIGHT = 7;
    private static final int RED_VERSIONED_POKEMON_ID = 1;
    private static final int NON_RED_VERSIONED_POKEMON_ID = 2;
    private static final boolean IS_DEFAULT = true;
    private static final String NAME = "pokemon_name";
    private static final int ORDER = 1;
    private static final int WEIGHT = 69;
    private static final int GAME_INDEX = 153;
    private static final String VERSION_RED = "red";
    private static final String VERSION_BLUE = "blue";
    private static final String URL = "https://pokeapi.co/api/v2/version/1/";

    @Mock
    private PokemonApiClient pokemonApiClient;

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonServiceImpl pokemonService;

    @Test
    public void returns_empty_when_api_client_returns_no_pokemons() {
        when(pokemonApiClient.getPokemons()).thenReturn(new ArrayList<>());

        List<Pokemon> result = pokemonService.getPokemonsByWeight();

        assertTrue(result.isEmpty());
    }

    @Test
    public void returns_the_correct_pokemon_when_api_client_returns_one_pokemon() {
        when(pokemonApiClient.getPokemons()).thenReturn(singletonList(aRedVersionedPokemon()));

        List<Pokemon> result = pokemonService.getPokemonsByWeight();

        assertEquals(1, result.size());
        assertEquals(BASE_EXPERIENCE, result.get(0).getBaseExperience());
        assertEquals(HEIGHT, result.get(0).getHeight());
        assertEquals(RED_VERSIONED_POKEMON_ID, result.get(0).getId());
        assertEquals(IS_DEFAULT, result.get(0).getIsDefault());
        assertEquals(NAME, result.get(0).getName());
        assertEquals(WEIGHT, result.get(0).getWeight());
    }

    @Test
    public void returns_empty_when_api_client_returns_one_non_red_versioned_pokemon() {
        when(pokemonApiClient.getPokemons()).thenReturn(singletonList(aNonRedVersionedPokemon()));

        List<Pokemon> result = pokemonService.getPokemonsByWeight();

        assertTrue(result.isEmpty());
    }

    @Test
    public void returns_just_one_pokemon_when_api_client_returns_one_red_and_one_non_red_versioned_pokemon() {
        when(pokemonApiClient.getPokemons()).thenReturn(
                asList(aNonRedVersionedPokemon(), aRedVersionedPokemon()));

        List<Pokemon> result = pokemonService.getPokemonsByWeight();

        assertEquals(1, result.size());
        assertEquals(RED_VERSIONED_POKEMON_ID, result.get(0).getId());
    }

    private PokemonResource aRedVersionedPokemon() {
        return PokemonResource.builder()
                .baseExperience(BASE_EXPERIENCE)
                .height(HEIGHT)
                .id(RED_VERSIONED_POKEMON_ID)
                .isDefault(IS_DEFAULT)
                .name(NAME)
                .order(ORDER)
                .weight(WEIGHT)
                .gameIndices(asList(
                        GameIndex.builder()
                                .gameIndex(GAME_INDEX)
                                .version(aVersion(VERSION_BLUE))
                                .build(),
                        GameIndex.builder()
                                .gameIndex(GAME_INDEX)
                                .version(aVersion(VERSION_RED))
                                .build()))
                .build();
    }

    private PokemonResource aNonRedVersionedPokemon() {
        return PokemonResource.builder()
                .baseExperience(BASE_EXPERIENCE)
                .height(HEIGHT)
                .id(NON_RED_VERSIONED_POKEMON_ID)
                .isDefault(IS_DEFAULT)
                .name(NAME)
                .order(ORDER)
                .weight(WEIGHT)
                .gameIndices(singletonList(
                        GameIndex.builder()
                                .gameIndex(GAME_INDEX)
                                .version(aVersion(VERSION_BLUE))
                                .build()))
                .build();
    }

    private Version aVersion(String versionName) {
        return Version.builder()
                .name(versionName)
                .url(URL)
                .build();
    }
}