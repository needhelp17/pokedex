package com.example.pokedex.activity.homeActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;

import com.example.pokedex.R;
import com.example.pokedex.activity.showPokemon.PokemonShowActivity;
import com.example.pokedex.dataRepository.db.PokemonViewModel;
import com.example.pokedex.dataRepository.entitites.db.PokemonEntity;
import com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonCalls;
import com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonsCalls;
import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pokedex.activity.homeActivity.recylcer_view.DataGenerator;
import com.example.pokedex.activity.homeActivity.recylcer_view.MyDataAdapter;
import com.example.pokedex.activity.homeActivity.recylcer_view.PokemonActionInterface;
import com.example.pokedex.presenter.Presenter;
import com.google.android.material.snackbar.Snackbar;

public class HomeActivity extends AppCompatActivity implements PokemonActionInterface, PokemonsCalls.Callbacks, PokemonCalls.Callbacks {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyDataAdapter myDataAdapter;
    private Button button;
    private ConstraintLayout layout;
    private List<Pokemon> pokemonList;
    private List<Pokemon> list_fav;
    private Boolean recyclerviewLayout = true;
    private TextView textView;
    private boolean is_on_fav = false;
    //private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        //presenter = new Presenter(/*this*/);
        pokemonList = new ArrayList<>();
        list_fav = new ArrayList<>();
        textView = findViewById(R.id.textView);
        layout = findViewById(R.id.coordinator_layout);
        executeHttpRequestWithRetrofit();
        setupRecyclerView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_mode_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_layout:
                if(item.getTitle() == "List") {
                    item.setIcon(getResources().getDrawable(R.drawable.icon_grid));
                    item.setTitle("Grid");
                }
                else {
                    item.setIcon(getResources().getDrawable(R.drawable.icon_list));
                    item.setTitle("List");
                }
                recyclerViewChangeLayout();
                return true;
            case R.id.menu_favorite:
                if(is_on_fav){
                    item.setIcon(getResources().getDrawable(R.drawable.favorite_default_white));
                    item.setTitle("Fav");
                }
                else{
                    item.setIcon(getResources().getDrawable(R.drawable.favorite_fill_white));
                    item.setTitle("All");
                }
                is_on_fav = !is_on_fav;
                changeData(item.getTitle().toString());
        }
        return super.onOptionsItemSelected(item);
    }


    private void changeData(String type){
        if (type.equals("All")){
            PokemonViewModel pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
            pokemonViewModel.getfavoris().observe(this, new Observer<List<Integer>>() {
                @Override
                public void onChanged(List<Integer> list) {
                    list_fav.clear();
                    for(Pokemon p : pokemonList){
                        if (list.contains(p.getId())){
                            list_fav.add(p);
                        }
                    }
                    myDataAdapter.onBind(DataGenerator.generateData(list_fav));
                    //recyclerView.setAdapter(myDataAdapter);
                }
            });
        }
        else{
            myDataAdapter.onBind(DataGenerator.generateData(pokemonList));
           // recyclerView.setAdapter(myDataAdapter);
        }
    }

    private void recyclerViewChangeLayout() {
        if (recyclerviewLayout){
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                layoutManager = new GridLayoutManager(this.getBaseContext(), 4);
            }else {
                layoutManager = new GridLayoutManager(this.getBaseContext(), 2);
            }
        }
        else{
            layoutManager = new LinearLayoutManager(this.getBaseContext());
        }
        recyclerviewLayout = !recyclerviewLayout;
        myDataAdapter.setViewchoice(recyclerviewLayout);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.my_recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getBaseContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        myDataAdapter = new MyDataAdapter(DataGenerator.generateData(pokemonList),this);
        recyclerView.setAdapter(myDataAdapter);

    }

    public void displaySnackBar(String message) {
        Snackbar.make(layout, message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onPokemonClicked(String pokemonName,String id_string) {
        int id = Integer.valueOf(id_string);
        Intent showPoke = new Intent(this, PokemonShowActivity.class);
        showPoke.putExtra("id",id);
        showPoke.putExtra("name",pokemonName);
        showPoke.putExtra("is_fav",is_on_fav);
        startActivity(showPoke);
        //myDataAdapter.notifyDataSetChanged();
    }


    private void executeHttpRequestWithRetrofit(){
        this.updateUIWhenStartingHTTPRequest();
        //PokemonCalls.fetchPokemonByName(this, "charizard");
        PokemonsCalls.fetchPokemonFirstGen( this);
    }

    // 2 - Override callback methods

    @Override
    public void onResponse(@Nullable List<Pokemon> pokemon) {
        // 2.1 - When getting response, we update UI
        if (pokemon != null) {
            pokemonList.clear();
            this.updateUIWithListOfPokemon(pokemon);
        }
    }

    @Override
    public void onResponse(@Nullable Pokemon pokemon) {
        if (pokemon!= null){
            pokemonList.add(pokemon);
            myDataAdapter.onBind(DataGenerator.generateData(pokemonList));
        }

    }

    @Override
    public void onFailure() {
        // 2.2 - When getting error, we update UI
        this.updateUIWhenStopingHTTPRequest("An error happened !");
    }
    // 3 - Update UI showing only name of users
    private void updateUIWithListOfPokemon(List<Pokemon> pokemon){
        for (Pokemon p : pokemon){
            PokemonCalls.fetchPokemonByName(this, p.getName());
        }
        updateUIWhenfinishHTTPRequest(pokemon);
    }

    private void updateUIWhenStopingHTTPRequest(String message) {
        this.textView.setText(message);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void updateUIWhenStartingHTTPRequest(){
        this.textView.setText("Downloading...");
    }

    private void updateUIWhenfinishHTTPRequest(List<Pokemon> response) {
        this.textView.setText("done");
        this.textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestart() {
        displaySnackBar("list : "+myDataAdapter.getItemCount());
        System.out.println(is_on_fav);
        changeData(is_on_fav?"All":"Fav");
        super.onRestart();
    }
}
