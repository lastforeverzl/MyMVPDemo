package com.zackyzhang.mymvpdemo.data;

import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.data.entity.MovieDetails.MovieEntity;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by lei on 2/9/17.
 */

public class GetMovieDetail extends UseCase<MovieEntity, GetMovieDetail.Params> {

    private final MoviesService mMoviesService;

    @Inject
    GetMovieDetail(MoviesService moviesService) {
        super();
        mMoviesService = moviesService;
    }

    @Override
    Observable<MovieEntity> buildUseCaseObservable(Params params) {
        return mMoviesService.getMoiveDetail(params.id, Constants.KEY_API, Constants.API_LANGUAGE, Constants.MOVIE_API_APPEND_TO_RESPONSE);
    }

    public static final class Params {
        private final int id;

        private Params(int id) {
            this.id = id;
        }

        public static Params forId(int id) {
            return new Params(id);
        }
    }
}
