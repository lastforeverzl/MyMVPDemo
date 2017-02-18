package com.zackyzhang.mymvpdemo.data;

import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by lei on 2/17/17.
 */

public class GetSearchMovies extends UseCase<List<NowPlayingMovie>, GetSearchMovies.Params> {

    private final MoviesService mMoviesService;

    @Inject
    GetSearchMovies(MoviesService moviesService) {
        super();
        mMoviesService = moviesService;
    }

    @Override
    Observable<List<NowPlayingMovie>> buildUseCaseObservable(Params params) {
        return mMoviesService.searchMovies(Constants.KEY_API, Constants.API_LANGUAGE, params.query, params.page, "US")
                .map(listSearchMovies -> listSearchMovies.getResults());

    }

    public static final class Params {

        private final int page;
        private final String query;

        private Params(int page, String query) {
            this.page = page;
            this.query = query;
        }

        public static Params forParams(int page, String query) {
            return new Params(page, query);
        }
    }

}
