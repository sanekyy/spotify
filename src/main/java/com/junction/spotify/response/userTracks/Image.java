package com.junction.spotify.response.userTracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("height")
    @Expose
    public int height;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("width")
    @Expose
    public int width;

}
