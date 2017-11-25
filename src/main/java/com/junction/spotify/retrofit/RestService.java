package com.junction.spotify.retrofit;

import com.junction.spotify.response.audioAnalysis.AudioAnalysis;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RestService {

    @Headers("Authorization: Bearer BQASEEIH4AeRMqyjvtK1u_g2lv4-OgNjlJe-_xnCBnFv8os5MJRTGvlsiH4R7TWRkrry_Zb_eF9OuNpHvuI1wEpxuc8990tvbhwiuhdjWgfKMPBCShXuXoN3wms3dKA2voQJbzbMnx_RsPn9Tb2LzA-d")
    @GET("audio-analysis/{id}")
    Call<AudioAnalysis> audioAnalysis(@Path("id") String id);
}
