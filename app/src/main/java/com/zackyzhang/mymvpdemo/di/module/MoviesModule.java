package com.zackyzhang.mymvpdemo.di.module;

import com.zackyzhang.mymvpdemo.di.scope.PerActivity;
import com.zackyzhang.mymvpdemo.mvp.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lei on 1/30/17.
 */

@Module
public class MoviesModule {

    private MainView mView;

    public MoviesModule(MainView mainView) {
        mView = mainView;
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mView;
    }
}
