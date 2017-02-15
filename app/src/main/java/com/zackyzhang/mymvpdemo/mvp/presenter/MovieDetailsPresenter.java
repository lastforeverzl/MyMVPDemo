package com.zackyzhang.mymvpdemo.mvp.presenter;

import android.support.annotation.NonNull;

import com.zackyzhang.mymvpdemo.data.GetMovieDetail;
import com.zackyzhang.mymvpdemo.data.entity.Movie.MovieEntity;
import com.zackyzhang.mymvpdemo.mvp.MovieDetailsView;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

/**
 * Created by lei on 2/9/17.
 */

public class MovieDetailsPresenter implements Presenter<MovieDetailsView> {

    private static final String TAG = "MovieDetailsPresenter";

    private MovieDetailsView mMovieDetailsView;
    private GetMovieDetail mGetMovieDetailCase;

    @Inject
    public MovieDetailsPresenter(GetMovieDetail getMovieDetailCase) {
        mGetMovieDetailCase = getMovieDetailCase;
    }

    @Override
    public void setView(@NonNull MovieDetailsView view) {
        mMovieDetailsView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mGetMovieDetailCase.dispose();
        mMovieDetailsView = null;
    }

    /**
     * Initialize the presenter, retrieving movie details.
     * @param movieId
     */
    public void initialize(int movieId) {
        this.showViewLoading();
        this.getMovieDetail(movieId);
    }

    public void getMovieDetail(int movieId) {
        mGetMovieDetailCase.execute(new MovieDetailObserver(), GetMovieDetail.Params.forId(movieId));
    }

    private void showViewLoading() {
        mMovieDetailsView.showLoadingDialog();
    }

    private void hideViewLoading() {
        mMovieDetailsView.hideLoadingDialog();
    }

    private void showToastMessage(String message) {
        mMovieDetailsView.showError(message);
    }

    private void showMovieDetailsInView(MovieEntity movieEntity) {
        mMovieDetailsView.renderMovieDetails(movieEntity);
    }

    private final class MovieDetailObserver extends DisposableObserver<MovieEntity> {

        @Override
        public void onNext(MovieEntity movieEntity) {
            Timber.tag(TAG).d(movieEntity.getHomepage());
            MovieDetailsPresenter.this.showMovieDetailsInView(movieEntity);
        }

        @Override
        public void onError(Throwable e) {
            Timber.tag(TAG).d(e.getMessage());
        }

        @Override
        public void onComplete() {
            Timber.tag(TAG).d("finish");
            MovieDetailsPresenter.this.hideViewLoading();
        }
    }
}
