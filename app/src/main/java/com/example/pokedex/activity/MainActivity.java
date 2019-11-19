package com.example.pokedex.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pokedex.R;
import com.example.pokedex.entitites.Pokemon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.pokedex.recylcer_view.DataGenerator;
import com.example.pokedex.recylcer_view.MyDataAdapter;
import com.example.pokedex.recylcer_view.PokemonActionInterface;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements PokemonActionInterface {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyDataAdapter myDataAdapter;
    private Button button;
    private CoordinatorLayout coordinatorLayout;
    private List<Pokemon> pokemonList;
    private Boolean recyclerviewLayout = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pokemon p1 = new Pokemon(1,"pika");
        Pokemon p2 = new Pokemon(2,"sala");
        pokemonList = new ArrayList<>();
        pokemonList.add(p1);
        pokemonList.add(p2);
        coordinatorLayout = findViewById(R.id.coordinator_layout);

        setupRecyclerView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_mode_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_whatshot:
                recyclerViewChangeLayout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void recyclerViewChangeLayout() {
        if (recyclerviewLayout){
            layoutManager = new GridLayoutManager(this.getBaseContext(),2);
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
        myDataAdapter.setViewchoice(false);
        recyclerView.setAdapter(myDataAdapter);

    }

    public void displaySnackBar(String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onPokemonClicked(String pokemonName) {
        displaySnackBar(pokemonName);
        //myDataAdapter.notifyDataSetChanged();
    }
}
