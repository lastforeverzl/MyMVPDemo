package com.zackyzhang.mymvpdemo.mvp;

import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;

import java.util.List;

/**
 * Created by lei on 1/30/17.
 */

public interface MovieListView extends BaseView {

    void loadMovieList(List<NowPlayingMovie> movies, boolean isLastPage);

    void viewMovie(NowPlayingMovie movie);
}
