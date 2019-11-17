package com.example.pokedex.entitites;

import java.util.List;

public class Pokemon {

    public List<Ability> abilities;
    public int base_experience;
    public List<Form> forms ;
    public List<GameIndice> game_indices ;
    public int height;
    public List<HeldItem> held_items;
    public int id;
    public Boolean is_default;
    public String location_area_encounters;
    public List<Move> moves;
    public String name;
    public int order;
    public Species species;
    public Sprites sprites;
    public List<Stat> stats;
    public List<Type> types;
    public int weight;

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
        this.abilities = null;
        this.base_experience = 0;
        this.forms = null;
        this.game_indices =null;
        this.height = 0;
        this.held_items = null;
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

    public Pokemon(List<Ability> abilities, int base_experience, List<Form> forms, List<GameIndice> game_indices, int height, List<HeldItem> held_items, int id, Boolean is_default, String location_area_encounters, List<Move> moves, String name, int order, Species species, Sprites sprites, List<Stat> stats, List<Type> types, int weight) {
        this.abilities = abilities;
        this.base_experience = base_experience;
        this.forms = forms;
        this.game_indices = game_indices;
        this.height = height;
        this.held_items = held_items;
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

    public class Sprites
    {
        public String back_default;
        public String back_female;
        public String back_shiny;
        public String back_shiny_female;
        public String front_default;
        public String front_female;
        public String front_shiny;
        public String front_shiny_female;

        public String getBack_default() {
            return back_default;
        }

        public void setBack_default(String back_default) {
            this.back_default = back_default;
        }

        public String getBack_female() {
            return back_female;
        }

        public void setBack_female(String back_female) {
            this.back_female = back_female;
        }

        public String getBack_shiny() {
            return back_shiny;
        }

        public void setBack_shiny(String back_shiny) {
            this.back_shiny = back_shiny;
        }

        public String getBack_shiny_female() {
            return back_shiny_female;
        }

        public void setBack_shiny_female(String back_shiny_female) {
            this.back_shiny_female = back_shiny_female;
        }

        public String getFront_default() {
            return front_default;
        }

        public void setFront_default(String front_default) {
            this.front_default = front_default;
        }

        public String getFront_female() {
            return front_female;
        }

        public void setFront_female(String front_female) {
            this.front_female = front_female;
        }

        public String getFront_shiny() {
            return front_shiny;
        }

        public void setFront_shiny(String front_shiny) {
            this.front_shiny = front_shiny;
        }

        public String getFront_shiny_female() {
            return front_shiny_female;
        }

        public void setFront_shiny_female(String front_shiny_female) {
            this.front_shiny_female = front_shiny_female;
        }
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

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<GameIndice> getGame_indices() {
        return game_indices;
    }

    public void setGame_indices(List<GameIndice> game_indices) {
        this.game_indices = game_indices;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<HeldItem> getHeld_items() {
        return held_items;
    }

    public void setHeld_items(List<HeldItem> held_items) {
        this.held_items = held_items;
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
