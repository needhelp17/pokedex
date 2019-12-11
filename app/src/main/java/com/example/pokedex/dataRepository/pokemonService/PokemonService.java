package com.example.pokedex.dataRepository.pokemonService;

import com.example.pokedex.dataRepository.entitites.Pokemon;
import com.example.pokedex.dataRepository.entitites.ResultsPokemons;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @GET("pokemon/{pokemon}")
    Call<Pokemon> getPokemonByName(@Path("pokemon") String pokemonName);

    @GET("pokemon/{pokemon}")
    Call<Pokemon> getPokemonById(@Path("pokemon") int pokemonId);

    @GET("pokemon/?offset=0&limit=151")
    Call<ResultsPokemons> getPokemonFirstGen();

}
