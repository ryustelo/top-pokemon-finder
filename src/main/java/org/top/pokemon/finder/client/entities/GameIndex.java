package org.top.pokemon.finder.client.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameIndex {

    @JsonProperty("game_index")
    private Integer gameIndex;
    private Version version;
}
