package com.zackyzhang.mymvpdemo.mvp.presenter;

import android.support.annotation.NonNull;

import com.zackyzhang.mymvpdemo.data.GetUCMovieList;
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
public class UCMovieListPresenter implements Presenter<MovieListView>  {

    private MovieListView mUCMovieListView;
    private GetUCMovieList mUCGetMovieListCase;

    private int currentPage = 1;
    private boolean isLastPage = false;

    @Inject
    public UCMovieListPresenter(GetUCMovieList getMovieListCase) {
        mUCGetMovieListCase = getMovieListCase;
    }

    @Override
    public void setView(@NonNull MovieListView view) {
        mUCMovieListView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mUCGetMovieListCase.dispose();
        mUCMovieListView = null;
    }

    private void showViewLoading() {
        mUCMovieListView.showLoadingDialog();
    }

    private void hideViewLoading() {
        mUCMovieListView.hideLoadingDialog();
    }

    private void showToastMessage(String message) {
        mUCMovieListView.showError(message);
    }

    private void showMovieListInView(List<NowPlayingMovie> movieList, boolean isLastPage) {
        mUCMovieListView.renderMovieList(movieList, isLastPage);
    }

    /**
     *  Initialize the presenter, Retrieving the movie list
     */
    public void initialize() {
        this.showViewLoading();
        this.getMovies();
    }

    public void getMoreMovies() {
        this.showViewLoading();
        mUCGetMovieListCase.execute(new MovieListObserver(), GetUCMovieList.Params.forPage(++currentPage));
    }

    public void getMovies() {
        mUCGetMovieListCase.execute(new MovieListObserver(), GetUCMovieList.Params.forPage(currentPage));

    }

    public void onMovieClicked(NowPlayingMovie movie) {
        mUCMovieListView.viewMovie(movie);
    }

    private final class MovieListObserver extends DisposableObserver<List<NowPlayingMovie>> {

        @Override
        public void onNext(List<NowPlayingMovie> nowPlayingMovies) {
            if (nowPlayingMovies.size() == 0) {
                isLastPage = true;
            }
            UCMovieListPresenter.this.showMovieListInView(nowPlayingMovies, isLastPage);
        }

        @Override
        public void onError(Throwable e) {
            UCMovieListPresenter.this.hideViewLoading();
            UCMovieListPresenter.this.showToastMessage("Error in loading " + e.getMessage());
        }

        @Override
        public void onComplete() {
            UCMovieListPresenter.this.hideViewLoading();
            UCMovieListPresenter.this.showToastMessage("Get MovieEntity completed");
        }
    }
}
