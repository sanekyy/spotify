package com.junction.spotify.handlers;

import com.junction.spotify.MyService;
import com.junction.spotify.processing.GetAllUserTracks;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class MakePlaylist extends BaseHandler {

    private final HttpHandler handler = httpExchange -> {
        switch (httpExchange.getRequestMethod()) {
            case "GET":
                handleGet(httpExchange);
                break;
            default:
                sendResponse(httpExchange, Code.METHOD_NOT_ALLOWED, Body.METHOD_NOT_ALLOWED);
        }
    };

    public MakePlaylist(final MyService service) {
        super(service);
        super.handler = handler;
    }

    private void handleGet(final HttpExchange httpExchange) throws IOException {
        final String APIkey = "Bearer " + extractAPIkey(httpExchange.getRequestURI().getQuery());

        new GetAllUserTracks(APIkey).getAllUserTracks().getAudioAnalysis(httpExchange);
    }
}
