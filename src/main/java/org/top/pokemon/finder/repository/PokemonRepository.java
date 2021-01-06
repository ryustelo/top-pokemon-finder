package org.top.pokemon.finder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.top.pokemon.finder.service.dto.Pokemon;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    List<Pokemon> findAllByOrderByWeightDesc();
}
