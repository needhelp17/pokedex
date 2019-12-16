package com.example.pokedex.dataRepository.entitites.db;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PokemonEntity {
    @NonNull
    @PrimaryKey
    private int id;
    private String name;
    private String img;

    public PokemonEntity(int id, String name, String img) {
        id = id;
        name = name;
        img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
