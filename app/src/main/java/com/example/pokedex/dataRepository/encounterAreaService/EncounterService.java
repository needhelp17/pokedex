package com.example.pokedex.dataRepository.encounterAreaService;

import com.example.pokedex.dataRepository.entitites.Pokemon;
import com.example.pokedex.dataRepository.entitites.ResultsPokemons;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EncounterService {

    //https://pokeapi.co/api/v2/pokemon/132/encounters
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @GET("pokemon/{pokemon}/encounters")
    Call<Pokemon> getPokemonByName(@Path("pokemon") String pokemonName);

    @GET("pokemon/{pokemon}/encounters")
    Call<Pokemon> getPokemonById(@Path("pokemon") int pokemonId);

}