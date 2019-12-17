package com.example.pokedex.activity.homeActivity.recylcer_view;

import com.example.pokedex.dataRepository.entitites.db.PokemonEntity;
import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;

import java.util.UUID;

public class PokemonViewModel implements Comparable{

    private int id;
    private String name;
    private String imageUrl;
    private String uuid;

    public PokemonViewModel(Pokemon p){
        this.name = p.getName();
        this.id = p.getId();
        this.imageUrl = p.getSprites().getFrontDefault();
        this.uuid = UUID.randomUUID().toString();
    }

   /* public PokemonViewModel(PokemonEntity p){
        this.name = p.getName();
        this.id = p.getId()+1;
        this.imageUrl = p.getImg();
        this.uuid = UUID.randomUUID().toString();
    }*/

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

    @Override
    public int compareTo(Object o) {
        if (o instanceof PokemonViewModel) {
            return getId()-((PokemonViewModel) o).getId() ;
        }
        else {
            return 0;
        }

    }
}
