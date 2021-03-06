package com.zackyzhang.mymvpdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeIntents;
import com.zackyzhang.mymvpdemo.mvp.view.activity.MovieDetailsActivity;
import com.zackyzhang.mymvpdemo.mvp.view.activity.MovieListActivity;
import com.zackyzhang.mymvpdemo.mvp.view.activity.SearchMovieActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lei on 2/2/17.
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {

    }

    public void navigateToMovieList(Context context) {
        if (context != null) {
            Intent intentToLaunch = MovieListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToMovieDetails(Context context, int movieId, String backdropImage, Bundle bundle) {
        if (context != null) {
            Intent intentToLaunch = MovieDetailsActivity.getCallingIntent(context, movieId, backdropImage);
            if (bundle != null) {
                context.startActivity(intentToLaunch, bundle);
            } else {
                context.startActivity(intentToLaunch);
            }
        }
    }

    public void navigateToSearch(Context context) {
        if (context != null) {
            Intent intentToLaunch = SearchMovieActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToYouTube(Context context, String videoId) {
        if (context != null) {
            Intent intentToLaunch = YouTubeIntents.createPlayVideoIntentWithOptions(context, videoId, true, true);
            context.startActivity(intentToLaunch);
        }
    }
}
