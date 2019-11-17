package com.example.pokedex.recylcer_view;

import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonDetailsLookup extends ItemDetailsLookup<String> {

    private final RecyclerView mRecyclerView;

    public PokemonDetailsLookup(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }

    public ItemDetails<String> getItemDetails(MotionEvent e) {
        View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
        if (view != null) {
            RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(view);
            if (holder instanceof MyDataAdapter.PokemonViewHolder) {
                return ((MyDataAdapter.PokemonViewHolder) holder).getItemDetails();
            }
        }
        return null;
    }
}