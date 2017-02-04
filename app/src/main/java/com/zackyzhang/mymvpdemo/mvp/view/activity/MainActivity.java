package com.zackyzhang.mymvpdemo.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.zackyzhang.mymvpdemo.R;


/**
 * Created by lei on 2/2/17.
 * This is the app entry point.
 */

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        navigateToMovieList();
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    void navigateToMovieList() {
        this.mNavigator.navigateToMovieList(this);
    }

}
