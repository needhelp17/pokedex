package com.example.pokedex.presenter;

import android.view.View;

import androidx.annotation.Nullable;

import com.example.pokedex.R;
import com.example.pokedex.activity.homeActivity.MainActivity;
import com.example.pokedex.activity.homeActivity.recylcer_view.DataGenerator;
import com.example.pokedex.dataRepository.Repository;
import com.example.pokedex.dataRepository.Utils.PokemonCalls;
import com.example.pokedex.dataRepository.Utils.PokemonsCalls;
import com.example.pokedex.dataRepository.entitites.Pokemon;

import java.util.List;

public class Presenter extends MainActivity implements PokemonsCalls.Callbacks {

    private Repository repository;
    private List<Pokemon> listPokemon;

    public Presenter(){
        repository = new Repository();
    }
    public int getColorType(String type){
        switch (type) {
            case "grass":
                return R.color.colorGrass;
            case "ghost":
                return R.color.colorGhost;
            case "dark":
                return R.color.colorDark;
            case "poison":
                return R.color.colorPoison;
            case "bug":
                return R.color.colorInsect;
            case "fire":
                return R.color.colorFire;
            case "fairy":
                return R.color.colorFairy;
            case "fighting":
                return R.color.colorFight;
            case "dragon":
                return R.color.colorDragon;
            case "steel":
                return R.color.colorSteel;
            case "ice":
                return R.color.colorIce;
            case "water":
                return R.color.colorWater;
            case "ground":
                return R.color.colorGround;
            case "rock":
                return R.color.colorRock;
            case "flying":
                return R.color.colorFlying;
            case "psychic":
                return R.color.colorPsychik;
            case "electric":
                return R.color.colorElectrik;
           default:
               return R.color.colorNormal;
        }
    }

    public void getPokemonsFirstGen(){
        listPokemon = repository.getPokemons();
        if (listPokemon.size() == 0){
            executeHttpRequestWithRetrofit();
        }
        else {
            this.updateUIWithListOfPokemon(listPokemon);
        }
    }

    private void executeHttpRequestWithRetrofit(){
        PokemonsCalls.fetchPokemonFirstGen( this);
    }


    @Override
    public void onResponse(@Nullable List<Pokemon> pokemon) {
        if (pokemon != null) {
            this.updateUIWithListOfPokemon(pokemon);
        }
    }

    /*@Override
    public void onResponse(@Nullable Pokemon pokemon) {
        if (pokemon!= null){
            pokemonList.add(pokemon);
            myDataAdapter.onBind(DataGenerator.generateData(pokemonList));
        }

    }*/

   /* @Override
    public void onFailure() {
        // 2.2 - When getting error, we update UI
        this.updateUIWhenStopingHTTPRequest("An error happened !");
    }*/


    private void updateUIWithListOfPokemon(List<Pokemon> pokemons){
        for (Pokemon p : pokemons){
            PokemonCalls.fetchPokemonByName(this, p.getName());
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onPreExecute() {
    }

    @Override
    public void doInBackground() { }

    @Override
    public void onPostExecute(String json) {
    }
}
