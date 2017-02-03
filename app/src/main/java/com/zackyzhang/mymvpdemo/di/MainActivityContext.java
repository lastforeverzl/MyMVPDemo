package com.zackyzhang.mymvpdemo.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by lei on 1/30/17.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface MainActivityContext {
}
