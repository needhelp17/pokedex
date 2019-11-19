package com.example.pokedex.entitites;

import java.util.List;

public class Pokemon {

    private int id;
    public String name;
    public Sprites sprites;
    public List<Ability> abilities;
    public int height;
    public Boolean is_default;
    public String location_area_encounters;
    public List<Move> moves;
    public int order;
    public Species species;
    public List<Stat> stats;
    public List<Type> types;
    public int weight;

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
        this.abilities = null;
        this.height = 0;
        this.is_default = false;
        this.location_area_encounters = "here";
        this.moves = null;
        this.order = 0;
        this.species = null;
        this.sprites = null;
        this.stats = null;
        this.types = null;
        this.weight = 1;
    }

    public Pokemon(List<Ability> abilities, int height, List<HeldItem> held_items, int id, Boolean is_default, String location_area_encounters, List<Move> moves, String name, int order, Species species, Sprites sprites, List<Stat> stats, List<Type> types, int weight) {
        this.abilities = abilities;
        this.height = height;
        this.id = id;
        this.is_default = is_default;
        this.location_area_encounters = location_area_encounters;
        this.moves = moves;
        this.name = name;
        this.order = order;
        this.species = species;
        this.sprites = sprites;
        this.stats = stats;
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

    public class Version
    {
        public String name;
        public String url;
    }

    public class GameIndice
    {
        public int game_index;
        public Version version;
    }

    public class Item
    {
        public String name;
        public String url;
    }

    public class Version2
    {
        public String name;
        public String url;
    }

    public class VersionDetail
    {
        public int rarity;
        public Version2 version;
    }

    public class HeldItem
    {
        public Item item;
        public List<VersionDetail> version_details;
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

    public class Stat2
    {
        public String name;
        public String url;
    }

    public class Stat
    {
        public int base_stat;
        public int effort;
        public Stat2 stat;
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
