package com.junction.spotify.response.audioAnalysis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("num_samples")
    @Expose
    public int numSamples;
    @SerializedName("duration")
    @Expose
    public float duration;
    @SerializedName("sample_md5")
    @Expose
    public String sampleMd5;
    @SerializedName("offset_seconds")
    @Expose
    public int offsetSeconds;
    @SerializedName("window_seconds")
    @Expose
    public int windowSeconds;
    @SerializedName("analysis_sample_rate")
    @Expose
    public int analysisSampleRate;
    @SerializedName("analysis_channels")
    @Expose
    public float analysisChannels;
    @SerializedName("end_of_fade_in")
    @Expose
    public float endOfFadeIn;
    @SerializedName("start_of_fade_out")
    @Expose
    public float startOfFadeOut;
    @SerializedName("loudness")
    @Expose
    public float loudness;
    @SerializedName("tempo")
    @Expose
    public float tempo;
    @SerializedName("tempo_confidence")
    @Expose
    public float tempoConfidence;
    @SerializedName("time_signature")
    @Expose
    public float timeSignature;
    @SerializedName("time_signature_confidence")
    @Expose
    public float timeSignatureConfidence;
    @SerializedName("key")
    @Expose
    public float key;
    @SerializedName("key_confidence")
    @Expose
    public float keyConfidence;
    @SerializedName("mode")
    @Expose
    public int mode;
    @SerializedName("mode_confidence")
    @Expose
    public float modeConfidence;
    @SerializedName("codestring")
    @Expose
    public String codestring;
    @SerializedName("code_version")
    @Expose
    public float codeVersion;
    @SerializedName("echoprintstring")
    @Expose
    public String echoprintstring;
    @SerializedName("echoprint_version")
    @Expose
    public float echoprintVersion;
    @SerializedName("synchstring")
    @Expose
    public String synchstring;
    @SerializedName("synch_version")
    @Expose
    public int synchVersion;
    @SerializedName("rhythmstring")
    @Expose
    public String rhythmstring;
    @SerializedName("rhythm_version")
    @Expose
    public int rhythmVersion;

}
