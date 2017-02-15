package com.zackyzhang.mymvpdemo.mvp.view.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.di.HasComponent;
import com.zackyzhang.mymvpdemo.di.component.DaggerMoviesComponent;
import com.zackyzhang.mymvpdemo.di.component.MoviesComponent;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.mvp.view.adapter.MovieListPagerAdapter;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.MovieListFragment;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.UCMovieListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListActivity extends BaseActivity implements HasComponent<MoviesComponent>, MovieListFragment.MovieListListener, UCMovieListFragment.UCMovieListListener {

    private MoviesComponent mMoviesComponent;
    private MovieListPagerAdapter mMovieListPagerAdapter;
    private List<Fragment> mFragments;

    @BindView(R.id.my_toolbar) Toolbar mToolbar;
    @BindView(R.id.id_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.id_viewpager)
    ViewPager mViewPager;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MovieListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        this.resolveDaggerDependency();
        initView();
    }

    private void resolveDaggerDependency() {
        this.mMoviesComponent = DaggerMoviesComponent.builder()
                .activityModule(getActivityModule())
                .applicationComponent(getApplicationComponent())
                .build();
    }

    private void initView() {
        mToolbar.setTitle("MOVIE");
        setSupportActionBar(mToolbar);

        mFragments = new ArrayList<>();

        mFragments.add(new MovieListFragment());
        mFragments.add(new UCMovieListFragment());
        mMovieListPagerAdapter = new MovieListPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mMovieListPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public MoviesComponent getComponent() {
        return mMoviesComponent;
    }

    @Override
    public void onMovieClicked(NowPlayingMovie movie, View shareView) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Log.d("MovieListActivity", shareView.toString());
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MovieListActivity.this, shareView, "shareViewTest");
            this.mNavigator.navigateToMovieDetails(this, movie.getId(), movie.getBackdropPath(), options.toBundle());
        } else {
            this.mNavigator.navigateToMovieDetails(this, movie.getId(), movie.getBackdropPath(), null);
        }
    }

}
