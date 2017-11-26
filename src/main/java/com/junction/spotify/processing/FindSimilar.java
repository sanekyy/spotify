package com.junction.spotify.processing;

import com.junction.spotify.MyService;
import com.junction.spotify.handlers.BaseHandler;
import com.junction.spotify.response.AudioWrapper;
import com.junction.spotify.response.createPlaylist.Playlist;
import com.sun.net.httpserver.HttpExchange;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class FindSimilar {

    private final String APIkey;

    private final List<AudioWrapper> audioAnalyses;

    private final List<AudioWrapper> modeConfirmed;

    private final List<AudioWrapper> keysConfirmed;

    private final List<AudioWrapper> loudnessConfirmed;

    private final List<AudioWrapper> tempConfirmed;

    private final List<AudioWrapper> playlist;

    private final HttpExchange httpExchange;

    FindSimilar(String APIkey, List<AudioWrapper> audioAnalyses, HttpExchange httpExchange) {
        this.APIkey = APIkey;
        this.audioAnalyses = audioAnalyses;
        this.httpExchange = httpExchange;

        tempConfirmed = new ArrayList<>();
        loudnessConfirmed = new ArrayList<>();
        keysConfirmed = new ArrayList<>();
        playlist = new ArrayList<>();
        modeConfirmed = new ArrayList<>();
    }

    void find() {
        AudioWrapper currTrack = audioAnalyses.remove(0);
        playlist.add(currTrack);

        while (playlist.size() < 10) {
            for (AudioWrapper track : audioAnalyses) {
                if (currTrack.audioAnalysis.track.mode == track.audioAnalysis.track.mode &&
                        currTrack.audioAnalysis.track.modeConfidence > 0.2 && track.audioAnalysis.track.modeConfidence > 0.2) {
                    modeConfirmed.add(track);
                }
            }

            for (AudioWrapper track : modeConfirmed) {
                if (Math.abs(currTrack.audioAnalysis.track.key - track.audioAnalysis.track.key) < 2 &&
                        currTrack.audioAnalysis.track.keyConfidence > 0.2 && track.audioAnalysis.track.keyConfidence > 0.2) {
                    keysConfirmed.add(track);
                }
            }

            for (AudioWrapper track : keysConfirmed) {
                if (Math.abs(currTrack.audioAnalysis.track.loudness - track.audioAnalysis.track.loudness) < 10) {
                    loudnessConfirmed.add(track);
                }
            }

            for (AudioWrapper track : loudnessConfirmed) {
                if (Math.abs(currTrack.audioAnalysis.track.tempo - track.audioAnalysis.track.tempo) < 15 &&
                        currTrack.audioAnalysis.track.tempoConfidence > 0.2 && track.audioAnalysis.track.tempoConfidence > 0.2) {
                    tempConfirmed.add(track);
                }
            }


            if(tempConfirmed.size() > 0){
                currTrack = tempConfirmed.get(0);
            } else if(loudnessConfirmed.size() > 0){
                currTrack = loudnessConfirmed.get(0);
            } else if(keysConfirmed.size() > 0){
                currTrack = keysConfirmed.get(0);
            } else if(modeConfirmed.size() > 0){
                currTrack = modeConfirmed.get(0);
            } else if(audioAnalyses.size() > 0){
                currTrack = audioAnalyses.get(0);
            } else {
                break;
            }

            audioAnalyses.remove(currTrack);
            playlist.add(currTrack);

            modeConfirmed.clear();
            keysConfirmed.clear();
            loudnessConfirmed.clear();
            tempConfirmed.clear();
        }



        String playlistName = String.valueOf(new Random(System.currentTimeMillis()).nextLong());

        String requestText = "{\n" +
                "  \"name\": \"" + playlistName + "\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": true\n" +
                "}";

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), requestText.getBytes());


        MyService.restService.createPlaylist(APIkey, requestBody).enqueue(new Callback<Playlist>() {
            @Override
            public void onResponse(Call<Playlist> call, Response<Playlist> response) {
                if(response.code() != 201){
                    System.out.println(response.toString());
                } else {
                    String playlistId = response.body().id;
                    StringBuilder stringBuilder = new StringBuilder();
                    for(int i = 0; i < playlist.size() - 1; i++){
                        stringBuilder.append(playlist.get(i).track.uri).append(",");
                    }

                    stringBuilder.append(playlist.get(playlist.size() - 1).track.uri);
                    String request = stringBuilder.toString();
                    MyService.restService.addTracksToPlaylist(APIkey, playlistId, request).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            BaseHandler.sendResponse(httpExchange, BaseHandler.Code.OK, playlistId.getBytes());
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Playlist> call, Throwable t) {

            }
        });
    }
}
