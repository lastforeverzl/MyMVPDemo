package com.zackyzhang.mymvpdemo;

import com.zackyzhang.mymvpdemo.data.MoviesService;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingResult;

import java.util.List;
import java.util.Timer;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import timber.log.Timber;

/**
 * Created by lei on 2/3/17.
 */

public class GetMovieList extends UseCase<List<NowPlayingMovie>, GetMovieList.Params> {

    private final MoviesService mMoviesService;

    @Inject
    GetMovieList(MoviesService moviesService) {
        super();
        mMoviesService = moviesService;
    }

    @Override
    Observable<List<NowPlayingMovie>> buildUseCaseObservable(Params params) {
        return mMoviesService.movieList(Constants.KEY_API, "en-US", params.page, "")
                .map(new Function<NowPlayingResult<List<NowPlayingMovie>>, List<NowPlayingMovie>>() {
                    @Override
                    public List<NowPlayingMovie> apply(NowPlayingResult<List<NowPlayingMovie>> listNowPlayingResult)
                            throws Exception {
                        return listNowPlayingResult.getResults();
                    }
                });
    }

    public static final class Params {

        private final int page;

        private Params(int page) {
            this.page = page;
        }

        public static Params forPage(int page) {
            return new Params(page);
        }
    }

}
