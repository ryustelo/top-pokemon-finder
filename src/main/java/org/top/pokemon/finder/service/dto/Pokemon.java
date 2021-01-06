package org.top.pokemon.finder.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Pokemon {

    @JsonProperty("base_experience")
    Integer baseExperience;
    Integer height;
    Integer id;
    @JsonProperty("is_default")
    Boolean isDefault;
    String name;
    Integer order;
    Integer weight;
}
