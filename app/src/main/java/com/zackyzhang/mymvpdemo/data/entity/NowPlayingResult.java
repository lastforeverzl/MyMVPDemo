package com.zackyzhang.mymvpdemo.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lei on 1/27/17.
 */

public class NowPlayingResult<T> {

    /**
     * page : 1
     * results : []
     * dates : {"maximum":"2017-02-03","minimum":"2016-12-23"}
     * total_pages : 36
     * total_results : 718
     */

    @SerializedName("page")
    private int page;
    @SerializedName("dates")
    private Dates dates;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("results")
//    private List<Results> results;
    private T results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public static class Dates {
        /**
         * maximum : 2017-02-03
         * minimum : 2016-12-23
         */

        @SerializedName("maximum")
        private String maximum;
        @SerializedName("minimum")
        private String minimum;

        public String getMaximum() {
            return maximum;
        }

        public void setMaximum(String maximum) {
            this.maximum = maximum;
        }

        public String getMinimum() {
            return minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("page=" + page + " total_pages=" + totalPages + " total_results=" + totalResults);
        if (results != null) {
            sb.append(" results:" + results.toString());
        }
        return sb.toString();
    }
}
