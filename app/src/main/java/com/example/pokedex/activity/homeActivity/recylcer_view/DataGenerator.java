package com.example.pokedex.activity.homeActivity.recylcer_view;

import com.example.pokedex.dataRepository.entitites.db.PokemonEntity;
import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static List<PokemonViewModel> generateData(List<Pokemon> pokemons) {
        List<PokemonViewModel> pokemonViewModelList = new ArrayList<>();

        for (Pokemon p : pokemons) {
            pokemonViewModelList.add(new PokemonViewModel(p));
        }
        return pokemonViewModelList;
    }

   /* public static List<PokemonViewModel> generateData2(List<PokemonEntity> pokemons) {
        List<PokemonViewModel> pokemonViewModelList = new ArrayList<>();
        for (PokemonEntity p : pokemons) {
            pokemonViewModelList.add(new PokemonViewModel(p));
        }
        return pokemonViewModelList;
    }*/
}
