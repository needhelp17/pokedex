package com.example.pokedex.recylcer_view;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemKeyProvider;


import java.util.List;

public class PokemonItemKeyProvider extends ItemKeyProvider<String> {

    private MyDataAdapter myDataAdapter;

    public PokemonItemKeyProvider(int scope, MyDataAdapter myDataAdapter) {
        super(scope);
        this.myDataAdapter = myDataAdapter;
    }

    @Nullable
    @Override
    public String getKey(int position) {
        return myDataAdapter.getPokemonViewModelList().get(position).getUuid();
    }

    @Override
    public int getPosition(@NonNull String key) {
        for (PokemonViewModel pokemonViewModel : myDataAdapter.getPokemonViewModelList()) {
            if (key.equals(pokemonViewModel.getUuid())) {
                return myDataAdapter.getPokemonViewModelList().indexOf(pokemonViewModel);
            }
        }
        return -1;
    }
}