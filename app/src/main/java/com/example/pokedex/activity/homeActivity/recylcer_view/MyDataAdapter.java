package com.example.pokedex.activity.homeActivity.recylcer_view;

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

public class MyDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PokemonViewModel> pokemonViewModelList;
    private static PokemonActionInterface pokemonActionInterface;
    private Boolean viewchoice = true;


    public Boolean getViewchoice() {
        return viewchoice;
    }

    public void setViewchoice(Boolean viewchoice) {
        this.viewchoice = viewchoice;
        notifyDataSetChanged();
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public MyDataAdapter(List<PokemonViewModel> dataset,PokemonActionInterface pokemonActionInterface) {
        pokemonViewModelList = dataset;
        this.pokemonActionInterface = pokemonActionInterface;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        if (getViewchoice()) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recyclerview, parent, false);
            PokemonViewHolderLinear pokemonViewHolder = new PokemonViewHolderLinear(v);
            return pokemonViewHolder;
        }
        else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recyclerview_grid, parent, false);
            PokemonViewHolderGrid pokemonViewHolder = new PokemonViewHolderGrid(v);
            return pokemonViewHolder;
        }
    }
    @Override
    public int getItemViewType(final int position){
        return getViewchoice() ? R.layout.item_recyclerview:R.layout.item_recyclerview_grid;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getViewchoice()){
            if (holder instanceof PokemonViewHolderLinear) {
                PokemonViewHolderLinear holder1 = (PokemonViewHolderLinear) holder;
                holder1.updatePokemon(pokemonViewModelList.get(position));
            }
        }
        else {
            if (holder instanceof PokemonViewHolderGrid){
                PokemonViewHolderGrid holder1 = (PokemonViewHolderGrid) holder;
                holder1.updatePokemon(pokemonViewModelList.get(position));
            }
        }
    }

    /**
     * @param newdataset
     * for re create the item when the dataset change
     */
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












    public static class PokemonViewHolderLinear extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView idTextView;
        private ImageView iconImageView;
        private ImageButton pokemonButton;
        private View v;
        //private PokemonActionInterface pokemonActionInterface;


        public PokemonViewHolderLinear(View v) {
            super(v);
            this.v = v;
            nameTextView = v.findViewById(R.id.namePokemon_textview);
            idTextView = v.findViewById(R.id.idPokemon_textview);
            iconImageView = v.findViewById(R.id.icon_imageview);
            pokemonButton = v.findViewById(R.id.pokemon_button);
            setupListeners();

        }

        /**
         * to display data of the item
         * @param pokemonViewModel the data to display
         */
        public void updatePokemon(PokemonViewModel pokemonViewModel) {
            nameTextView.setText(pokemonViewModel.getName());
            idTextView.setText(String.valueOf(pokemonViewModel.getId()));
            Glide.with(v)
                    .load(pokemonViewModel.getImageUrl())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(iconImageView);
        }

        /**
         * setup the on click
         */
        private void setupListeners(){
            pokemonButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pokemonActionInterface.onPokemonClicked(nameTextView.getText().toString(),idTextView.getText().toString());
                }
            });
        }

    }








    public static class PokemonViewHolderGrid extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView idTextView;
        private ImageView iconImageView;
        private ImageButton pokemonButton;
        private View v;
        //private PokemonActionInterface pokemonActionInterface;


        public PokemonViewHolderGrid(View v) {
            super(v);
            this.v = v;
            nameTextView = v.findViewById(R.id.namePokemon_textview);
            idTextView = v.findViewById(R.id.idPokemon_textview);
            iconImageView = v.findViewById(R.id.icon_imageview);
            pokemonButton = v.findViewById(R.id.pokemon_button);
            setupListeners();

        }

        /**
         * to display data of the item
         * @param pokemonViewModel the data to display
         */
        public void updatePokemon(PokemonViewModel pokemonViewModel) {
            nameTextView.setText(pokemonViewModel.getName());
            idTextView.setText(String.valueOf(pokemonViewModel.getId()));
            Glide.with(v)
                    .load(pokemonViewModel.getImageUrl())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(iconImageView);
        }


        /**
         * setup the onclick
         */
        private void setupListeners(){
            pokemonButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pokemonActionInterface.onPokemonClicked(nameTextView.getText().toString(),idTextView.getText().toString());
                }
            });
        }

    }
}