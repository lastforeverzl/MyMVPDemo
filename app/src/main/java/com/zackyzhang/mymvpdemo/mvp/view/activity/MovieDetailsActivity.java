package com.zackyzhang.mymvpdemo.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.di.HasComponent;
import com.zackyzhang.mymvpdemo.di.component.DaggerMoviesComponent;
import com.zackyzhang.mymvpdemo.di.component.MoviesComponent;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.MovieDetailsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lei on 2/8/17.
 */

public class MovieDetailsActivity extends BaseActivity implements HasComponent<MoviesComponent> {

    private static final String INTENT_EXTRA_PARAM_MOVIE_ID = "com.zackyzhang.mymvpdemo.INTENT_EXTRA_PARAM_MOVIE_ID";
    private static final String INSTANCE_STATE_PARAM_MOVIE_ID = "com.zackyzhang.mymvpdemo.INSTANCE_STATE_PARAM_MOVIE_ID";

    public static Intent getCallingIntent(Context context, int movieId) {
        Intent callingIntent = new Intent(context, MovieDetailsActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_MOVIE_ID, movieId);
        return callingIntent;
    }

    private int mMovieId;
    private MoviesComponent mMoviesComponent;

    @BindView(R.id.my_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.initializeActivity(savedInstanceState);
        this.resolveDaggerDependency();
        mToolbar.setTitle("MOVIE DETAIL");
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.putInt(INSTANCE_STATE_PARAM_MOVIE_ID, mMovieId);
        }
        super.onSaveInstanceState(outState);
    }

    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.mMovieId = getIntent().getIntExtra(INTENT_EXTRA_PARAM_MOVIE_ID, -1);
            addFragment(R.id.fragmentContainer, MovieDetailsFragment.forMovie(mMovieId));
        } else {
            this.mMovieId = savedInstanceState.getInt(INSTANCE_STATE_PARAM_MOVIE_ID);
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
}
