package com.junction.spotify.response.userTracks;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("album")
    @Expose
    public Album album;
    @SerializedName("artists")
    @Expose
    public List<Artist_> artists = null;
    @SerializedName("available_markets")
    @Expose
    public List<String> availableMarkets = null;
    @SerializedName("disc_number")
    @Expose
    public int discNumber;
    @SerializedName("duration_ms")
    @Expose
    public int durationMs;
    @SerializedName("explicit")
    @Expose
    public boolean explicit;
    @SerializedName("external_ids")
    @Expose
    public ExternalIds externalIds;
    @SerializedName("external_urls")
    @Expose
    public ExternalUrls___ externalUrls;
    @SerializedName("href")
    @Expose
    public String href;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("popularity")
    @Expose
    public int popularity;
    @SerializedName("preview_url")
    @Expose
    public String previewUrl;
    @SerializedName("track_number")
    @Expose
    public int trackNumber;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("uri")
    @Expose
    public String uri;

}
