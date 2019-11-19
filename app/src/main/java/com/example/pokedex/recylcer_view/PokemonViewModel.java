package com.example.pokedex.recylcer_view;

import com.example.pokedex.entitites.Pokemon;

import java.util.UUID;

public class PokemonViewModel {

    private int id;
    private String name;
    private String imageUrl;
    private String uuid;

    public PokemonViewModel(Pokemon p) {
        this.name = p.getName();
        this.id = p.getId();
        this.imageUrl = "coucou";//p.getSprites().getFront_default();
        this.uuid = UUID.randomUUID().toString();
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
