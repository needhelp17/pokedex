package com.example.pokedex.dataRepository.db;


import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.pokedex.dataRepository.entitites.db.PokemonEntity;

import io.reactivex.annotations.NonNull;

@Database(entities = {PokemonEntity.class}, version = 2)
public abstract class PokemonDatabase extends RoomDatabase {
    public abstract PokemonDAO pokemonDAO();

    private static volatile PokemonDatabase INSTANCE;

    public static PokemonDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PokemonDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PokemonDatabase.class, "pokemon_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PokemonDAO pokeDao;

        PopulateDbAsync(PokemonDatabase db) {
            pokeDao = db.pokemonDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            return null;
        }
    }
}
