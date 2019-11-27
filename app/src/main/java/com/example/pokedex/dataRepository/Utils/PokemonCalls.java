package com.example.pokedex.dataRepository.Utils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pokedex.activity.MainActivity;
import com.example.pokedex.dataRepository.PokemonService;
import com.example.pokedex.entitites.Pokemon;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonCalls {

    // 1 - Creating a callback
    public interface CallbacksSimple {
        void onResponse(@Nullable Pokemon pokemon);
        void onFailure();
    }

    // 2 - Public method to start fetching users following by Jake Wharton
    public static void fetchPokemonByName(MainActivity callbacks, String pokemonName){

        // 2.1 - Create a weak reference to callback (avoid memory leaks)
        final WeakReference<CallbacksSimple> callbacksWeakReference = new WeakReference<CallbacksSimple>(callbacks);

        // 2.2 - Get a Retrofit instance and the related endpoints
        PokemonService pokemonService = PokemonService.retrofit.create(PokemonService.class);

        // 2.3 - Create the call on Github API
        Call<Pokemon> call = pokemonService.getPokemonByName(pokemonName);
        // 2.4 - Start the call
        call.enqueue(new Callback<Pokemon>() {

            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }

    public static void fetchPokemonById(Fragment callbacks, int pokemonId){

        // 2.1 - Create a weak reference to callback (avoid memory leaks)
        final WeakReference<CallbacksSimple> callbacksWeakReference = new WeakReference<CallbacksSimple>((CallbacksSimple) callbacks);

        // 2.2 - Get a Retrofit instance and the related endpoints
        PokemonService pokemonService = PokemonService.retrofit.create(PokemonService.class);

        // 2.3 - Create the call on Github API
        Call<Pokemon> call = pokemonService.getPokemonById(pokemonId);
        // 2.4 - Start the call
        call.enqueue(new Callback<Pokemon>() {

            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }
}
