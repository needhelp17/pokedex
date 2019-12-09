package com.example.pokedex.dataRepository.entitites;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type implements Serializable
{

    @SerializedName("slot")
    @Expose
    private int slot;
    @SerializedName("type")
    @Expose
    private Type_ type;
    private final static long serialVersionUID = -8953387272701574522L;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type_ getType() {
        return type;
    }

    public void setType(Type_ type) {
        this.type = type;
    }

}