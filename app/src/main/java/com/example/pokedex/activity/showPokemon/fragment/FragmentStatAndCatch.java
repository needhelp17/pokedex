package com.example.pokedex.activity.showPokemon.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;
import com.example.pokedex.activity.showPokemon.fragment.recyclerViewEncounter.AdapterEncounter;
import com.example.pokedex.dataRepository.entitites.Encounter;
import com.example.pokedex.dataRepository.pokemonService.EncounterCalls.EncounterCall;
import com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonCalls;
import com.example.pokedex.dataRepository.entitites.Pokemon;
import com.example.pokedex.dataRepository.entitites.Stat;

import java.util.List;

public class FragmentStatAndCatch extends Fragment implements PokemonCalls.Callbacks, EncounterCall.Callbacks{

    public static final String TAB_NAME = "Item";
    private View rootView;
    private TextView attack;
    private TextView defense;
    private TextView speed;
    private TextView hp;
    private TextView attackspe;
    private TextView defensespe;
    private RecyclerView recyclerViewEncounter;
    private Pokemon p;

    public FragmentStatAndCatch(int id) {
        EncounterCall.fetchEncounter(this,id);
        PokemonCalls.fetchPokemonById(this,id);

    }

    public static FragmentStatAndCatch newInstance(int id) {
        return new FragmentStatAndCatch(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_stat_and_catch, container, false);
        attack = rootView.findViewById(R.id.statAttackValue);
        defense = rootView.findViewById(R.id.statDefenseValue);
        speed = rootView.findViewById(R.id.statSpeedValue);
        hp = rootView.findViewById(R.id.statHpValue);
        defensespe = rootView.findViewById(R.id.statSpeAttackValue);
        attackspe = rootView.findViewById(R.id.statSpeDefenseValue);
        recyclerViewEncounter = rootView.findViewById(R.id.recyclerViewEncounter);
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
           for (Stat s : p.getStats()){
               switch (s.getStat().getName()){
                   case "attack":
                       attack.setText(String.valueOf(s.getBaseStat()));
                       break;
                   case "defense":
                       defense.setText(String.valueOf(s.getBaseStat()));
                       break;
                   case "speed":
                       speed.setText(String.valueOf(s.getBaseStat()));
                       break;
                   case "hp":
                       hp.setText(String.valueOf(s.getBaseStat()));
                       break;
                   case "special-defense":
                       defensespe.setText(String.valueOf(s.getBaseStat()));
                       break;
                   case "special-attack":
                       attackspe.setText(String.valueOf(s.getBaseStat()));
                       break;
               }
           }
        }
    }
    public void reload(int id){
        PokemonCalls.fetchPokemonById(this,id);
    }

    @Override
    public void onResponse(@Nullable List<Encounter> encounters) {
        System.out.println("t'es ici frere");
        AdapterEncounter adapterEncounter = new AdapterEncounter(encounters);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerViewEncounter.setAdapter(adapterEncounter);
        recyclerViewEncounter.setLayoutManager(layoutManager);
        /*TextView tv = getActivity().findViewById(R.id.textView5);
        if (encounters.size()!=0){
            String text = String.valueOf(encounters.size())+"  example : "+encounters.get(0).location_area.name;
            tv.setText(text);
        }
        else
            tv.setText("nowhere");*/
    }

    @Override
    public void onFailure() {
    }

}
