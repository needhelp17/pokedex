package com.example.pokedex.presenter;

import com.example.pokedex.R;
import com.example.pokedex.activity.homeActivity.HomeActivity;
import com.example.pokedex.dataRepository.Repository;

public class Presenter extends HomeActivity {

    private Repository repository;

    public Presenter(){
        repository = new Repository();
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

}
