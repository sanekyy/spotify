package com.junction.spotify.processing;

import com.junction.spotify.MyService;
import com.junction.spotify.response.userTracks.Item;
import com.junction.spotify.response.userTracks.Track;
import com.junction.spotify.response.userTracks.UserTracks;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetAllUserTracks {

    private final String APIkey;
    private final int limit = 50;
    List<Track> tracks;
    private int offset = 0;


    public GetAllUserTracks(String apIkey) {
        APIkey = apIkey;
        tracks = new ArrayList<>();
    }


    public GetAudioAnalysis getAllUserTracks() {

        try {
            Response<UserTracks> response = MyService.restService.userTracks(APIkey, String.valueOf(limit), String.valueOf(offset)).execute();
            for (Item item : response.body().items) {
                tracks.add(item.track);
            }

            if (tracks.size() < response.body().total) {
                offset += limit;
                return getAllUserTracks();
            } else {
                return new GetAudioAnalysis(APIkey, tracks);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return getAllUserTracks();
        }
    }


}
