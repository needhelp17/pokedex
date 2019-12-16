
package com.example.pokedex.dataRepository.entitites.pokemon;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameIndex implements Serializable
{

    @SerializedName("game_index")
    @Expose
    private int gameIndex;
    @SerializedName("version")
    @Expose
    private Version version;
    private final static long serialVersionUID = -9154234506320580787L;

    public int getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

}