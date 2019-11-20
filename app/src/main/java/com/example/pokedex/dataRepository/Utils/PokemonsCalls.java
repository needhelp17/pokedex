package com.example.pokedex.dataRepository.Utils;

import androidx.annotation.Nullable;

import com.example.pokedex.dataRepository.PokemonService;
import com.example.pokedex.entitites.Pokemon;
import com.example.pokedex.entitites.ResultsPokemons;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonsCalls {

    // 1 - Creating a callback
    public interface Callbacks {
        void onResponse(@Nullable List<Pokemon> result);

        void onFailure();
    }

    public static void fetchPokemonFirstGen(PokemonsCalls.Callbacks callbacks) {

        // 2.1 - Create a weak reference to callback (avoid memory leaks)
        final WeakReference<PokemonsCalls.Callbacks> callbacksWeakReference = new WeakReference<>(callbacks);

        // 2.2 - Get a Retrofit instance and the related endpoints
        final PokemonService pokemonService = PokemonService.retrofit.create(PokemonService.class);

        // 2.3 - Create the call on Github API
        Call<ResultsPokemons> call = pokemonService.getPokemonFirstGen();
        // 2.4 - Start the call
        call.enqueue(new Callback<ResultsPokemons>() {

            @Override
            public void onResponse(Call<ResultsPokemons> call, Response<ResultsPokemons> response) {
                // 2.5 - Call the proper callback used in controller (MainFragment)
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
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }
}
