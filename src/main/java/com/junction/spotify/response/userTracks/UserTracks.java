package com.junction.spotify.response.userTracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class UserTracks {

    @SerializedName("href")
    @Expose
    public String href;
    @SerializedName("items")
    @Expose
    public List<Item> items = null;
    @SerializedName("limit")
    @Expose
    public int limit;
    @SerializedName("next")
    @Expose
    public String next;
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