package com.example.pokedex.recylcer_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.pokedex.R;

import java.util.Collections;
import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.PokemonViewHolder> {

    private List<PokemonViewModel> pokemonViewModelList;
    private PokemonActionInterface pokemonActionInterface;
    private Boolean viewchoice = true;

    public Boolean getViewchoice() {
        return viewchoice;
    }

    public void setViewchoice(Boolean viewchoice) {
        this.viewchoice = viewchoice;
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public MyDataAdapter(List<PokemonViewModel> dataset,PokemonActionInterface pokemonActionInterface) {
        pokemonViewModelList = dataset;
        this.pokemonActionInterface = pokemonActionInterface;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MyDataAdapter.PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        //if (getViewchoice()) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recyclerview, parent, false);
            PokemonViewHolder pokemonViewHolder = new PokemonViewHolder(v);
            return pokemonViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.updatePokemon(pokemonViewModelList.get(position));
    }

    // Replace the contents of a view (invoked by the layout manager)
    public void onBind(List<PokemonViewModel> newdataset) {
        pokemonViewModelList.clear();
        Collections.sort(newdataset);
        pokemonViewModelList = newdataset;
        notifyDataSetChanged();

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
        //private PokemonActionInterface pokemonActionInterface;


        public PokemonViewHolder(View v) {
            super(v);
            this.v = v;
            nameTextView = v.findViewById(R.id.namePokemon_textview);
            idTextView = v.findViewById(R.id.idPokemon_textview);
            iconImageView = v.findViewById(R.id.icon_imageview);
            pokemonButton = v.findViewById(R.id.pokemon_button);
            //setupListeners();

        }

        public void updatePokemon(PokemonViewModel pokemonViewModel) {
            nameTextView.setText(pokemonViewModel.getName());
            idTextView.setText(String.valueOf(pokemonViewModel.getId()));
            System.out.println("coucoooooooooooooooooooooooooooooooooooooou" +pokemonViewModel.getImageUrl());
            Glide.with(v)
                    .load(pokemonViewModel.getImageUrl())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(iconImageView);
        }

        /*private void setupListeners(){
            pokemonButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pokemonActionInterface.onPokemonClicked(pokemonViewModel.getName());
                }
            });
        }*/

    }
}