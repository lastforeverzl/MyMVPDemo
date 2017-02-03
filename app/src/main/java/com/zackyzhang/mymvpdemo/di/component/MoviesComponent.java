package com.zackyzhang.mymvpdemo.di.component;

import com.zackyzhang.mymvpdemo.mvp.view.MainActivity;
import com.zackyzhang.mymvpdemo.di.module.MoviesModule;
import com.zackyzhang.mymvpdemo.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by lei on 1/30/17.
 */

@PerActivity
@Component(modules = MoviesModule.class, dependencies = ApplicationComponent.class)
public interface MoviesComponent {

    void inject(MainActivity mainActivity);
}
