package com.example.pokedex.dataRepository.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pokedex.dataRepository.entitites.db.PokemonEntity;
import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PokemonDAO {

    @Query("SELECT * from pokemonentity")
    LiveData<List<PokemonEntity>> loadFavorites();

    @Insert
    public void addPokemonToFavorites(PokemonEntity pokemon);

    @Delete
    public void deletePokemonFromFavorites(PokemonEntity pokemon);

    @Query("DELETE FROM pokemonentity")
    public Completable deleteAllFavorites();

    @Query("SELECT id from pokemonentity")
    LiveData<List<Integer>> getFavoriteIdList();
}

