package com.zackyzhang.mymvpdemo.di.module;

import com.zackyzhang.mymvpdemo.di.scope.PerActivity;
import com.zackyzhang.mymvpdemo.mvp.MovieListView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lei on 1/30/17.
 */
//
//@Module
//public class MoviesModule {
//
//    private MovieListView mView;
//
//    public MoviesModule(MovieListView mainView) {
//        mView = mainView;
//    }
//
//    @PerActivity
//    @Provides
//    MovieListView provideView() {
//        return mView;
//    }
//}
@Module
public class MoviesModule {
    public MoviesModule() {

    }
}
