package com.junction.spotify;

import com.junction.spotify.response.audioAnalysis.AudioAnalysis;
import com.junction.spotify.retrofit.RestService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

    public static void main(String[] args) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        httpClient.addInterceptor(logging);

        RestService service = new Retrofit.Builder()
                        .baseUrl("https://api.spotify.com/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build().create(RestService.class);

        service.audioAnalysis("72WZtWs6V7uu3aMgMmEkYe").enqueue(new Callback<AudioAnalysis>() {
            @Override
            public void onResponse(Call<AudioAnalysis> call, Response<AudioAnalysis> response) {
                System.out.println(response.body().track.numSamples);
            }

            @Override
            public void onFailure(Call<AudioAnalysis> call, Throwable t) {
                System.out.println("NOT OK");
                t.printStackTrace();
            }
        });

    }
}
