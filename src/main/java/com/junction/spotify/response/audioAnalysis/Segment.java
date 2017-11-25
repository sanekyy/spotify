package com.junction.spotify.response.audioAnalysis;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Segment {

    @SerializedName("start")
    @Expose
    public float start;
    @SerializedName("duration")
    @Expose
    public float duration;
    @SerializedName("confidence")
    @Expose
    public float confidence;
    @SerializedName("loudness_start")
    @Expose
    public float loudnessStart;
    @SerializedName("loudness_max_time")
    @Expose
    public float loudnessMaxTime;
    @SerializedName("loudness_max")
    @Expose
    public float loudnessMax;
    @SerializedName("loudness_end")
    @Expose
    public float loudnessEnd;
    @SerializedName("pitches")
    @Expose
    public List<Float> pitches = null;
    @SerializedName("timbre")
    @Expose
    public List<Float> timbre = null;

}
