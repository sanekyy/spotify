package com.junction.spotify.response.audioAnalysis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Section {

    @SerializedName("start")
    @Expose
    public float start;
    @SerializedName("duration")
    @Expose
    public float duration;
    @SerializedName("confidence")
    @Expose
    public float confidence;
    @SerializedName("loudness")
    @Expose
    public float loudness;
    @SerializedName("tempo")
    @Expose
    public float tempo;
    @SerializedName("tempo_confidence")
    @Expose
    public float tempoConfidence;
    @SerializedName("key")
    @Expose
    public float key;
    @SerializedName("key_confidence")
    @Expose
    public float keyConfidence;
    @SerializedName("mode")
    @Expose
    public float mode;
    @SerializedName("mode_confidence")
    @Expose
    public float modeConfidence;
    @SerializedName("time_signature")
    @Expose
    public float timeSignature;
    @SerializedName("time_signature_confidence")
    @Expose
    public float timeSignatureConfidence;

}
