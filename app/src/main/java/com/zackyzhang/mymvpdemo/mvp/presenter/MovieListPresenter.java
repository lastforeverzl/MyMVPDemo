package com.zackyzhang.mymvpdemo.mvp.presenter;

import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.data.MoviesService;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingResult;
import com.zackyzhang.mymvpdemo.mvp.MovieListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lei on 2/1/17.
 */

public class MovieListPresenter implements Presenter<MovieListView>, Observer<List<NowPlayingMovie>>{

    private MovieListView mMovieListView;
    private MoviesService mMoviesService;

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

    @Inject
    public MovieListPresenter(MoviesService moviesService) {
        this.mMoviesService = moviesService;
    }

    @Override
    public void setView(MovieListView view) {
        mMovieListView = view;
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

    // TODO: 2/3/17 encapsulate Rxjava...
    public void getMovies() {
        Observable<List<NowPlayingMovie>> observable = mMoviesService.movieList(Constants.KEY_API, "en-US", 1, "")
                .map(new Function<NowPlayingResult<List<NowPlayingMovie>>, List<NowPlayingMovie>>() {
                    @Override
                    public List<NowPlayingMovie> apply(NowPlayingResult<List<NowPlayingMovie>> listNowPlayingResult)
                            throws Exception {
                        return listNowPlayingResult.getResults();
                    }
                });
//        Observable<NowPlayingMovie> observable1 = observable
//                .flatMap(new Function<List<NowPlayingMovie>, ObservableSource<NowPlayingMovie>>() {
//                    @Override
//                    public ObservableSource<NowPlayingMovie> apply(List<NowPlayingMovie> nowPlayingMovies) throws Exception {
//                        return Observable.fromIterable(nowPlayingMovies);
//                    }
//                });
        subscribe(observable, this);
    }
    protected  <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<NowPlayingMovie> nowPlayingMovies) {
        this.showMovieListInView(nowPlayingMovies);
    }

    @Override
    public void onError(Throwable e) {
        this.hideViewLoading();
        this.showToastMessage("Error in loading " + e.getMessage());
    }

    @Override
    public void onComplete() {
        this.hideViewLoading();
        this.showToastMessage("Get Movie completed");
    }
}
