package org.top.pokemon.finder.client.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PokemonResourceList {

    private Integer count;
    private String next;
    private String previous;
    private List<PokemonReference> results;
}
