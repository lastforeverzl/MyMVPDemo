package com.zackyzhang.mymvpdemo.di;

/**
 * Created by lei on 2/2/17.
 * Interface representing a contract for clients that contains a component for dependency injection.
 */

public interface HasComponent<T> {
    T getComponent();
}
