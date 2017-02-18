package com.zackyzhang.mymvpdemo.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lei on 2/17/17.
 */

public class SearchMovies<T> {

    @SerializedName("page")
    private int page;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("results")
    private T results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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
