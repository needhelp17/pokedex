package com.example.pokedex.dataRepository.entitites;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionDetail implements Serializable
{

    @SerializedName("rarity")
    @Expose
    private int rarity;
    @SerializedName("version")
    @Expose
    private Version_ version;
    private final static long serialVersionUID = -3350529024515007432L;

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public Version_ getVersion() {
        return version;
    }

    public void setVersion(Version_ version) {
        this.version = version;
    }

}