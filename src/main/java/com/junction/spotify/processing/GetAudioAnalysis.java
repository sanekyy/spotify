package com.junction.spotify.processing;

import com.junction.spotify.MyService;
import com.junction.spotify.response.audioAnalysis.AudioAnalysis;
import com.junction.spotify.response.AudioWrapper;
import com.junction.spotify.response.userTracks.Track;
import com.sun.net.httpserver.HttpExchange;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class GetAudioAnalysis {

    private final String APIkey;

    private final List<Track> tracks;
    
    private final List<AudioWrapper> audioAnalyses;

    private HttpExchange httpExchange;

    public GetAudioAnalysis(String apIkey, List<Track> tracks) {
        APIkey = apIkey;
        this.tracks = tracks;
        audioAnalyses = new ArrayList<>();
    }
    
    public void getAudioAnalysis(HttpExchange httpExchange){
        this.httpExchange = httpExchange;
        for(final Track track : tracks){
            MyService.restService.audioAnalysis(APIkey, track.id).enqueue(new Callback<AudioAnalysis>() {
                @Override
                public void onResponse(Call<AudioAnalysis> call, Response<AudioAnalysis> response) {
                    if(response.code() == 429){
                        MyService.restService.audioAnalysis(APIkey, track.id).enqueue(this);

                    } else {
                        add(track, response.body());
                    }
                }

                @Override
                public void onFailure(Call<AudioAnalysis> call, Throwable t) {
                    MyService.restService.audioAnalysis(APIkey, track.id).enqueue(this);
                }
            });
        }
    }

    private synchronized void add(Track track, AudioAnalysis audioAnalysis){
        audioAnalyses.add(new AudioWrapper(track, audioAnalysis));
        if(audioAnalyses.size() == tracks.size()){
            new FindSimilar(APIkey, audioAnalyses, httpExchange).find();
        }
    }
}
