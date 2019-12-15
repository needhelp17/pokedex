package com.example.pokedex.dataRepository.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pokedex.dataRepository.entitites.Pokemon;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PokemonTeamDAO {

    @Query("SELECT * from pokemonentity")
    Flowable<List<Pokemon>> loadFavorites();

    @Insert
    public Completable addPokemonToFavorites(Pokemon pokemon);

    @Query("DELETE FROM pokemonentity WHERE id = :id")
    public Completable deletePokemonFromFavorites(String id);

    @Query("SELECT id from pokemonentity")
    Single<List<String>> getFavoriteIdList();
}

