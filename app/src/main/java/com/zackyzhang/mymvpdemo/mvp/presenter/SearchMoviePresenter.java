package com.zackyzhang.mymvpdemo.mvp.presenter;

import android.util.Log;

import com.zackyzhang.mymvpdemo.data.GetMovieList;
import com.zackyzhang.mymvpdemo.data.GetSearchMovies;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.mvp.MovieListView;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.SearchMovieFragment;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by lei on 2/17/17.
 */

public class SearchMoviePresenter implements Presenter<MovieListView> {

    private static final String TAG = "SearchMoviePresenter";

    private MovieListView mMovieListView;
    private GetSearchMovies mGetSearchCase;

    private int currentPage = 1;
    private boolean isLastPage = false;
    private String mQuery;

    @Inject
    public SearchMoviePresenter(GetSearchMovies getSearchMovies) {
        mGetSearchCase = getSearchMovies;
    }

    @Override
    public void setView(MovieListView view) {
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
        mGetSearchCase.dispose();
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
    }

    /**
     *  Initialize the presenter, Retrieving the movie list
     */
    public void initialize(String query) {
        mQuery = query;
        mMovieListView.initAdapter();
        isLastPage = false;
        currentPage = 1;
        this.showViewLoading();
        this.getMovies();
    }

    public void getMoreMovies() {
        this.showViewLoading();
        Log.d(TAG, "currentPage: " + currentPage);
        mGetSearchCase.execute(new MovieListObserver(), GetSearchMovies.Params.forParams(++currentPage, mQuery));
    }

    private void getMovies() {
        // TODO: 2/17/17 maybe need to reset page number before second search.
        Log.d(TAG, "currentPage: " + currentPage);
        mGetSearchCase.execute(new MovieListObserver(), GetSearchMovies.Params.forParams(currentPage, mQuery));
    }

    public void onMovieClicked(NowPlayingMovie movie) {
        mMovieListView.viewMovie(movie);
    }

    private final class MovieListObserver extends DisposableObserver<List<NowPlayingMovie>> {

        @Override
        public void onNext(List<NowPlayingMovie> nowPlayingMovies) {
            if (nowPlayingMovies.size() == 0) {
                isLastPage = true;
            }
            SearchMoviePresenter.this.showMovieListInView(nowPlayingMovies, isLastPage);
        }

        @Override
        public void onError(Throwable e) {
            SearchMoviePresenter.this.hideViewLoading();
            SearchMoviePresenter.this.showToastMessage("Error in loading " + e.getMessage());
        }

        @Override
        public void onComplete() {
            SearchMoviePresenter.this.hideViewLoading();
            SearchMoviePresenter.this.showToastMessage("Get MovieEntity completed");
        }
    }
}
