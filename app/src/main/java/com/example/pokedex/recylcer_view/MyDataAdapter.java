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


    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView idTextView;
        private ImageView iconImageView;
        private ImageButton infoButton;
        private ImageButton pokemonButton;
        private CheckBox selectionCheckbox;
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
            infoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pokemonActionInterface.onPokemonInfoClicked(pokemonViewModel.getName());
                }
            });
            pokemonButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pokemonActionInterface.onPokemonClicked(pokemonViewModel.getName());
                }
            });
        }

        void bind(PokemonViewModel pokemonViewModel, int position, boolean isSelectionMode, boolean isSelected) {
            System.out.println("Selemode ? " + isSelectionMode + " is selected ? " + isSelected);
            if (isSelectionMode) {
                infoButton.setVisibility(View.GONE);
                selectionCheckbox.setVisibility(View.VISIBLE);
                selectionCheckbox.setChecked(isSelected);
            } else {
                infoButton.setVisibility(View.VISIBLE);
                selectionCheckbox.setVisibility(View.GONE);
            }
            this.pokemonViewModel = pokemonViewModel;
            this.position = position;

            nameTextView.setText(pokemonViewModel.getName());
            idTextView.setText(pokemonViewModel.getName());
            iconImageView.setImageResource(R.drawable.rayquaza);
        }

        public ItemDetailsLookup.ItemDetails<String> getItemDetails() {
            return new ItemDetailsLookup.ItemDetails<String>() {
                @Override
                public int getPosition() {
                    return position;
                }

                @Nullable
                @Override
                public String getSelectionKey() {
                    return pokemonViewModel.getUuid();
                }
            };
        }
    }

    private List<PokemonViewModel> pokemonViewModelList;
    private SelectionTracker<String> selectionTracker;
    private boolean isSelectionMode;
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
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent,
                                                int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview, parent, false);
        PokemonViewHolder pokemonViewHolder = new PokemonViewHolder(v, pokemonActionInterface);
        return pokemonViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        holder.bind(pokemonViewModelList.get(position),
                position,
                isSelectionMode,
                selectionTracker.isSelected(pokemonViewModelList.get(position).getUuid()));
    }

    public List<PokemonViewModel> getPokemonViewModelList() {
        return pokemonViewModelList;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return pokemonViewModelList.size();
    }

    public void setSelectionTracker(final SelectionTracker<String> selectionTracker) {
        this.selectionTracker = selectionTracker;
        selectionTracker.addObserver(new SelectionTracker.SelectionObserver() {
            @Override
            public void onItemStateChanged(@NonNull Object key, boolean selected) {
                super.onItemStateChanged(key, selected);
                boolean previousState = isSelectionMode;
                isSelectionMode = !selectionTracker.getSelection().isEmpty();
                if(previousState != isSelectionMode){
                    notifyDataSetChanged();
                }
            }
        });
    }
}