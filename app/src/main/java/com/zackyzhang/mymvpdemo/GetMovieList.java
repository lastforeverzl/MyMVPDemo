package com.zackyzhang.mymvpdemo;

import com.zackyzhang.mymvpdemo.data.MoviesService;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingResult;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by lei on 2/3/17.
 */

public class GetMovieList extends UseCase<List<NowPlayingMovie>, Void> {

    private final MoviesService mMoviesService;

    @Inject
    GetMovieList(MoviesService moviesService) {
        super();
        mMoviesService = moviesService;
    }

    @Override
    Observable<List<NowPlayingMovie>> buildUseCaseObservable(Void aVoid) {
        return mMoviesService.movieList(Constants.KEY_API, "en-US", 1, "")
                .map(new Function<NowPlayingResult<List<NowPlayingMovie>>, List<NowPlayingMovie>>() {
                    @Override
                    public List<NowPlayingMovie> apply(NowPlayingResult<List<NowPlayingMovie>> listNowPlayingResult)
                            throws Exception {
                        return listNowPlayingResult.getResults();
                    }
                });
    }
}
