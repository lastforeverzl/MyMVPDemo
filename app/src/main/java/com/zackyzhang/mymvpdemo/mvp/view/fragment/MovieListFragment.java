package com.zackyzhang.mymvpdemo.mvp.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;
import com.zackyzhang.mymvpdemo.di.component.MoviesComponent;
import com.zackyzhang.mymvpdemo.mvp.MovieListView;
import com.zackyzhang.mymvpdemo.mvp.presenter.MovieListPresenter;
import com.zackyzhang.mymvpdemo.mvp.view.adapter.MovieAdapter;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

/**
 * Created by lei on 2/2/17.
 */

public class MovieListFragment extends BaseFragment implements MovieListView {

    private final String TAG = "MovieListFragment";

    @BindView(R.id.movie_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.layout_progress)
    RelativeLayout progress;

    @Inject
    protected Picasso mPicasso;
    @Inject
    protected MovieListPresenter mMovieListPresenter;
    @Inject
    protected MovieAdapter mMovieAdapter;
    @Inject
    Context mContext;

    private MovieListListener mMovieListListener;
    private Unbinder unbinder;
    private boolean isLoadingMore = false;
    private boolean isLastPage = false;
    private View shareView;

    public MovieListFragment() {
        setRetainInstance(true);
    }

    public interface MovieListListener {
        void onMovieClicked(final NowPlayingMovie movie, View shareView);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MovieListListener) {
            this.mMovieListListener = (MovieListListener) context;
        }
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(MoviesComponent.class).inject(this);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        Log.d(TAG, "onCreateView");
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, this.toString());
        mMovieListPresenter.setView(this);
        if (savedInstanceState == null) {
            loadMovies();
            Log.d(TAG, "movies loaded!");
        }
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastVisibleItem = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = mRecyclerView.getLayoutManager().getItemCount();
                if (lastVisibleItem >= totalItemCount - 2 && dy > 0 && !isLastPage) {
                    if (!isLoadingMore) {
                        isLoadingMore = true;
                        mMovieListPresenter.getMoreMovies();
                    }
                }
            }
        });
        Log.d(TAG, "onViewCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        mMovieListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        mMovieListPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
        mRecyclerView.setAdapter(null);
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        mMovieListPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
        mMovieListListener = null;
    }

    @Override
    protected <T> T getComponent(Class<T> componentType) {
        return super.getComponent(componentType);
    }

    /**
     * Render movie list to adapter.
     * @param movies
     */
    @Override
    public void renderMovieList(List<NowPlayingMovie> movies, boolean isLastPage) {
        if (isLastPage) {
            this.isLastPage = true;
            this.isLoadingMore = false;
            showError("END");
            return;
        }
        if (movies != null) {
            mMovieAdapter.loadMovies(movies);
            isLoadingMore = false;
        }
    }

    @Override
    public void viewMovie(NowPlayingMovie movie) {
        if (this.mMovieListListener != null) {
            mMovieListListener.onMovieClicked(movie, this.shareView);
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
        return null;
    }

    private void setupRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mMovieAdapter.setOnItemClickListener(onItemClickListener);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(context()));
        mRecyclerView.setLayoutManager(new GridLayoutManager(context(), 2, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mMovieAdapter);
    }

    private MovieAdapter.OnItemClickListener onItemClickListener =
            new MovieAdapter.OnItemClickListener() {
                @Override
                public void onMovieItemClicked(NowPlayingMovie movie, View shareView) {
                    MovieListFragment.this.shareView = shareView;
                    if (MovieListFragment.this.mMovieListPresenter != null && movie != null) {
                        MovieListFragment.this.mMovieListPresenter.onMovieClicked(movie);
                    }
            }
    };

    private void loadMovies() {
        mMovieListPresenter.initialize();
    }
}
