package com.junction.spotify;

import com.junction.spotify.handlers.MakePlaylist;
import com.junction.spotify.retrofit.RestService;
import com.sun.istack.internal.NotNull;
import com.sun.net.httpserver.HttpServer;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MyService {

    @NotNull
    public static RestService restService;

    @NotNull
    private final HttpServer server;

    public MyService() throws IOException {
        this.server = HttpServer.create(
                new InetSocketAddress("localhost", 8080),
                0
        );

        this.server.createContext(
                "/makePlaylist",
                new MakePlaylist(this)
        );


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        restService = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build().create(RestService.class);

    }


    public void start() {
        this.server.start();
    }

    public void stop() {
        this.server.stop(0);
    }
}
