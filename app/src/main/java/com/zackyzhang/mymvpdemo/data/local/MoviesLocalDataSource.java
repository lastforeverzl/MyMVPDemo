package com.zackyzhang.mymvpdemo.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zackyzhang.mymvpdemo.data.entity.MovieDetails.MovieEntity;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.data.local.MoviesPersistenceContract.MovieEntry;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import timber.log.Timber;

/**
 * Created by lei on 2/16/17.
 */
@Singleton
public class MoviesLocalDataSource {

    private MoviesDBHelper mDBHelper;

    public MoviesLocalDataSource(Context context) {
        mDBHelper = new MoviesDBHelper(context);
    }

    public List<NowPlayingMovie> getMovies() {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();

        List<NowPlayingMovie> movies = new ArrayList<>();

        String[] projection = {
                MovieEntry.COLUMN_NAME_MOVIE_ID,
                MovieEntry.COLUMN_NAME_ORIGINAL_TITLE,
                MovieEntry.COLUMN_NAME_VOTE_AVERAGE,
                MovieEntry.COLUMN_NAME_POSTER_PATH,
                MovieEntry.COLUMN_NAME_BACKDROP_PATH,
                MovieEntry.COLUMN_NAME_OVERVIEW
        };

        Cursor cursor = db.query(MovieEntry.TABLE_NAME, projection, null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(MovieEntry.COLUMN_NAME_MOVIE_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(MovieEntry.COLUMN_NAME_ORIGINAL_TITLE));
                String overview = cursor.getString(cursor.getColumnIndexOrThrow(MovieEntry.COLUMN_NAME_OVERVIEW));
                String posterPath = cursor.getString(cursor.getColumnIndexOrThrow(MovieEntry.COLUMN_NAME_POSTER_PATH));
                String backdropPath = cursor.getString(cursor.getColumnIndexOrThrow(MovieEntry.COLUMN_NAME_BACKDROP_PATH));
                double voteAverage = cursor.getDouble(cursor.getColumnIndexOrThrow(MovieEntry.COLUMN_NAME_VOTE_AVERAGE));
                NowPlayingMovie movie = new NowPlayingMovie(id, title, overview, posterPath, backdropPath, voteAverage);
                movies.add(movie);
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return movies;
    }

    public void saveMovie(MovieEntity movie) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MovieEntry.COLUMN_NAME_MOVIE_ID, movie.getId());
        values.put(MovieEntry.COLUMN_NAME_ORIGINAL_TITLE, movie.getOriginalTitle());
        values.put(MovieEntry.COLUMN_NAME_OVERVIEW, movie.getOverview());
        values.put(MovieEntry.COLUMN_NAME_POSTER_PATH, movie.getPosterPath());
        values.put(MovieEntry.COLUMN_NAME_BACKDROP_PATH, movie.getBackdropPath());
        values.put(MovieEntry.COLUMN_NAME_VOTE_AVERAGE, movie.getVoteAverage());

        db.insert(MovieEntry.TABLE_NAME, null, values);
        Timber.tag("DBtest").d("movie saved");
        db.close();
    }

    public void deleteMovie(int movieId, String movieTitle) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        String selection = MovieEntry.COLUMN_NAME_MOVIE_ID + " = ? AND "
                + MovieEntry.COLUMN_NAME_ORIGINAL_TITLE + " = ?";
        String[] selectionArgs = { String.valueOf(movieId), movieTitle };

        db.delete(MovieEntry.TABLE_NAME, selection, selectionArgs);
        Timber.tag("DBtest").d("movie deleted");
        db.close();
    }

    public boolean isMovieExist(int movieId) {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();

        String[] projection = {
                MovieEntry.COLUMN_NAME_MOVIE_ID,
                MovieEntry.COLUMN_NAME_ORIGINAL_TITLE
        };
        String selection = MovieEntry.COLUMN_NAME_MOVIE_ID + " = ?";
        String[] selectionArgs = { String.valueOf(movieId) };

        Cursor cursor = db.query(MovieEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
            db.close();
            return true;
        } else {
            cursor.close();
            db.close();
            return false;
        }
    }

}
