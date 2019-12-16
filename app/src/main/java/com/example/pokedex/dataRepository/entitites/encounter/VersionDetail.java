package com.example.pokedex.dataRepository.entitites.encounter;

import com.example.pokedex.dataRepository.entitites.pokemon.Version;

public class VersionDetail {

    private Version version;
    private int max_chance;
    private EncounterDetail encounterDetail;

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

    public EncounterDetail getEncounterDetail() {
        return encounterDetail;
    }

    public void setEncounterDetail(EncounterDetail encounterDetail) {
        this.encounterDetail = encounterDetail;
    }
}
