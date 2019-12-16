package com.example.pokedex.dataRepository.entitites.encounter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Encounter {
        public LocationArea location_area ;
        public List<VersionDetail> version_details ;

    public Encounter(LocationArea location_area, List<VersionDetail> version_details) {
        this.location_area = location_area;
        this.version_details = version_details;
    }


    public LocationArea getLocation_area() {
        return location_area;
    }

    public void setLocation_area(LocationArea location_area) {
        this.location_area = location_area;
    }

    public List<VersionDetail> getVersion_details() {
        return version_details;
    }

    public void setVersion_details(List<VersionDetail> version_details) {
        this.version_details = version_details;
    }
}