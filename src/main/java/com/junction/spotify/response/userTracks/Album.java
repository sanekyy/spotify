package com.junction.spotify.response.userTracks;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("album_type")
    @Expose
    public String albumType;
    @SerializedName("artists")
    @Expose
    public List<Artist> artists = null;
    @SerializedName("available_markets")
    @Expose
    public List<String> availableMarkets = null;
    @SerializedName("external_urls")
    @Expose
    public ExternalUrls_ externalUrls;
    @SerializedName("href")
    @Expose
    public String href;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("images")
    @Expose
    public List<Image> images = null;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("uri")
    @Expose
    public String uri;

}
