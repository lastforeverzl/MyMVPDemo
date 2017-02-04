package com.zackyzhang.mymvpdemo.di.module;

import android.app.Activity;

import com.zackyzhang.mymvpdemo.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lei on 2/2/17.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return this.activity;
    }
}
