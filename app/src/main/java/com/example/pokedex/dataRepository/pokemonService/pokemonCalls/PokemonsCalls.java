package com.example.pokedex.dataRepository.pokemonService.pokemonCalls;

import androidx.annotation.Nullable;

import com.example.pokedex.dataRepository.entitites.Pokemon;
import com.example.pokedex.dataRepository.entitites.ResultsPokemons;
import com.example.pokedex.dataRepository.pokemonService.PokemonService;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonsCalls {

    public interface Callbacks {
        void onResponse(@Nullable List<Pokemon> result);
        void onFailure();
    }

    public static void fetchPokemonFirstGen(PokemonsCalls.Callbacks callbacks) {

        final WeakReference<PokemonsCalls.Callbacks> callbacksWeakReference = new WeakReference<>(callbacks);
        final PokemonService pokemonService = PokemonService.retrofit.create(PokemonService.class);
        Call<ResultsPokemons> call = pokemonService.getPokemonFirstGen();
        call.enqueue(new Callback<ResultsPokemons>() {

            @Override
            public void onResponse(Call<ResultsPokemons> call, Response<ResultsPokemons> response) {
                if (callbacksWeakReference.get() != null) {
                    List<Pokemon> listpoke = new ArrayList<>();
                    for (int i = 0; i < response.body().getResults().size(); i++) {
                        Pokemon p = new Pokemon(i+1,response.body().getResults().get(i).getName());
                        listpoke.add(p);
                    }
                    callbacksWeakReference.get().onResponse(listpoke);
                }
            }

            @Override
            public void onFailure(Call<ResultsPokemons> call, Throwable t) {
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }
}
