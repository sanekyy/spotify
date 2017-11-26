package com.junction.spotify.retrofit;

import com.junction.spotify.response.audioAnalysis.AudioAnalysis;
import com.junction.spotify.response.createPlaylist.Playlist;
import com.junction.spotify.response.userTracks.UserTracks;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface RestService {

    @GET("audio-analysis/{id}")
    Call<AudioAnalysis> audioAnalysis(@Header("Authorization") String APIkey, @Path("id") String id);

    @GET("me/tracks")
    Call<UserTracks> userTracks(@Header("Authorization") String APIkey, @Query("limit") String limit, @Query("offset") String offset);

    @Headers("Content-Type: application/json")
    @POST("users/german-abramov123/playlists")
    Call<Playlist> createPlaylist(@Header("Authorization") String APIkey, @Body RequestBody body);

    @POST("users/german-abramov123/playlists/{playlist_id}/tracks")
    Call<ResponseBody> addTracksToPlaylist(@Header("Authorization") String APIkey, @Path("playlist_id") String playlistId, @Query("uris") String query);
}
