package com.example.pokedex.dataRepository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.pokedex.dataRepository.db.PokemonDAO;
import com.example.pokedex.dataRepository.db.PokemonDatabase;
import com.example.pokedex.dataRepository.entitites.db.PokemonEntity;
import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;

import java.util.List;

public class PokemonRepository {

    private PokemonDAO pokemonDAO;

    public PokemonRepository(Application application) {
        PokemonDatabase db = PokemonDatabase.getDatabase(application);
        pokemonDAO = db.pokemonDAO();
    }

    public PokemonRepository(Context applicationContext) {
        PokemonDatabase db = PokemonDatabase.getDatabase(applicationContext);
        pokemonDAO = db.pokemonDAO();
    }

    public LiveData<List<Integer>> getAllfavoritesPokemons() {
        return pokemonDAO.getFavoriteIdList();
    }

    public void insert (PokemonEntity pokemonEntity) {
        new PokemonRepository.insertAsyncTask(pokemonDAO).execute(pokemonEntity);
    }

    private static class insertAsyncTask extends AsyncTask<PokemonEntity, Void, Void> {

        private PokemonDAO mAsyncTaskDao;

        insertAsyncTask(PokemonDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final PokemonEntity... params) {
            mAsyncTaskDao.addPokemonToFavorites(params[0]);
            return null;
        }
    }

    public void deleteAll()  {
        new PokemonRepository.deleteAllAsyncTask(pokemonDAO).execute();
    }





    private static class deleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private PokemonDAO mAsyncTaskDao;

        deleteAllAsyncTask(PokemonDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAllFavorites();
            return null;
        }
    }

    public void deletePokemon(PokemonEntity pokemonEntity)  {
        new PokemonRepository.deletePokemonAsyncTask(pokemonDAO).execute((Runnable) pokemonEntity);
    }




    private static class deletePokemonAsyncTask extends AsyncTask<PokemonEntity, Void, Void> {
        private PokemonDAO mAsyncTaskDao;

        deletePokemonAsyncTask(PokemonDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final PokemonEntity... params) {
            mAsyncTaskDao.deletePokemonFromFavorites(String.valueOf(params[0].getId()));
            return null;
        }
    }

    public void deleteAllPokemons(Integer id_trip)  {
        new PokemonRepository.deleteAllPokemonsAsyncTask(pokemonDAO).execute(id_trip);
    }




    private static class deleteAllPokemonsAsyncTask extends AsyncTask<Integer, Void, Void> {
        private PokemonDAO mAsyncTaskDao;

        deleteAllPokemonsAsyncTask(PokemonDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Integer... params) {
            mAsyncTaskDao.deletePokemonFromFavorites(String.valueOf(params[0]));
            return null;
        }
    }


}
