package org.top.pokemon.finder.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

    @JsonProperty("base_experience")
    Integer baseExperience;
    Integer height;
    @Id
    Integer id;
    @JsonProperty("is_default")
    Boolean isDefault;
    String name;
    Integer weight;
}
