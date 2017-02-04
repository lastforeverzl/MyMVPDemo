package com.zackyzhang.mymvpdemo.mvp.presenter;

import com.zackyzhang.mymvpdemo.mvp.BaseView;

/**
 * Created by lei on 2/3/17.
 */

public interface Presenter<T extends BaseView> {

    void setView(T view);

    void resume();

    void pause();

    void destroy();
}
