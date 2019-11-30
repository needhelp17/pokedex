package com.example.pokedex.activity.showPokemon.fragment;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.pokedex.R;
import com.example.pokedex.dataRepository.Utils.NetworkAsyncTask;
import com.example.pokedex.dataRepository.Utils.PokemonCalls;
import com.example.pokedex.entitites.Pokemon;

public class FragmentShowDetails extends Fragment implements NetworkAsyncTask.Listeners, PokemonCalls.CallbacksSimple {

    public static final String TAB_NAME = "Détail";
    private View rootView;
    private boolean front = true;
    private ImageView img;
    private Pokemon p;
    private TextView nameText;
    private TextView idText;
    private TextView descText;
    private ImageView image;

    public FragmentShowDetails(int id) {
        if(id!=0){
            PokemonCalls.fetchPokemonById(this,id);
        }
    }

    public static FragmentShowDetails newInstance(int id) {
        return new FragmentShowDetails(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //rootView = inflater.from(container.getContext()).inflate(R.layout.fragment_preview, null);
        //rootView = inflater.inflate(R.layout.fragment_preview,container, false);
        rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_preview, null);
        nameText = rootView.findViewById(R.id.pokemonName);
        idText = rootView.findViewById(R.id.pokemonId);
        descText = rootView.findViewById(R.id.pokemonDescription);
        image = rootView.findViewById(R.id.pokemonImage);
        return rootView;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        img = rootView.findViewById(R.id.pokemonImage);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(front) {
                    Glide.with(v)
                            .load(p.getSprites().getBackDefault())
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .into(img);
                    front = !front;
                }
                else{
                    Glide.with(v)
                            .load(p.getSprites().getFrontDefault())
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .into(img);
                    front = !front;
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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

    @Override
    public void onResponse(@Nullable Pokemon pokemon) {
        if (pokemon!=null){
            p = pokemon;
            nameText.setText(p.getName());
            idText.setText(String.valueOf(p.getId()));
            descText.setText(p.getLocationAreaEncounters());
            Glide.with(this)
                    .load(p.getSprites().getFrontDefault())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(image);
        }

    }

    @Override
    public void onFailure() {

    }

    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}