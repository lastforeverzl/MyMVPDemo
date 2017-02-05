package com.zackyzhang.mymvpdemo;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lei on 2/3/17.
 */

public abstract class UseCase<T, Params> {

    private final CompositeDisposable mDisposables;

    UseCase() {
        mDisposables = new CompositeDisposable();
    }

    abstract Observable<T> buildUseCaseObservable(Params params);

    public void execute(DisposableObserver<T> observer, Params params) {
        final Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        mDisposables.add(observable.subscribeWith(observer));
    }

    public void dispose() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }
}
