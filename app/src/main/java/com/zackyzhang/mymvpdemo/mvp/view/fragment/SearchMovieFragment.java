package com.zackyzhang.mymvpdemo.mvp.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.zackyzhang.mymvpdemo.mvp.presenter.SearchMoviePresenter;
import com.zackyzhang.mymvpdemo.mvp.view.adapter.MovieAdapter;
import com.zackyzhang.mymvpdemo.mvp.view.adapter.SearchMovieAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lei on 2/17/17.
 */

public class SearchMovieFragment extends BaseFragment implements MovieListView{

    @BindView(R.id.movie_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.layout_progress)
    RelativeLayout progress;
    @BindView(R.id.id_swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    protected Picasso mPicasso;
    @Inject
    protected SearchMoviePresenter mSearchMoviePresenter;
    @Inject
    protected SearchMovieAdapter mMovieAdapter;
    @Inject
    Context mContext;

    private SearchMovieListener mMovieListListener;
    private Unbinder unbinder;
    private boolean isLoadingMore = false;
    private boolean isLastPage = false;
    private View shareView;

    public SearchMovieFragment() {
        setRetainInstance(true);
    }

    public interface SearchMovieListener {
        void onMovieClicked(int movieId, String backdropPath, View shareView);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SearchMovieListener) {
            this.mMovieListListener = (SearchMovieListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(MoviesComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSearchMoviePresenter.setView(this);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastVisibleItem = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = mRecyclerView.getLayoutManager().getItemCount();
                if (lastVisibleItem >= totalItemCount - 2 && dy > 0 && !isLastPage) {
                    if (!isLoadingMore) {
                        isLoadingMore = true;
                        mSearchMoviePresenter.getMoreMovies();
                    }
                }
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mSearchMoviePresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mSearchMoviePresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRecyclerView.setAdapter(null);
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSearchMoviePresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mMovieListListener = null;
    }

    @Override
    protected <T> T getComponent(Class<T> componentType) {
        return super.getComponent(componentType);
    }

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
            mMovieListListener.onMovieClicked(movie.getId(), movie.getBackdropPath(), this.shareView);
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

    /**
     * Get search text from activity.
     * @param query
     */
    public void searchMovie(String query) {
        loadMovies(query);
    }

    @Override
    public void initAdapter() {
        mMovieAdapter.clearAdapter();
    }

    private void setupRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mMovieAdapter.setOnItemClickListener(onItemClickListener);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context()));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(context(), 2, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mMovieAdapter);
    }

    private SearchMovieAdapter.OnItemClickListener onItemClickListener =
            new SearchMovieAdapter.OnItemClickListener() {
                @Override
                public void onMovieItemClicked(NowPlayingMovie movie, View shareView) {
                    SearchMovieFragment.this.shareView = shareView;
                    if (SearchMovieFragment.this.mSearchMoviePresenter != null && movie != null) {
                        SearchMovieFragment.this.mSearchMoviePresenter.onMovieClicked(movie);
                    }
                }
            };

    private void loadMovies(String query) {
        mSearchMoviePresenter.initialize(query);
    }



}
