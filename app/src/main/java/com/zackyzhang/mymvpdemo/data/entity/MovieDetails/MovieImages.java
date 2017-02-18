package com.zackyzhang.mymvpdemo.data.entity.MovieDetails;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lei on 2/8/17.
 */

public class MovieImages {
    @SerializedName("backdrops")
    private List<BackdropsBean> backdrops;
    @SerializedName("posters")
    private List<PostersBean> posters;

    public List<BackdropsBean> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<BackdropsBean> backdrops) {
        this.backdrops = backdrops;
    }

    public List<PostersBean> getPosters() {
        return posters;
    }

    public void setPosters(List<PostersBean> posters) {
        this.posters = posters;
    }

    public static class BackdropsBean {
        /**
         * aspect_ratio : 1.77777777777778
         * file_path : /xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg
         * height : 1080
         * iso_639_1 : null
         * vote_average : 5.55555555555556
         * vote_count : 15
         * width : 1920
         */

        @SerializedName("aspect_ratio")
        private double aspectRatio;
        @SerializedName("file_path")
        private String filePath;
        @SerializedName("height")
        private int height;
        @SerializedName("iso_639_1")
        private Object iso6391;
        @SerializedName("vote_average")
        private double voteAverage;
        @SerializedName("vote_count")
        private int voteCount;
        @SerializedName("width")
        private int width;

        public double getAspectRatio() {
            return aspectRatio;
        }

        public void setAspectRatio(double aspectRatio) {
            this.aspectRatio = aspectRatio;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Object getIso6391() {
            return iso6391;
        }

        public void setIso6391(Object iso6391) {
            this.iso6391 = iso6391;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }

    public static class PostersBean {
        /**
         * aspect_ratio : 0.6668
         * file_path : /nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg
         * height : 2500
         * iso_639_1 : en
         * vote_average : 5.94
         * vote_count : 51
         * width : 1667
         */

        @SerializedName("aspect_ratio")
        private double aspectRatio;
        @SerializedName("file_path")
        private String filePath;
        @SerializedName("height")
        private int height;
        @SerializedName("iso_639_1")
        private String iso6391;
        @SerializedName("vote_average")
        private double voteAverage;
        @SerializedName("vote_count")
        private int voteCount;
        @SerializedName("width")
        private int width;

        public double getAspectRatio() {
            return aspectRatio;
        }

        public void setAspectRatio(double aspectRatio) {
            this.aspectRatio = aspectRatio;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }
}
