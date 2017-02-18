package com.zackyzhang.mymvpdemo.data.local;

import android.provider.BaseColumns;

/**
 * Created by lei on 2/16/17.
 */

public final class MoviesPersistenceContract {

    private MoviesPersistenceContract() {
    }

    public static abstract class MovieEntry implements BaseColumns {
        public static final String TABLE_NAME = "movie";
        public static final String COLUMN_NAME_MOVIE_ID = "movieid";
        public static final String COLUMN_NAME_POSTER_PATH = "posterPath";
        public static final String COLUMN_NAME_BACKDROP_PATH = "backdropPath";
        public static final String COLUMN_NAME_OVERVIEW = "overview";
        public static final String COLUMN_NAME_ORIGINAL_TITLE = "originalTitle";
        public static final String COLUMN_NAME_VOTE_AVERAGE = "voteAverage";
    }
}