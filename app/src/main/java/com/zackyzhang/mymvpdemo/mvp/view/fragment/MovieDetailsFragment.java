package com.zackyzhang.mymvpdemo.mvp.view.fragment;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.di.component.MoviesComponent;
import com.zackyzhang.mymvpdemo.mvp.MovieDetailsView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

/**
 * Created by lei on 2/8/17.
 */

public class MovieDetailsFragment extends BaseFragment implements MovieDetailsView {

    private static final String TAG = "MovieDetailsFragment";
    private static final String PARAM_MOVIE_ID = "param_movie_id";

    @Inject
    protected Picasso mPicasso;

    @BindView(R.id.test_fragment_detail)
    TextView testView; // test purpose

    private int mTestMovieId; // test purpose

    public static MovieDetailsFragment forMovie(int movieId) {
        MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(PARAM_MOVIE_ID, movieId);
        movieDetailsFragment.setArguments(arguments);
        return movieDetailsFragment;
    }

    public MovieDetailsFragment() {
        setRetainInstance(true);
    }

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(MoviesComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_movie_details, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        mTestMovieId = getCurrentMovieId(); // test purpose
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        testView.setText(String.valueOf(mTestMovieId));// test purpose
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setupUI(NowPlayingMovie movie) {

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

    private int getCurrentMovieId() {
        Bundle args = getArguments();
        return args.getInt(PARAM_MOVIE_ID);
    }
}
