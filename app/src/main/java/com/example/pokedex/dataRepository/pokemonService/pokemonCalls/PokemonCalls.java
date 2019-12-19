package com.example.pokedex.dataRepository.pokemonService.pokemonCalls;

import android.app.Activity;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;
import com.example.pokedex.dataRepository.pokemonService.PokemonService;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonCalls {

    public interface Callbacks {
        void onResponse(@Nullable Pokemon pokemon);
        void onFailure();
    }

    /**
     * get pokemon
     * @param callbacks the callback to launch
     * @param pokemonName the name of the pokemon
     */
    public static void fetchPokemonByName(Activity callbacks, String pokemonName){

        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>((Callbacks) callbacks);
        PokemonService pokemonService = PokemonService.retrofit.create(PokemonService.class);
        Call<Pokemon> call = pokemonService.getPokemonByName(pokemonName);
        call.enqueue(new Callback<Pokemon>() {

            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (callbacksWeakReference.get() != null)
                    callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                if (callbacksWeakReference.get() != null)
                    callbacksWeakReference.get().onFailure();
            }
        });
    }

    /**
     * get pokemon
     * @param callbacks the callback to launch
     * @param pokemonId the id of the pokemon
     */
    public static void fetchPokemonById(Fragment callbacks, int pokemonId){

        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>((Callbacks) callbacks);
        PokemonService pokemonService = PokemonService.retrofit.create(PokemonService.class);
        Call<Pokemon> call = pokemonService.getPokemonById(pokemonId);
        call.enqueue(new Callback<Pokemon>() {

            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (callbacksWeakReference.get() != null)
                    callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                if (callbacksWeakReference.get() != null)
                    callbacksWeakReference.get().onFailure();
            }
        });
    }
}
