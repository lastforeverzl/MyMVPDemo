package com.zackyzhang.mymvpdemo.data.entity.Movie;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lei on 2/8/17.
 */

public class MovieProductionCompany {
    /**
     * name : Paramount Pictures
     * id : 4
     */

    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
