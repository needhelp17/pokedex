package com.example.pokedex.activity.showPokemon.fragment.recyclerViewEncounter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;
import com.example.pokedex.dataRepository.entitites.encounter.Encounter;
import com.example.pokedex.dataRepository.entitites.encounter.EncounterDetail;
import com.example.pokedex.dataRepository.entitites.encounter.VersionDetail;

import java.util.ArrayList;
import java.util.List;

public class AdapterEncounter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Encounter> encounterList;

    public AdapterEncounter(List<Encounter> encounters) {
        encounterList = encounters;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_encounter_recyclerview, parent, false);
        AdapterEncounter.EncounterViewHolder encounterViewHolder = new AdapterEncounter.EncounterViewHolder(v);
        return encounterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((EncounterViewHolder) holder).update(encounterList.get(position));
    }

    @Override
    public int getItemCount() {
        return encounterList.size();
    }

    private class EncounterViewHolder extends RecyclerView.ViewHolder{

        private View v;
        private TextView version;
        private TextView chance;
        private TextView level;
        private TextView road;
        private TextView method;

        public EncounterViewHolder(@NonNull View v) {
            super(v);
            this.v = v;
            version = v.findViewById(R.id.version);
            chance = v.findViewById(R.id.chance);
            level = v.findViewById(R.id.level);
            road = v.findViewById(R.id.road);
            method = v.findViewById(R.id.method);
        }

        /**
         * to update the item with the data of encounter
         * @param encounter
         */
        public void update(Encounter encounter){
            road.setText("road : "+encounter.getLocation_area().name.replace("-"," "));
            List<String> versions = new ArrayList<>();
            int max_chance=0;
            int min_level = 101;
            int max_level = 0;
            List<String> method_capture = new ArrayList<>();
            for (VersionDetail ve : encounter.getVersion_details()){
                versions.add(ve.getVersion().getName());
                if (max_chance < ve.getMax_chance()) {
                    max_chance = ve.getMax_chance();
                }
                EncounterDetail ed = ve.getEncounterDetail().get(0);
                    if (ve.getEncounterDetail()!= null) {
                        if (min_level > ed.getMin_level()) {
                            min_level = ed.getMin_level();
                        }
                        if (max_level < ed.getMax_level()) {
                            max_level = ed.getMax_level();
                        }
                        if (!method_capture.contains(ed.getMethod().getName())) {
                            method_capture.add(ed.getMethod().getName());
                        }
                    }
                }
            if (versions.size()==0){
                version.setText("");
            }
            else{
                String res="";
                for (String s: versions){
                    res+=s+" / ";
                }
                version.setText(res.substring(0,res.length()-2));
            }
            chance.setText("chance : "+max_chance+"%");
            if (min_level==max_level)
                level.setText("level : "+min_level);
            else
                level.setText("level "+min_level+" to "+max_level);

            if (method_capture.size()==0){
                method.setText("");
            }
            else{
                String res="";
                for (String s: method_capture){
                    res+=s+" / ";
                }
                method.setText(res.substring(0,res.length()-2));
            }
        }
    }
}
