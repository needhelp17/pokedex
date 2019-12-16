package com.example.pokedex.presenter;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.pokedex.R;
import com.example.pokedex.activity.homeActivity.HomeActivity;
import com.example.pokedex.dataRepository.PokemonRepository;
import com.example.pokedex.dataRepository.db.PokemonDAO;
import com.example.pokedex.dataRepository.db.PokemonDatabase;
import com.example.pokedex.dataRepository.entitites.db.PokemonEntity;
import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;
import com.example.pokedex.presenter.favorites.FavoritesDataSource;

import java.util.Collection;
import java.util.List;

public class Presenter extends HomeActivity {

    private PokemonRepository repository;
    private FavoritesDataSource favoriService;
    private Context context;

    public Presenter(Application application){
        repository = new PokemonRepository(application);
    }

    public Presenter(Context applicationContext) {
        repository = new PokemonRepository(applicationContext);
    }

    public int getColorType(String type){
        switch (type) {
            case "grass":
                return R.color.colorGrass;
            case "ghost":
                return R.color.colorGhost;
            case "dark":
                return R.color.colorDark;
            case "poison":
                return R.color.colorPoison;
            case "bug":
                return R.color.colorInsect;
            case "fire":
                return R.color.colorFire;
            case "fairy":
                return R.color.colorFairy;
            case "fighting":
                return R.color.colorFight;
            case "dragon":
                return R.color.colorDragon;
            case "steel":
                return R.color.colorSteel;
            case "ice":
                return R.color.colorIce;
            case "water":
                return R.color.colorWater;
            case "ground":
                return R.color.colorGround;
            case "rock":
                return R.color.colorRock;
            case "flying":
                return R.color.colorFlying;
            case "psychic":
                return R.color.colorPsychik;
            case "electric":
                return R.color.colorElectrik;
           default:
               return R.color.colorNormal;
        }
    }

    public void addfavori(int id){
        PokemonEntity pe = new PokemonEntity(id, "coucou", "url");
        repository.insert(pe);
    }

    public List<Integer> getFavoris() {
        return repository.getAllfavoritesPokemons().getValue();
    }
}
