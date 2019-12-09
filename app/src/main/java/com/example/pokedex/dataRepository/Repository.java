package com.example.pokedex.dataRepository;

import android.widget.Toast;

import com.example.pokedex.dataRepository.entitites.Pokemon;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    public List<Pokemon> getPokemons(){
        try{
            JsonReader reader = new JsonReader(new InputStreamReader(
                    new FileInputStream("data/pokemons.json")));
            JsonParser jsonParser = new JsonParser();
            JsonObject pokemonArray = jsonParser.parse(reader).getAsJsonObject();
            JsonArray pokemonArrayAsJsonArray = pokemonArray.getAsJsonArray("pokemons");
            List<Pokemon> pokemons = new ArrayList<>();
            Gson myGson = new Gson();
            for (JsonElement pokemon : pokemonArrayAsJsonArray) {
                System.out.println(pokemon);
                Pokemon poke = myGson.fromJson(pokemon, Pokemon.class);
                pokemons.add(poke);
            }
            return pokemons;
        } catch (FileNotFoundException e) {
            return new ArrayList<Pokemon>();
        }
    }

}
