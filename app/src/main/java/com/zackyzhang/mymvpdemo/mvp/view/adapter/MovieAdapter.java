package com.zackyzhang.mymvpdemo.mvp.view.adapter;

import com.squareup.picasso.Picasso;
import com.zackyzhang.mymvpdemo.Constants;
import com.zackyzhang.mymvpdemo.R;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zackyzhang.mymvpdemo.data.entity.NowPlayingMovie;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lei on 2/1/17.
 */
// TODO: 2/3/17 need to take a look at adapter.
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder> {

    private LayoutInflater mLayoutInflater;
    private List<NowPlayingMovie> mMovieList = new ArrayList<>();
    private Picasso mPicasso;

    @Inject
    public MovieAdapter(Context context, Picasso picasso) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


//        mLayoutInflater = inflater;
        mPicasso = picasso;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(mMovieList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public void loadMovies(List<NowPlayingMovie> movies) {
        mMovieList.addAll(movies);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_title) TextView mTitle;
        @BindView(R.id.movie_icon) ImageView mMovieIcon;

        private NowPlayingMovie mMovie;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(NowPlayingMovie movie) {
            mMovie = movie;
            Log.d("Adapter", mMovie.getOriginalTitle());
            mTitle.setText(mMovie.getOriginalTitle());
            mPicasso.load(Constants.IMAGE_DOMAIN + mMovie.getPosterPath())
                    .into(mMovieIcon);

        }
    }
}
