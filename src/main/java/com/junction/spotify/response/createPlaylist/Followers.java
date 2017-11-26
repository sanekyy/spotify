package com.junction.spotify.response.createPlaylist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Followers {

    @SerializedName("href")
    @Expose
    public Object href;
    @SerializedName("total")
    @Expose
    public int total;

}

