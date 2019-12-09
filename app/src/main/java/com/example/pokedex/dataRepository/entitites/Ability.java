package com.example.pokedex.dataRepository.entitites;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ability implements Serializable
{

    @SerializedName("ability")
    @Expose
    private Ability_ ability;
    @SerializedName("is_hidden")
    @Expose
    private boolean isHidden;
    @SerializedName("slot")
    @Expose
    private int slot;
    private final static long serialVersionUID = 2820569986520541489L;

    public Ability_ getAbility() {
        return ability;
    }

    public void setAbility(Ability_ ability) {
        this.ability = ability;
    }

    public boolean isIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public class Ability_ implements Serializable
    {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;
        private final static long serialVersionUID = -8946023155296949839L;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

}