package com.zackyzhang.mymvpdemo.di.component;

import android.app.Activity;

import com.zackyzhang.mymvpdemo.di.module.ActivityModule;
import com.zackyzhang.mymvpdemo.di.scope.PerActivity;
import com.zackyzhang.mymvpdemo.mvp.view.activity.MainActivity;

import dagger.Component;

/**
 * Created by lei on 2/2/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    // Expose to sub-graphs
    Activity getActivity();
}
