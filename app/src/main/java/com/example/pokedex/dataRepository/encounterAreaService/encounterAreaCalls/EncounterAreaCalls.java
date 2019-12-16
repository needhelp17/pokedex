package com.example.pokedex.dataRepository.encounterAreaService.encounterAreaCalls;

import android.app.Activity;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;
import com.example.pokedex.dataRepository.pokemonService.PokemonService;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EncounterAreaCalls {

    public interface Callbacks {
        void onResponse(@Nullable Pokemon pokemon);
        void onFailure();
    }

    public static void fetchPokemonByName(Activity callbacks, String pokemonName){

        final WeakReference<com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonCalls.Callbacks> callbacksWeakReference = new WeakReference<com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonCalls.Callbacks>((com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonCalls.Callbacks) callbacks);
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

    public static void fetchPokemonById(Fragment callbacks, int pokemonId){

        final WeakReference<com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonCalls.Callbacks> callbacksWeakReference = new WeakReference<com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonCalls.Callbacks>((com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonCalls.Callbacks) callbacks);
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
