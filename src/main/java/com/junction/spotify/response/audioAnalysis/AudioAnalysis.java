package com.junction.spotify.response.audioAnalysis;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AudioAnalysis {

    @SerializedName("bars")
    @Expose
    public List<Bar> bars = null;
    @SerializedName("beats")
    @Expose
    public List<Beat> beats = null;
    @SerializedName("meta")
    @Expose
    public Meta meta;
    @SerializedName("sections")
    @Expose
    public List<Section> sections = null;
    @SerializedName("segments")
    @Expose
    public List<Segment> segments = null;
    @SerializedName("tatums")
    @Expose
    public List<Tatum> tatums = null;
    @SerializedName("track")
    @Expose
    public Track track;

}