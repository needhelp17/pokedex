/*
package com.example.pokedex.entitites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {


    private int id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("sprite")
    @Expose
    public Sprites sprites;

    @SerializedName("name")
    @Expose
    public List<Ability> abilities;

    @SerializedName("height")
    @Expose
    public int height;

    @SerializedName("is_default")
    @Expose
    public Boolean is_default;

    @SerializedName("location_area_encounters")
    @Expose
    public String location_area_encounters;

    @SerializedName("order")
    @Expose
    public int order;

    @SerializedName("species")
    @Expose
    public Species species;

    @SerializedName("types")
    @Expose
    public List<Type> types;

    @SerializedName("weight")
    @Expose
    public int weight;

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
        this.abilities = null;
        this.height = 0;
        this.is_default = false;
        this.location_area_encounters = "here";
        this.order = 0;
        this.species = null;
        this.sprites = null;
        this.types = null;
        this.weight = 1;
    }

    public Pokemon(List<Ability> abilities, int height, int id, Boolean is_default, String location_area_encounters, String name, int order, Species species, Sprites sprites, List<Type> types, int weight) {
        this.abilities = abilities;
        this.height = height;
        this.id = id;
        this.is_default = is_default;
        this.location_area_encounters = location_area_encounters;
        this.name = name;
        this.order = order;
        this.species = species;
        this.sprites = sprites;
        this.types = types;
        this.weight = weight;
    }

    public class Ability2
    {
        public String name;
        public String url;
    }

    public class Ability
    {
        public Ability2 ability;
        public Boolean is_hidden;
        public int slot;
    }

    public class Form
    {
        public String name;
        public String url;
    }



    public class Move2
    {
        public String name;
        public String url;
    }

    public class MoveLearnMethod
    {
        public String name;
        public String url;
    }

    public class VersionGroup
    {
        public String name;
        public String url;
    }

    public class VersionGroupDetail
    {
        public int level_learned_at;
        public MoveLearnMethod move_learn_method;
        public VersionGroup version_group;
    }

    public class Move
    {
        public Move2 move;
        public List<VersionGroupDetail> version_group_details;
    }

    public class Species
    {
        public String name;
        public String url;
    }


    public class Type2
    {
        public String name;
        public String url;
    }

    public class Type
    {
        public int slot;
        public Type2 type;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public void setIs_default(Boolean is_default) {
        this.is_default = is_default;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public void setLocation_area_encounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
*/


package com.example.pokedex.entitites;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon implements Serializable
{

    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = null;
    @SerializedName("base_experience")
    @Expose
    private int baseExperience;
    @SerializedName("forms")
    @Expose
    private List<Form> forms = null;
    @SerializedName("game_indices")
    @Expose
    private List<GameIndex> gameIndices = null;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("held_items")
    @Expose
    private List<HeldItem> heldItems = null;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("is_default")
    @Expose
    private boolean isDefault;
    @SerializedName("location_area_encounters")
    @Expose
    private String locationAreaEncounters;
    @SerializedName("moves")
    @Expose
    private List<Move> moves = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("order")
    @Expose
    private int order;
    @SerializedName("species")
    @Expose
    private Species species;
    @SerializedName("sprites")
    @Expose
    private Sprites sprites;
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = null;
    @SerializedName("types")
    @Expose
    private List<Type> types = null;
    @SerializedName("weight")
    @Expose
    private int weight;
    private String url;
    private final static long serialVersionUID = -1330833194130587846L;


    public Pokemon(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Pokemon(List<Ability> abilities, int baseExperience, List<Form> forms, List<GameIndex> gameIndices, int height, List<HeldItem> heldItems, int id, boolean isDefault, String locationAreaEncounters, List<Move> moves, String name, int order, Species species, Sprites sprites, List<Stat> stats, List<Type> types, int weight) {
        this.abilities = abilities;
        this.baseExperience = baseExperience;
        this.forms = forms;
        this.gameIndices = gameIndices;
        this.height = height;
        this.heldItems = heldItems;
        this.id = id;
        this.isDefault = isDefault;
        this.locationAreaEncounters = locationAreaEncounters;
        this.moves = moves;
        this.name = name;
        this.order = order;
        this.species = species;
        this.sprites = sprites;
        this.stats = stats;
        this.types = types;
        this.weight = weight;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<HeldItem> getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(List<HeldItem> heldItems) {
        this.heldItems = heldItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
