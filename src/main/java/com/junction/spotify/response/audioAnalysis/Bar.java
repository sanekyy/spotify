package com.junction.spotify.response.audioAnalysis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bar {

    @SerializedName("start")
    @Expose
    public float start;
    @SerializedName("duration")
    @Expose
    public float duration;
    @SerializedName("confidence")
    @Expose
    public float confidence;

}