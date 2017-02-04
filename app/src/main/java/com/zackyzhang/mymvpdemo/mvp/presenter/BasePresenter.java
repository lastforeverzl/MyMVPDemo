package com.zackyzhang.mymvpdemo.mvp.presenter;

import com.zackyzhang.mymvpdemo.mvp.BaseView;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lei on 2/1/17.
 */


// TODO: 2/3/17 can be deleted
public class BasePresenter<V extends BaseView> {

    protected V mView;

    protected V getView() {
        return mView;
    }

    protected  <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
