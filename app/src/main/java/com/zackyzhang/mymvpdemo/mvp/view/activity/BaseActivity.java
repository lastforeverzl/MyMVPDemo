package com.zackyzhang.mymvpdemo.mvp.view.activity;

//import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.MyApplication;
import com.zackyzhang.mymvpdemo.Navigator;
import com.zackyzhang.mymvpdemo.di.component.ApplicationComponent;
import com.zackyzhang.mymvpdemo.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by lei on 2/1/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator mNavigator;
    @Inject
    Picasso mPicasso;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();

    }
    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
