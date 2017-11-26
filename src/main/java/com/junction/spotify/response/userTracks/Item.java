package com.junction.spotify.response.userTracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("added_at")
    @Expose
    public String addedAt;
    @SerializedName("track")
    @Expose
    public Track track;

}
