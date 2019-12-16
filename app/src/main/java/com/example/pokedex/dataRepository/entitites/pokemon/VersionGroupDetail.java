package com.example.pokedex.dataRepository.entitites.pokemon;

import java.io.Serializable;

import com.example.pokedex.dataRepository.entitites.pokemon.MoveLearnMethod;
import com.example.pokedex.dataRepository.entitites.pokemon.VersionGroup;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionGroupDetail implements Serializable
{

    @SerializedName("level_learned_at")
    @Expose
    private int levelLearnedAt;
    @SerializedName("move_learn_method")
    @Expose
    private MoveLearnMethod moveLearnMethod;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;
    private final static long serialVersionUID = -217326307213528066L;

    public int getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public void setLevelLearnedAt(int levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

}