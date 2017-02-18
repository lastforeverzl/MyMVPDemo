package com.zackyzhang.mymvpdemo.data.entity;

/**
 * Created by lei on 2/17/17.
 */

public class MovieInDB {

    private int movieId;

    private String posterPath;

    private String backdropPath;

    private String overview;

    private String originalTitle;

    private double voteAverage;

    public MovieInDB(int movieId, String originalTitle, String overview, String posterPath, String backdropPath, double voteAverage) {
        this.movieId = movieId;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.overview = overview;
        this.originalTitle = originalTitle;
        this.voteAverage = voteAverage;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
