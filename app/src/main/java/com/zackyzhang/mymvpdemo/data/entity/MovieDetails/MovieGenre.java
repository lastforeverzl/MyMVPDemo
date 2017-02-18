package com.zackyzhang.mymvpdemo.data.entity.MovieDetails;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lei on 2/8/17.
 */

public class MovieGenre {
    /**
     * id : 12
     * name : Adventure
     */

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
