package com.example.pokedex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.pokedex.R;
import com.example.pokedex.dataRepository.Utils.NetworkAsyncTask;
import com.example.pokedex.dataRepository.Utils.PokemonCalls;
import com.example.pokedex.entitites.Pokemon;
import com.google.android.material.snackbar.Snackbar;


public class PokemonShowActivity extends AppCompatActivity implements  NetworkAsyncTask.Listeners, PokemonCalls.CallbacksSimple {
    private int id;
    private String name;
    private TextView nameText;
    private TextView idText;
    private TextView descText;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_preview);
        Intent i = getIntent();
        id = i.getIntExtra("id",0);
        name = i.getStringExtra("name");
        nameText = findViewById(R.id.pokemonName);
        idText = findViewById(R.id.pokemonId);
        descText = findViewById(R.id.pokemonDescription);
        image = findViewById(R.id.pokemonImage);
        PokemonCalls.fetchPokemonById(this,id);

    }

    @Override
    public void onResponse(@Nullable Pokemon pokemon) {
        if (pokemon!=null){
            nameText.setText(pokemon.getName());
            idText.setText(String.valueOf(pokemon.getId()));
            descText.setText(pokemon.getLocationAreaEncounters());
            Glide.with(this)
                    .load(pokemon.getSprites().getFrontDefault())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(image);
        }

    }

    public void displaySnackBar(String message) {
        Snackbar.make(findViewById(R.id.fragment_preview),message,Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onFailure() {
        displaySnackBar("fail");
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void onPostExecute(String success) {

    }
}
