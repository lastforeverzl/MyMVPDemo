package com.zackyzhang.mymvpdemo;

import android.app.Application;

import com.zackyzhang.mymvpdemo.di.component.ApplicationComponent;
import com.zackyzhang.mymvpdemo.di.component.DaggerApplicationComponent;
import com.zackyzhang.mymvpdemo.di.module.ApplicationModule;
import com.zackyzhang.mymvpdemo.di.module.MoviesServiceModule;

import timber.log.Timber;

/**
 * Created by lei on 1/26/17.
 */

public class MyApplication extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .moviesServiceModule(new MoviesServiceModule())
                .build();

    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
