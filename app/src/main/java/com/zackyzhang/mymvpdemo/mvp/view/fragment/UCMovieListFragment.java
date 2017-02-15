package com.zackyzhang.mymvpdemo.mvp.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.mvp.MovieListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lei on 2/14/17.
 */

public class UCMovieListFragment extends BaseFragment implements MovieListView{

    @BindView(R.id.test_fragment2)
    TextView testText;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_uc_movie_list, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        testText.setText("Fragment Up Coming movies");
        return fragmentView;
    }

    @Override
    public void renderMovieList(List<NowPlayingMovie> movies, boolean isLastPage) {

    }

    @Override
    public void viewMovie(NowPlayingMovie movie) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void hideLoadingDialog() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return null;
    }
}
