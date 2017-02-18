package com.zackyzhang.mymvpdemo.mvp.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.data.entity.MovieDetails.MovieEntity;
import com.zackyzhang.mymvpdemo.di.component.MoviesComponent;
import com.zackyzhang.mymvpdemo.mvp.MovieDetailsView;
import com.zackyzhang.mymvpdemo.mvp.presenter.MovieDetailsPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by lei on 2/8/17.
 */

public class MovieDetailsFragment extends BaseFragment implements MovieDetailsView {

    private static final String TAG = "MovieDetailsFragment";
    private static final String PARAM_MOVIE_ID = "param_movie_id";

    @Inject
    protected Picasso mPicasso;
    @Inject
    MovieDetailsPresenter mMovieDetailsPresenter;

    @BindView(R.id.layout_progress)
    RelativeLayout progress;
    @BindView(R.id.test_fragment_detail)
    TextView testView;
    @BindView(R.id.bt_add_to_db)
    TextView addToDbButton;

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
        final View fragmentView = inflater.inflate(R.layout.fragment_movie_details, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMovieDetailsPresenter.setView(this);
//        if (savedInstanceState == null) {
//            loadMovieDetails();
//        }
        loadMovieDetails();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMovieDetailsPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMovieDetailsPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMovieDetailsPresenter.destroy();
    }

    @Override
    public void renderMovieDetails(MovieEntity movie) {
        // TODO: 2/9/17 need to finish by UI.
        if (movie != null) {
            testView.setText(movie.getHomepage());
            if (mMovieDetailsPresenter.isExist(movie)) {
                Log.d(TAG, "movie exist");
                addToDbButton.setText(R.string.movie_added);
                addToDbButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            } else {
                addToDbButton.setText(R.string.movie_to_add);
                addToDbButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        }
    }

    @Override
    public void showLoadingDialog() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingDialog() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        showToastMessage(message);
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    private void loadMovieDetails() {
        if (mMovieDetailsPresenter != null) {
            mMovieDetailsPresenter.initialize(getCurrentMovieId());
        }
    }

    private int getCurrentMovieId() {
        Bundle args = getArguments();
        return args.getInt(PARAM_MOVIE_ID);
    }

    @OnClick(R.id.bt_add_to_db)
    public void onClick(Button button) {
        if (button.getText().toString().equals(getResources().getString(R.string.movie_to_add))) {
            mMovieDetailsPresenter.saveMovieToDB();
            button.setText(R.string.movie_added);
            button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        } else {
            mMovieDetailsPresenter.deleteMovieFromDB();
            button.setText(R.string.movie_to_add);
            button.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
    }
}
