package com.example.pokedex.recylcer_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.pokedex.R;


import java.util.ArrayList;
import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.PokemonViewHolder> {

    private List<PokemonViewModel> pokemonViewModelList;
    private PokemonActionInterface pokemonActionInterface;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyDataAdapter(PokemonActionInterface pokemonActionInterface) {
        pokemonViewModelList = new ArrayList<>();
        this.pokemonActionInterface = pokemonActionInterface;
    }

    public void bindViewModels(List<PokemonViewModel> pokemonViewModelList) {
        this.pokemonViewModelList.clear();
        this.pokemonViewModelList.addAll(pokemonViewModelList);
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview, parent, false);
        PokemonViewHolder pokemonViewHolder = new PokemonViewHolder(v, pokemonActionInterface);
        return pokemonViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        holder.idTextView.setText(pokemonViewModelList.get(position).getId());
        holder.nameTextView.setText(pokemonViewModelList.get(position).getName());
        holder.iconImageView.setImageResource(R.drawable.rayquaza);
        holder.setupListeners();
    }

    public List<PokemonViewModel> getPokemonViewModelList() {
        return pokemonViewModelList;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return pokemonViewModelList.size();
    }


    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView idTextView;
        private ImageView iconImageView;
        private ImageButton pokemonButton;
        private View v;
        private PokemonViewModel pokemonViewModel;
        private int position;
        private PokemonActionInterface pokemonActionInterface;


        public PokemonViewHolder(View v, final PokemonActionInterface pokemonActionInterface) {
            super(v);
            this.v = v;
            nameTextView = v.findViewById(R.id.namePokemon_textview);
            idTextView = v.findViewById(R.id.idPokemon_textview);
            iconImageView = v.findViewById(R.id.icon_imageview);
            pokemonButton = v.findViewById(R.id.pokemon_button);
            this.pokemonActionInterface = pokemonActionInterface;
            setupListeners();

        }

        private void setupListeners(){
            pokemonButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pokemonActionInterface.onPokemonClicked(pokemonViewModel.getName());
                }
            });
        }

    }
}