package com.example.pokedex.dataRepository.Utils;

import androidx.annotation.Nullable;

import com.example.pokedex.entitites.Pokemon;

import java.util.List;

public interface Callbacks {
    void onResponse();
    void onFailure();
}
