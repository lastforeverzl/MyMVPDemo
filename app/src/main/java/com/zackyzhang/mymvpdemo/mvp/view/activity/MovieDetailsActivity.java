package com.zackyzhang.mymvpdemo.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeIntents;
import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.di.HasComponent;
import com.zackyzhang.mymvpdemo.di.component.DaggerMoviesComponent;
import com.zackyzhang.mymvpdemo.di.component.MoviesComponent;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.MovieDetailsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lei on 2/8/17.
 */

public class MovieDetailsActivity extends BaseActivity implements HasComponent<MoviesComponent>, MovieDetailsFragment.VideoListener {

    private static final String INTENT_EXTRA_PARAM_MOVIE_ID = "com.zackyzhang.mymvpdemo.INTENT_EXTRA_PARAM_MOVIE_ID";
    private static final String INTENT_EXTRA_PARAM_MOVIE_IMAGE = "com.zackyzhang.mymvpdemo.INTENT_EXTRA_PARAM_MOVIE_IMAGE";
    private static final String INSTANCE_STATE_PARAM_MOVIE_ID = "com.zackyzhang.mymvpdemo.INSTANCE_STATE_PARAM_MOVIE_ID";

    public static Intent getCallingIntent(Context context, int movieId, String image) {
        Intent callingIntent = new Intent(context, MovieDetailsActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_MOVIE_ID, movieId);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_MOVIE_IMAGE, image);
        return callingIntent;
    }

    private int mMovieId;
    private String mMovieImage;
    private MoviesComponent mMoviesComponent;
    private String videoId;

    @BindView(R.id.details_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.test_fragment_detail_image2)
    ImageView testshareView;
    @BindView(R.id.video_button)
    Button playVideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);

        this.initializeActivity(savedInstanceState);
        this.resolveDaggerDependency();
        this.initializeView();

        // Activity transition test.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            testshareView.setTransitionName("shareViewTest");
        }
        mPicasso.load(Constants.BACKDROP_IMAGE_DOMAIN + mMovieImage)
                .fit()
                .into(testshareView);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.putInt(INSTANCE_STATE_PARAM_MOVIE_ID, mMovieId);
            outState.putString(INTENT_EXTRA_PARAM_MOVIE_IMAGE, mMovieImage);
        }
        super.onSaveInstanceState(outState);
    }

    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.mMovieId = getIntent().getIntExtra(INTENT_EXTRA_PARAM_MOVIE_ID, -1);
            this.mMovieImage = getIntent().getStringExtra(INTENT_EXTRA_PARAM_MOVIE_IMAGE);
            addFragment(R.id.fragmentContainer, MovieDetailsFragment.forMovie(mMovieId));
        } else {
            this.mMovieId = savedInstanceState.getInt(INSTANCE_STATE_PARAM_MOVIE_ID);
            this.mMovieImage = savedInstanceState.getString(INTENT_EXTRA_PARAM_MOVIE_IMAGE);
        }
    }

    private void resolveDaggerDependency() {
        this.mMoviesComponent = DaggerMoviesComponent.builder()
                .activityModule(getActivityModule())
                .applicationComponent(getApplicationComponent())
                .build();
    }

    private void initializeView() {
        mToolbar.setTitle("MOVIE DETAIL");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                supportFinishAfterTransition();
            }
        });
        playVideo.setVisibility(View.GONE);
    }

    @Override
    public MoviesComponent getComponent() {
        return mMoviesComponent;
    }

    @Override
    public void sendVideoId(String videoId) {
        if (videoId != null) {
            this.videoId = videoId;
            playVideo.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.video_button)
    public void click() {
        this.mNavigator.navigateToYouTube(this, videoId);
    }
}
