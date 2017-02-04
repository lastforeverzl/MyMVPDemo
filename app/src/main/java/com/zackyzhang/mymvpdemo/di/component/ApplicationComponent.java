package com.zackyzhang.mymvpdemo.di.component;

import android.content.Context;

import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.data.MoviesService;
import com.zackyzhang.mymvpdemo.di.module.ApplicationModule;
import com.zackyzhang.mymvpdemo.di.ApplicationContext;
import com.zackyzhang.mymvpdemo.di.module.MoviesServiceModule;
import com.zackyzhang.mymvpdemo.di.scope.ApplicationScope;
import com.zackyzhang.mymvpdemo.mvp.view.activity.BaseActivity;

import dagger.Component;

/**
 * Created by lei on 1/30/17.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class, MoviesServiceModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    @ApplicationContext
    Context getApplicationContext();

    MoviesService getMoviesService();

    Picasso getPicasso();

}
