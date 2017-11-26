package com.junction.spotify.response.createPlaylist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.junction.spotify.response.userTracks.ExternalUrls_;

public class Owner {

    @SerializedName("external_urls")
    @Expose
    public ExternalUrls_ externalUrls;
    @SerializedName("href")
    @Expose
    public String href;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("uri")
    @Expose
    public String uri;

}
