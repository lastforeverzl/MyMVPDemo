package com.zackyzhang.mymvpdemo.data;

import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by lei on 2/3/17.
 */

public class GetUCMovieList extends UseCase<List<NowPlayingMovie>, GetUCMovieList.Params> {

    private final MoviesService mMoviesService;

    @Inject
    GetUCMovieList(MoviesService moviesService) {
        super();
        mMoviesService = moviesService;
    }

    @Override
    Observable<List<NowPlayingMovie>> buildUseCaseObservable(Params params) {

        /**
         *  loading first 2 pages at once.
         *
        return Observable.range(1, 2)
                .concatMap(page -> mMoviesService.movieList(Constants.KEY_API, Constants.API_LANGUAGE, page, ""))
                .map(listNowPlayingResult -> listNowPlayingResult.getResults());
        */
        return mMoviesService.ucMovieList(Constants.KEY_API, Constants.API_LANGUAGE, params.page, "US")
                .map(listNowPlayingResult -> listNowPlayingResult.getResults());
//                .map(new Function<NowPlayingResult<List<NowPlayingMovie>>, List<NowPlayingMovie>>() {
//                    @Override
//                    public List<NowPlayingMovie> apply(NowPlayingResult<List<NowPlayingMovie>> listNowPlayingResult)
//                            throws Exception {
//                        return listNowPlayingResult.getResults();
//                    }
//                });

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
