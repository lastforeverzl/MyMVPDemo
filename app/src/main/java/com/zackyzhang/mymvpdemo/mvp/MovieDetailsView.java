package com.zackyzhang.mymvpdemo.mvp;

import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;

/**
 * Created by lei on 2/8/17.
 */

public interface MovieDetailsView extends BaseView {

    void setupUI(NowPlayingMovie movie);
}
