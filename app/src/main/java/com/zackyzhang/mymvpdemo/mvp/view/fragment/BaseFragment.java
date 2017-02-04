package com.zackyzhang.mymvpdemo.mvp.view.fragment;

import android.app.Fragment;
import android.widget.Toast;

import com.zackyzhang.mymvpdemo.di.HasComponent;

/**
 * Created by lei on 2/2/17.
 */

public class BaseFragment extends Fragment {

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    // TODO: 2/2/17  investigate below method.
    /**
     *  Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((HasComponent<T>) getActivity()).getComponent());
    }
}
