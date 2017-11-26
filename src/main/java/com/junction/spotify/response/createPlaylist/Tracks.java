package com.junction.spotify.response.createPlaylist;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tracks {

    @SerializedName("href")
    @Expose
    public String href;
    @SerializedName("items")
    @Expose
    public List<Object> items = null;
    @SerializedName("limit")
    @Expose
    public int limit;
    @SerializedName("next")
    @Expose
    public Object next;
    @SerializedName("offset")
    @Expose
    public int offset;
    @SerializedName("previous")
    @Expose
    public Object previous;
    @SerializedName("total")
    @Expose
    public int total;

}