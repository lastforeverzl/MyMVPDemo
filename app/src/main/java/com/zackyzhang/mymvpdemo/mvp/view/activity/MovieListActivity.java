package com.zackyzhang.mymvpdemo.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.di.HasComponent;
import com.zackyzhang.mymvpdemo.di.component.DaggerMoviesComponent;
import com.zackyzhang.mymvpdemo.di.component.MoviesComponent;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.MovieListFragment;

public class MovieListActivity extends BaseActivity implements HasComponent<MoviesComponent>, MovieListFragment.MovieListListener {

    private MoviesComponent mMoviesComponent;


    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MovieListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

        this.resolveDaggerDependency();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new MovieListFragment());
        }
    }

    private void resolveDaggerDependency() {
        this.mMoviesComponent = DaggerMoviesComponent.builder()
                .activityModule(getActivityModule())
                .applicationComponent(getApplicationComponent())
                .build();
    }

    @Override
    public MoviesComponent getComponent() {
        return mMoviesComponent;
    }

    @Override
    public void onMovieListClicked(NowPlayingMovie movie) {
        // TODO: 2/2/17 implement this.navigator.navigateToMovieDetails()
    }

}
