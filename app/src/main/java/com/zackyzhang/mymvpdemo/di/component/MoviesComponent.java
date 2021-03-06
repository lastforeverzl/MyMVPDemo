package com.zackyzhang.mymvpdemo.di.component;

import com.zackyzhang.mymvpdemo.di.module.ActivityModule;
import com.zackyzhang.mymvpdemo.di.module.MoviesModule;
import com.zackyzhang.mymvpdemo.di.scope.PerActivity;
import com.zackyzhang.mymvpdemo.mvp.view.activity.MainActivity;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.MovieDetailsFragment;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.MovieListFragment;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.SearchMovieFragment;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.UCMovieListFragment;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.WLMovieListFragment;

import dagger.Component;

/**
 * Created by lei on 1/30/17.
 */

//@PerActivity
//@Component(modules = MoviesModule.class, dependencies = ApplicationComponent.class)
//public interface MoviesComponent {
//
//    void inject(MovieListActivity mainActivity);
//}
@PerActivity
@Component(modules = {ActivityModule.class, MoviesModule.class}, dependencies = ApplicationComponent.class)
public interface MoviesComponent extends ActivityComponent{

    void inject(MovieListFragment movieListFragment);

    void inject(MovieDetailsFragment movieDetailsFragment);

    void inject(UCMovieListFragment ucMovieListFragment);

    void inject(WLMovieListFragment wlMovieListFragment);

    void inject(SearchMovieFragment searchMovieFragment);
}
