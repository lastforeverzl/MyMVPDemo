package com.zackyzhang.mymvpdemo.mvp;

import android.content.Context;

/**
 * Created by lei on 1/30/17.
 */

public interface BaseView {

    void showLoadingDialog();

    void hideLoadingDialog();

    void showError(String message);

    Context context();
}
