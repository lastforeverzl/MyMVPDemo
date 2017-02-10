package com.zackyzhang.mymvpdemo.mvp;

import com.zackyzhang.mymvpdemo.data.entity.Movie.MovieEntity;

/**
 * Created by lei on 2/8/17.
 */

public interface MovieDetailsView extends BaseView {

    void renderMovieDetails(MovieEntity movie);
}
