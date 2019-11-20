package com.example.pokedex.entitites;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stat implements Serializable
{

    @SerializedName("base_stat")
    @Expose
    private int baseStat;
    @SerializedName("effort")
    @Expose
    private int effort;
    @SerializedName("stat")
    @Expose
    private Stat_ stat;
    private final static long serialVersionUID = -2184867309149400114L;

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public Stat_ getStat() {
        return stat;
    }

    public void setStat(Stat_ stat) {
        this.stat = stat;
    }

}