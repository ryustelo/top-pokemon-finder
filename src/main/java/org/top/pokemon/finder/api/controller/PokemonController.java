package org.top.pokemon.finder.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.top.pokemon.finder.service.PokemonService;
import org.top.pokemon.finder.service.dto.Pokemon;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/weight")
    public ResponseEntity<List<Pokemon>> getPokemonsByWeight() {
        return new ResponseEntity<>(
                pokemonService.getPokemonsByWeight(),
                HttpStatus.OK);
    }
}
