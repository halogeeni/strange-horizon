package com.arasio.webdev.strangehorizon.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ArtistDTO {

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    public ArtistDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ArtistDTO(ArtistEntity artistEntity) {
        this.id = artistEntity.getId();
        this.name = artistEntity.getName();
        this.description = artistEntity.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
