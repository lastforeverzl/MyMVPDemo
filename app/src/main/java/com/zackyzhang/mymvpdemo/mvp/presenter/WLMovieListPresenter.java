package com.zackyzhang.mymvpdemo.mvp.presenter;

import android.support.annotation.NonNull;

import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.data.local.MoviesLocalDataSource;
import com.zackyzhang.mymvpdemo.di.scope.PerActivity;
import com.zackyzhang.mymvpdemo.mvp.MovieListView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lei on 2/1/17.
 */
@PerActivity
public class WLMovieListPresenter implements Presenter<MovieListView>  {

    private MovieListView mMovieListView;
    private MoviesLocalDataSource mGetMovieListCase;

    @Inject
    public WLMovieListPresenter(MoviesLocalDataSource getMovieListCase) {
        mGetMovieListCase = getMovieListCase;
    }

    @Override
    public void setView(@NonNull MovieListView view) {
        mMovieListView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mMovieListView = null;
    }

    private void showViewLoading() {
        mMovieListView.showLoadingDialog();
    }

    private void hideViewLoading() {
        mMovieListView.hideLoadingDialog();
    }

    private void showToastMessage(String message) {
        mMovieListView.showError(message);
    }

    private void showMovieListInView(List<NowPlayingMovie> movieList, boolean isLastPage) {
        mMovieListView.renderMovieList(movieList, isLastPage);
        hideViewLoading();
    }

    /**
     *  Initialize the presenter, Retrieving the movie list
     */
    public void initialize() {
        mMovieListView.initAdapter();
        this.showViewLoading();
        this.getMovies();
    }

    public void getMovies() {
        List<NowPlayingMovie> movies = mGetMovieListCase.getMovies();
        showMovieListInView(movies, true);
    }

    public void onMovieClicked(NowPlayingMovie movie) {
        mMovieListView.viewMovie(movie);
    }

}
