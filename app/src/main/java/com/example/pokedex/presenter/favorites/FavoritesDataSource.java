package com.example.pokedex.presenter.favorites;



import androidx.lifecycle.LiveData;

import com.example.pokedex.dataRepository.db.PokemonDatabase;
import com.example.pokedex.dataRepository.entitites.db.PokemonEntity;

import java.util.List;

import io.reactivex.Completable;

public class FavoritesDataSource {

    private static PokemonDatabase pokemonDatabase;

    public FavoritesDataSource(PokemonDatabase pokemonDatabase) {
        this.pokemonDatabase = pokemonDatabase;
    }

    public LiveData<List<PokemonEntity>> loadFavorites() {
        return pokemonDatabase.pokemonDAO().loadFavorites();
    }

    public void addPokemonToFavorites(PokemonEntity pokemonEntity) {
        pokemonDatabase.pokemonDAO().addPokemonToFavorites(pokemonEntity);
    }

    public void deletePokemonFromFavorites(PokemonEntity pokemonEntity) {
        pokemonDatabase.pokemonDAO().deletePokemonFromFavorites(pokemonEntity);
    }

    public LiveData<List<Integer>> getFavoriteIdList() {
        return pokemonDatabase.pokemonDAO().getFavoriteIdList();
    }
}

