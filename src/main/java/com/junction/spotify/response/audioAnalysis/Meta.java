package com.junction.spotify.response.audioAnalysis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("analyzer_version")
    @Expose
    public String analyzerVersion;
    @SerializedName("platform")
    @Expose
    public String platform;
    @SerializedName("detailed_status")
    @Expose
    public String detailedStatus;
    @SerializedName("status_code")
    @Expose
    public int statusCode;
    @SerializedName("timestamp")
    @Expose
    public int timestamp;
    @SerializedName("analysis_time")
    @Expose
    public float analysisTime;
    @SerializedName("input_process")
    @Expose
    public String inputProcess;

}