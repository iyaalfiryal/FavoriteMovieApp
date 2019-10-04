package com.firyal.favoritemovieapp.data;

import android.content.Context;

import com.firyal.favoritemovieapp.model.Movie;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Movie.class, version = 1)
public abstract class DatabaseMovie extends RoomDatabase {
    public abstract MovieDao movieDao();
    private static DatabaseMovie databaseMovie;

    public static DatabaseMovie getDatabaseMovie(Context context){
        synchronized (DatabaseMovie.class){
            if (databaseMovie == null){
                databaseMovie = Room.databaseBuilder(context, DatabaseMovie.class, "db_movie").allowMainThreadQueries().build();

            }
        }
        return databaseMovie;
    }
}
