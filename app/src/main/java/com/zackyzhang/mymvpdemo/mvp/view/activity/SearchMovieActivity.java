package com.zackyzhang.mymvpdemo.mvp.view.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zackyzhang.mymvpdemo.R;
import com.zackyzhang.mymvpdemo.di.HasComponent;
import com.zackyzhang.mymvpdemo.di.component.DaggerMoviesComponent;
import com.zackyzhang.mymvpdemo.di.component.MoviesComponent;
import com.zackyzhang.mymvpdemo.mvp.view.fragment.SearchMovieFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lei on 2/17/17.
 */

public class SearchMovieActivity extends BaseActivity implements HasComponent<MoviesComponent>,
        SearchMovieFragment.SearchMovieListener{

    private MoviesComponent mMoviesComponent;

    @BindView(R.id.search_toolbar)
    Toolbar mToolbar;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, SearchMovieActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        this.resolveDaggerDependency();
        if (savedInstanceState == null) {
            addFragment(R.id.search_fragmentContainer, new SearchMovieFragment());
        }
        initView();
    }

    private void resolveDaggerDependency() {
        this.mMoviesComponent = DaggerMoviesComponent.builder()
                .activityModule(getActivityModule())
                .applicationComponent(getApplicationComponent())
                .build();
    }

    private void initView() {
        mToolbar.setTitle("SEARCH");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public MoviesComponent getComponent() {
        return mMoviesComponent;
    }

    @Override
    public void onMovieClicked(int movieId, String backdropPath, View shareView) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SearchMovieActivity.this, shareView, "shareViewTest");
            this.mNavigator.navigateToMovieDetails(this, movieId, backdropPath, options.toBundle());
        } else {
            this.mNavigator.navigateToMovieDetails(this, movieId, backdropPath, null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_item);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setIconifiedByDefault(false);
        searchView.onActionViewExpanded();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchMovieFragment fragment = (SearchMovieFragment) getSupportFragmentManager().findFragmentById(R.id.search_fragmentContainer);
                fragment.searchMovie(query);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
