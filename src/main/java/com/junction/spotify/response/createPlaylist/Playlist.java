package com.junction.spotify.response.createPlaylist;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.junction.spotify.response.userTracks.ExternalUrls;

public class Playlist {

    @SerializedName("collaborative")
    @Expose
    public boolean collaborative;
    @SerializedName("description")
    @Expose
    public Object description;
    @SerializedName("external_urls")
    @Expose
    public ExternalUrls externalUrls;
    @SerializedName("followers")
    @Expose
    public Followers followers;
    @SerializedName("href")
    @Expose
    public String href;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("images")
    @Expose
    public List<Object> images = null;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("owner")
    @Expose
    public Owner owner;
    @SerializedName("public")
    @Expose
    public boolean _public;
    @SerializedName("snapshot_id")
    @Expose
    public String snapshotId;
    @SerializedName("tracks")
    @Expose
    public Tracks tracks;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("uri")
    @Expose
    public String uri;

}

