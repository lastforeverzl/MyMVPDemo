package com.zackyzhang.mymvpdemo.mvp.presenter;

import android.support.annotation.NonNull;

import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.GetMovieList;
import com.zackyzhang.mymvpdemo.data.MoviesService;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.di.scope.PerActivity;
import com.zackyzhang.mymvpdemo.mvp.MovieListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by lei on 2/1/17.
 */
@PerActivity
public class MovieListPresenter implements Presenter<MovieListView>  {

    private MovieListView mMovieListView;
    private GetMovieList mGetMovieListCase;

    @Inject
    public MovieListPresenter(GetMovieList getMovieListCase) {
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
        mGetMovieListCase.dispose();
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

    private void showMovieListInView(List<NowPlayingMovie> movieList) {
        mMovieListView.loadMovieList(movieList);
    }

    /**
     *  Retrieving the movie list
     */
    public void initialize() {
        this.showViewLoading();
        this.getMovies();
    }

    public void getMovies() {
        mGetMovieListCase.execute(new MovieListObserver(), null);

    }

    private final class MovieListObserver extends DisposableObserver<List<NowPlayingMovie>> {

        @Override
        public void onNext(List<NowPlayingMovie> nowPlayingMovies) {
            MovieListPresenter.this.showMovieListInView(nowPlayingMovies);
        }

        @Override
        public void onError(Throwable e) {
            MovieListPresenter.this.hideViewLoading();
            MovieListPresenter.this.showToastMessage("Error in loading " + e.getMessage());
        }

        @Override
        public void onComplete() {
            MovieListPresenter.this.hideViewLoading();
            MovieListPresenter.this.showToastMessage("Get Movie completed");
        }
    }
}
