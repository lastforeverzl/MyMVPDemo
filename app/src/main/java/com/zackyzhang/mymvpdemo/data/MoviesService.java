package com.zackyzhang.mymvpdemo.data;

import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lei on 1/27/17.
 */

public interface MoviesService {

//    @GET("movie/now_playing")
//    Call<NowPlayingResult<List<NowPlayingMovie>>> movieList(@Query("api_key") String apiKey,
//                                                            @Query("language") String language,
//                                                            @Query("page") int page,
//                                                            @Query("region") String region);

    @GET("movie/now_playing")
    Observable<NowPlayingResult<List<NowPlayingMovie>>> movieList(@Query("api_key") String apiKey,
                                                                  @Query("language") String language,
                                                                  @Query("page") int page,
                                                                  @Query("region") String region);
}
