package com.example.pokedex.recylcer_view;

import com.example.pokedex.entitites.Pokemon;

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

}
