package com.example.pokedex.dataRepository.pokemonService.EncounterCalls;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pokedex.dataRepository.entitites.encounter.Encounter;
import com.example.pokedex.dataRepository.pokemonService.PokemonService;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EncounterCall {

    public interface Callbacks {
        void onResponse(@Nullable List<Encounter> encounter);
        void onFailure();
    }

    public static void fetchEncounter(Fragment callbacks, int pokemonId){
        System.out.println("lancé");
        final WeakReference<EncounterCall.Callbacks> callbacksWeakReference = new WeakReference<EncounterCall.Callbacks>((EncounterCall.Callbacks) callbacks);
        PokemonService pokemonService = PokemonService.retrofit.create(PokemonService.class);
        Call<List<Encounter>> call = pokemonService.getEncounter(pokemonId);
        call.enqueue(new Callback<List<Encounter>>() {

            @Override
            public void onResponse(Call<List<Encounter>> call, Response<List<Encounter>> response) {
                if (callbacksWeakReference.get() != null) {
                    System.out.println("maintenant ici");
                    /*List<Encounter> listencounter = new ArrayList<>();
                    for (int i = 0; i < response.body().getEncounters().size(); i++) {
                        listencounter.add(res);
                    }*/
                    callbacksWeakReference.get().onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Encounter>> call, Throwable t) {
                System.out.println("oups ici");
                if (callbacksWeakReference.get() != null)
                    callbacksWeakReference.get().onFailure();
            }
        });
    }

}
