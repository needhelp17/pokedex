package com.example.pokedex.dataRepository.db;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pokedex.dataRepository.PokemonRepository;
import com.example.pokedex.dataRepository.entitites.db.PokemonEntity;
import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;

import java.util.List;

public class PokemonViewModel extends AndroidViewModel {
    private PokemonRepository mRepository;

    private LiveData<List<Integer>> pokemonListAll;

    public PokemonViewModel (Application application) {
        super(application);
        mRepository = new PokemonRepository(application);
        pokemonListAll = mRepository.getAllfavoritesPokemons();
    }

    public LiveData<List<Integer>> getfavoris() { return pokemonListAll; }

    public void insert(Pokemon pokemon) { mRepository.insert(new PokemonEntity(pokemon)); }

    public void deleteAll() {
        mRepository.deleteAll();
    }

    public void deletePokemon(Pokemon pokemon) {
        PokemonEntity pe = new PokemonEntity(pokemon);
        mRepository.deletePokemon(pe);
    }

}
