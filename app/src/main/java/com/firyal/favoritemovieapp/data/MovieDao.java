package com.firyal.favoritemovieapp.data;

import android.database.Cursor;

import com.firyal.favoritemovieapp.model.Movie;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM tb_movie WHERE id = :id")
    Cursor selectItem(long id);

    @Query("SELECT * FROM tb_movie")
    Cursor getFavoriteMovie();

    @Query("SELECT * FROM tb_movie")
    List<Movie> getFavorite();

    @Query("SELECT * FROM tb_movie WHERE  id = :id")
    Movie selectItem(String id);

}
