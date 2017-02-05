package com.zackyzhang.mymvpdemo.di.module;

import android.content.Context;
import android.util.Log;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.data.MoviesService;
import com.zackyzhang.mymvpdemo.di.ApplicationContext;
import com.zackyzhang.mymvpdemo.di.scope.ApplicationScope;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by lei on 1/30/17.
 */

@Module
public class MoviesServiceModule {

    public MoviesServiceModule() {
    }

    @Provides
    @Singleton
    MoviesService provideMoviesService(Retrofit moviesRetrofit) {
        return moviesRetrofit.create(MoviesService.class);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.tag("OkHttp").d(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Context context) {
        int cacheSize = 10 * 1000 * 1000;
        Log.d("DIR", String.valueOf(context.getApplicationContext().getCacheDir()));
        Cache cache = new Cache(context.getApplicationContext().getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
            return new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .cache(cache)
                    .build();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .baseUrl(Constants.MOVIE_DOMAIN)
                .build();
    }

    @Provides
    @Singleton
    OkHttp3Downloader provideOkHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }

    @Provides
    @Singleton
    Picasso providePicasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }
}
