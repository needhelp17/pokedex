package com.example.pokedex.dataRepository.entitites.pokemon;

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
