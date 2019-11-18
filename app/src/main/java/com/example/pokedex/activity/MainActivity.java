package com.example.pokedex.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pokedex.R;
import com.example.pokedex.entitites.Pokemon;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.OnItemActivatedListener;
import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pokedex.recylcer_view.DataGenerator;
import com.example.pokedex.recylcer_view.MyDataAdapter;
import com.example.pokedex.recylcer_view.PokemonActionInterface;
import com.example.pokedex.recylcer_view.PokemonDetailsLookup;
import com.example.pokedex.recylcer_view.PokemonItemKeyProvider;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements PokemonActionInterface {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyDataAdapter myDataAdapter;
    private Button button;
    private CoordinatorLayout coordinatorLayout;
    private List<Pokemon> pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pokemon p1 = new Pokemon(1,"pika");
        Pokemon p2 = new Pokemon(2,"sala");
        pokemonList.add(p1);
        pokemonList.add(p2);

        Toast.makeText(this, pokemonList.size(), Toast.LENGTH_SHORT).show();
        button = findViewById(R.id.button);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.my_recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        myDataAdapter = new MyDataAdapter(this);
        recyclerView.setAdapter(myDataAdapter);

        myDataAdapter.bindViewModels(DataGenerator.generateData(pokemonList));
    }

    public void displaySnackBar(String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onPokemonClicked(String pokemonName) {
        displaySnackBar(pokemonName);
    }
}
