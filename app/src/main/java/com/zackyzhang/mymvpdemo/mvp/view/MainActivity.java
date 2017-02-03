package com.zackyzhang.mymvpdemo.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.mvp.view.adapter.MovieAdapter;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.di.component.DaggerMoviesComponent;
import com.zackyzhang.mymvpdemo.di.module.MoviesModule;
import com.zackyzhang.mymvpdemo.mvp.presenter.MoviesPresenter;
import com.zackyzhang.mymvpdemo.mvp.MainView;

import java.util.List;

import javax.inject.Inject;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView{

    @BindView(R.id.movie_list)
    protected RecyclerView mRecyclerView;

    @Inject
    protected Picasso mPicasso;
    @Inject
    protected MoviesPresenter mPresenter;

    private MovieAdapter mMovieAdapter;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        loadMovies();
    }

    private void initializeList() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMovieAdapter = new MovieAdapter(getLayoutInflater(), mPicasso);
        mRecyclerView.setAdapter(mMovieAdapter);
    }

    private void loadMovies() {
        mPresenter.getMovies();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerMoviesComponent.builder()
                .moviesModule(new MoviesModule(this))
                .applicationComponent(getApplicationComponent())
                .build()
                .inject(this);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMovieLoaded(List<NowPlayingMovie> movies) {
        mMovieAdapter.loadMovies(movies);
    }
}
