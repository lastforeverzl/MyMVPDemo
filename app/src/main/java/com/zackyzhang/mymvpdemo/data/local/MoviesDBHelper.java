package com.zackyzhang.mymvpdemo.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lei on 2/16/17.
 */

public class MoviesDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Movies.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String INTEGER_TYPE = " INTEGER";

    private static final String DOUBLE_TYPE = " REAL";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MoviesPersistenceContract.MovieEntry.TABLE_NAME + " (" +
                MoviesPersistenceContract.MovieEntry._ID + TEXT_TYPE + " PRIMARY KEY," +
                MoviesPersistenceContract.MovieEntry.COLUMN_NAME_MOVIE_ID + INTEGER_TYPE + COMMA_SEP +
                MoviesPersistenceContract.MovieEntry.COLUMN_NAME_ORIGINAL_TITLE + TEXT_TYPE + COMMA_SEP +
                MoviesPersistenceContract.MovieEntry.COLUMN_NAME_OVERVIEW + TEXT_TYPE + COMMA_SEP +
                MoviesPersistenceContract.MovieEntry.COLUMN_NAME_POSTER_PATH + TEXT_TYPE + COMMA_SEP +
                MoviesPersistenceContract.MovieEntry.COLUMN_NAME_BACKDROP_PATH + TEXT_TYPE + COMMA_SEP +
                MoviesPersistenceContract.MovieEntry.COLUMN_NAME_VOTE_AVERAGE + DOUBLE_TYPE +
            " )";

    public MoviesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
