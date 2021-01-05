package org.top.pokemon.finder.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @GetMapping("/weight")
    public ResponseEntity getOrderByWeight(){
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
