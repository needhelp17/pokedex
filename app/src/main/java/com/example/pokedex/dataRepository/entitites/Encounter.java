package com.example.pokedex.dataRepository.entitites;

import java.util.ArrayList;
import java.util.List;

public class Encounter {
        public LocationArea location_area ;
        public List<VersionDetailEncounter> version_details ;

    public Encounter(LocationArea location_area, List<VersionDetailEncounter> version_details) {
        this.location_area = location_area;
        this.version_details = version_details;
    }


    public LocationArea getLocation_area() {
        return location_area;
    }

    public void setLocation_area(LocationArea location_area) {
        this.location_area = location_area;
    }

    public List<VersionDetailEncounter> getVersion_details() {
        return version_details;
    }

    public void setVersion_details(List<VersionDetailEncounter> version_details) {
        this.version_details = version_details;
    }
}