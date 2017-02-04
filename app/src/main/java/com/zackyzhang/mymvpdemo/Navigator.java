package com.zackyzhang.mymvpdemo;

import android.content.Context;
import android.content.Intent;

import com.zackyzhang.mymvpdemo.di.scope.ApplicationScope;
import com.zackyzhang.mymvpdemo.mvp.view.activity.MovieListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lei on 2/2/17.
 * Class used to navigate through the application.
 */
@ApplicationScope
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
}
