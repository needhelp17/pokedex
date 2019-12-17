package com.example.pokedex.dataRepository.entitites.encounter;

import com.example.pokedex.dataRepository.entitites.pokemon.Version;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VersionDetail {

    private Version version;
    private int max_chance;
    @SerializedName("encounter_details")
    private List<EncounterDetail> encounter_Details;

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public int getMax_chance() {
        return max_chance;
    }

    public void setMax_chance(int max_chance) {
        this.max_chance = max_chance;
    }

    public List<EncounterDetail> getEncounterDetail() {
        return encounter_Details;
    }

    public void setEncounterDetail(List<EncounterDetail> encounterDetail) {
        this.encounter_Details = encounterDetail;
    }
}
