package com.zackyzhang.mymvpdemo.di.module;

import android.content.Context;
import com.zackyzhang.mymvpdemo.di.ApplicationContext;
import com.zackyzhang.mymvpdemo.di.scope.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lei on 1/28/17.
 */

@Module
public class ApplicationModule {

    private final Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    Context context() {
        return this.mContext;
    }
}
