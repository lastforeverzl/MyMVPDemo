package com.zackyzhang.mymvpdemo.mvp;

import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;

import java.util.List;

/**
 * Created by lei on 1/30/17.
 */

public interface MainView extends BaseView {

    void onMovieLoaded(List<NowPlayingMovie> movies);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);
}
