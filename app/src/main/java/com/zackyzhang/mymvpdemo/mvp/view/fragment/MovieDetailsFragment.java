package com.zackyzhang.mymvpdemo.mvp.view.fragment;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.data.entity.MovieDetails.MovieEntity;
import com.zackyzhang.mymvpdemo.data.entity.MovieDetails.MovieGenre;
import com.zackyzhang.mymvpdemo.data.entity.MovieDetails.MovieVideos;
import com.zackyzhang.mymvpdemo.data.local.MoviesPersistenceContract;
import com.zackyzhang.mymvpdemo.di.component.MoviesComponent;
import com.zackyzhang.mymvpdemo.mvp.MovieDetailsView;
import com.zackyzhang.mymvpdemo.mvp.presenter.MovieDetailsPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @Inject
    MovieDetailsPresenter mMovieDetailsPresenter;

    @BindView(R.id.layout_progress)
    RelativeLayout progress;
    @BindView(R.id.test_fragment_detail)
    TextView testView;
    @BindView(R.id.bt_add_to_db)
    TextView addToDbButton;
    @BindView(R.id.rating_bar)
    RatingBar mRatingBar;
    @BindView(R.id.detail_movie_title)
    TextView mTitle;
    @BindView(R.id.detail_movie_overview)
    TextView mOverview;
    @BindView(R.id.test_text)
    TextView mTestText;
    @BindView(R.id.detail_release_date)
    TextView mReleaseDate;
    @BindView(R.id.detail_vote)
    TextView mVote;
    @BindView(R.id.detail_vote_count)
    TextView mVoteCount;
    @BindView(R.id.detail_genres)
    TextView mGenres;
    @BindView(R.id.detail_runtime)
    TextView mRuntime;

    private YouTubePlayer youTube;
    private String videoId;
    private VideoListener mVideoListener;

    public interface VideoListener {
        void sendVideoId(String videoId);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof VideoListener) {
            this.mVideoListener = (VideoListener) context;
        }
    }

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
        List<MovieVideos.ResultsBean> movieList = movie.getVideos().getResults();
        if (!movieList.isEmpty()) {
            videoId = movieList.get(0).getKey();
            mVideoListener.sendVideoId(videoId);
        }

        // TODO: 2/9/17 need to finish by UI.
        mTitle.setText(movie.getOriginalTitle());
        mOverview.setText(movie.getOverview());
        mTestText.setText(R.string.test_text);
        mVote.setText(String.valueOf(movie.getVoteAverage()) + " / 10");
        mVoteCount.setText(String.valueOf(movie.getVoteCount()));
        mReleaseDate.setText(movie.getReleaseDate());
        mRuntime.setText(movie.getRuntime() + " mins");
        loadAddToDbButton(movie);
        loadHomePage(movie);
        loadRatingBar(movie);
        loadGenres(movie);
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

    private void loadHomePage(MovieEntity movieEntity) {
        if ((movieEntity != null)) {
            testView.setText(movieEntity.getHomepage());
        }
    }

    private void loadGenres(MovieEntity movieEntity) {
        List<MovieGenre> genreList = movieEntity.getGenres();
        List genres = new ArrayList();
        for (MovieGenre genre : genreList) {
            genres.add(genre.getName());
        }
        mGenres.setText(genres.toString().replaceAll("[\\[\\]]", ""));
    }

    private void loadAddToDbButton(MovieEntity movieEntity) {
        addToDbButton.setVisibility(View.VISIBLE);
        if (movieEntity != null) {
            if (mMovieDetailsPresenter.isExist(movieEntity)) {
                Timber.tag(TAG).d("movie in watchlist");
                changeAddToDbButton(true);
            } else {
                Timber.tag(TAG).d("movie not in watchlist");
                changeAddToDbButton(false);
            }
        }
    }

    private void loadRatingBar(MovieEntity movieEntity) {
        if (movieEntity != null) {
            mRatingBar.setRating((float) movieEntity.getVoteAverage());
        }
    }

    private void changeAddToDbButton(boolean movieInDB) {
        if (movieInDB) {
            addToDbButton.setText(R.string.movie_added);
            addToDbButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.notselect_button, null));
        } else {
            addToDbButton.setText(R.string.movie_to_add);
            addToDbButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.selected_button, null));
        }
    }

    /*  create YouTube player in view.
    @Override
    public void loadYouTubePlayer() {
        Timber.tag(TAG).d("begin youtube");
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_fragment, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(Constants.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTube = youTubePlayer;
                youTube.setShowFullscreenButton(true);
                youTubePlayer.setFullscreenControlFlags(youTube.FULLSCREEN_FLAG_CONTROL_ORIENTATION);
                if (!b) {
                    youTube.cueVideo(videoId);
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getActivity(), youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Timber.tag(TAG).d("end youtube");
    }
    */

    private int getCurrentMovieId() {
        Bundle args = getArguments();
        return args.getInt(PARAM_MOVIE_ID);
    }

    @OnClick(R.id.bt_add_to_db)
    public void onClick(Button button) {
        Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha_anim);
        if (button.getText().toString().equals(getResources().getString(R.string.movie_to_add))) {
            mMovieDetailsPresenter.saveMovieToDB();
            addToDbButton.startAnimation(anim);
            changeAddToDbButton(true);

        } else {
            mMovieDetailsPresenter.deleteMovieFromDB();
            addToDbButton.startAnimation(anim);
            changeAddToDbButton(false);
        }
    }
}
