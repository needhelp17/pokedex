package com.example.pokedex.activity.showPokemon.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pokedex.R;
import com.example.pokedex.dataRepository.Utils.NetworkAsyncTask;
import com.example.pokedex.dataRepository.Utils.PokemonCalls;
import com.example.pokedex.dataRepository.entitites.HeldItem;
import com.example.pokedex.dataRepository.entitites.Pokemon;

public class FragmentItemHeld extends Fragment implements  PokemonCalls.CallbacksSimple{

    public static final String TAB_NAME = "Item";
    private View rootView;
    private TextView tv;
    private Pokemon p;

    public FragmentItemHeld(int id) {
        PokemonCalls.fetchPokemonById(this,id);
    }

    public static FragmentItemHeld newInstance(int id) {
        return new FragmentItemHeld(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_item, container, false);
        tv = rootView.findViewById(R.id.item);
        return rootView;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResponse(@Nullable Pokemon pokemon) {
        if (pokemon!=null) {
            p = pokemon;
            String str = "";
            for (HeldItem i : p.getHeldItems()) {
                str.concat(i.getItem().getName()+" ");
            }
            tv.setText(str);
        }
    }

    @Override
    public void onFailure() {

    }
}
