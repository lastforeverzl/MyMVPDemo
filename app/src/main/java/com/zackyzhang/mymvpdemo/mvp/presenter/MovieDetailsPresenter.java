package com.zackyzhang.mymvpdemo.mvp.presenter;

import android.graphics.Movie;
import android.support.annotation.NonNull;

import com.zackyzhang.mymvpdemo.data.GetMovieDetail;
import com.zackyzhang.mymvpdemo.data.entity.MovieDetails.MovieEntity;
import com.zackyzhang.mymvpdemo.data.local.MoviesLocalDataSource;
import com.zackyzhang.mymvpdemo.di.scope.PerActivity;
import com.zackyzhang.mymvpdemo.mvp.MovieDetailsView;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

/**
 * Created by lei on 2/9/17.
 */
@PerActivity
public class MovieDetailsPresenter implements Presenter<MovieDetailsView> {

    private static final String TAG = "MovieDetailsPresenter";

    private MovieDetailsView mMovieDetailsView;
    private GetMovieDetail mGetMovieDetailCase;
    private MoviesLocalDataSource mMoviesDB;
    private MovieEntity mMovie;

    @Inject
    public MovieDetailsPresenter(GetMovieDetail getMovieDetailCase, MoviesLocalDataSource moviesLocalDataSource) {
        mGetMovieDetailCase = getMovieDetailCase;
        mMoviesDB = moviesLocalDataSource;
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

    private void getMovieDetail(int movieId) {
        mGetMovieDetailCase.execute(new MovieDetailObserver(), GetMovieDetail.Params.forId(movieId));
    }

    public Boolean isExist(MovieEntity movie) {
        return mMoviesDB.isMovieExist(movie.getId());
    }

    public void saveMovieToDB() {
        mMoviesDB.saveMovie(mMovie);
    }

    public void deleteMovieFromDB() {
        mMoviesDB.deleteMovie(mMovie.getId(), mMovie.getOriginalTitle());
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
        mMovie = movieEntity;
        mMovieDetailsView.renderMovieDetails(movieEntity);
    }

    private final class MovieDetailObserver extends DisposableObserver<MovieEntity> {

        @Override
        public void onNext(MovieEntity movieEntity) {
            MovieDetailsPresenter.this.showMovieDetailsInView(movieEntity);
        }

        @Override
        public void onError(Throwable e) {
            Timber.tag(TAG).d(e.getMessage());
        }

        @Override
        public void onComplete() {
            MovieDetailsPresenter.this.showYouTubeInView();
            MovieDetailsPresenter.this.hideViewLoading();
        }
    }

    private void showYouTubeInView() {
        mMovieDetailsView.loadYouTubePlayer();
    }
}
