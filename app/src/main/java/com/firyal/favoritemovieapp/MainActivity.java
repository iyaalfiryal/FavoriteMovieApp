package com.firyal.favoritemovieapp;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.firyal.favoritemovieapp.adapter.AdapterMovie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    public static final String AUTHORITY = "com.firyal.moviecatalogue";
    public static final Uri URI_MOVIE = Uri.parse("content://" + AUTHORITY + "/" + "tb_movie");
    private static final int LOADER = 1;

    RecyclerView rv;
    private AdapterMovie adapterMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        if (savedInstanceState != null) {
            adapterMovie = new AdapterMovie();
            rv.setHasFixedSize(true);
            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rv.setAdapter(adapterMovie);

            this.getSupportLoaderManager().initLoader(LOADER, null, mloaderCallback);

        }
    }

    private LoaderManager.LoaderCallbacks<Cursor> mloaderCallback
            = new LoaderManager.LoaderCallbacks<Cursor>() {
        @NonNull
        @Override
        public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
            switch (id) {
                case LOADER:
                    return new CursorLoader(
                            MainActivity.this,
                            URI_MOVIE,
                            null,
                            null,
                            null,
                            null);


                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override
        public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
            Log.e("DATASET", "MONMON");
            switch (loader.getId()){
                case LOADER:
                    adapterMovie.setmCursor(data);
                    break;
            }
        }

        @Override
        public void onLoaderReset(@NonNull Loader<Cursor> loader) {
            switch (loader.getId()){
                case LOADER:
                    adapterMovie.setmCursor(null);
                    break;
            }
        }
    };
}