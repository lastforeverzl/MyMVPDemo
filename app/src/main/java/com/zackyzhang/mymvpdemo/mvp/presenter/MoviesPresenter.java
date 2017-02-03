package com.zackyzhang.mymvpdemo.mvp.presenter;

import android.util.Log;

import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.data.MoviesService;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingResult;
import com.zackyzhang.mymvpdemo.mvp.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by lei on 2/1/17.
 */

public class MoviesPresenter extends BasePresenter<MainView> implements Observer<List<NowPlayingMovie>>{

    private MoviesService mMoviesService;

    @Inject
    public MoviesPresenter(MoviesService moviesService) {
        this.mMoviesService = moviesService;
    }

    public void getMovies() {
        getView().onShowDialog("Loading...");
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

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<NowPlayingMovie> nowPlayingMovies) {
        getView().onMovieLoaded(nowPlayingMovies);
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error in loading " + e.getMessage());
    }

    @Override
    public void onComplete() {
        getView().onHideDialog();
        getView().onShowToast("Get Movie completed");
    }
}
