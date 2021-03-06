package com.zackyzhang.mymvpdemo.data;

import com.zackyzhang.mymvpdemo.data.entity.MovieDetails.MovieEntity;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingResult;
import com.zackyzhang.mymvpdemo.data.entity.SearchMovies;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lei on 1/27/17.
 */

public interface MoviesService {

    @GET("movie/now_playing")
    Observable<NowPlayingResult<List<NowPlayingMovie>>> movieList(@Query("api_key") String apiKey,
                                                                  @Query("language") String language,
                                                                  @Query("page") int page,
                                                                  @Query("region") String region);

    @GET("movie/{movie_id}")
    Observable<MovieEntity> getMoiveDetail(@Path("movie_id") int movieId,
                                           @Query("api_key") String apiKey,
                                           @Query("language") String language,
                                           @Query("append_to_response") String appendToResponse);

    @GET("movie/upcoming")
    Observable<NowPlayingResult<List<NowPlayingMovie>>> ucMovieList(@Query("api_key") String apiKey,
                                                                  @Query("language") String language,
                                                                  @Query("page") int page,
                                                                  @Query("region") String region);

    @GET("search/movie")
    Observable<SearchMovies<List<NowPlayingMovie>>> searchMovies(@Query("api_key") String apiKey,
                                                                 @Query("language") String language,
                                                                 @Query("query") String query,
                                                                 @Query("page") int page,
                                                                 @Query("region") String region);
}
