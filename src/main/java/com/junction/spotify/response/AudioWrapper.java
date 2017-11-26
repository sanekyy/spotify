package com.junction.spotify.response;

import com.junction.spotify.response.audioAnalysis.AudioAnalysis;
import com.junction.spotify.response.userTracks.Track;

public class AudioWrapper {

    public Track track;

    public AudioAnalysis audioAnalysis;

    public AudioWrapper(Track track, AudioAnalysis audioAnalysis){
        this.track = track;
        this.audioAnalysis = audioAnalysis;
    }
}
