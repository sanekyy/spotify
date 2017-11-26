package com.junction.spotify.handlers;

import com.junction.spotify.MyService;
import com.sun.istack.internal.NotNull;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class BaseHandler implements HttpHandler {
    private static final String PREFIX_API_KEY = "APIkey=";

    @NotNull
    private final MyService service;
    @NotNull
    HttpHandler handler;

    BaseHandler(@NotNull MyService service) {
        this.service = service;

    }

    public static synchronized void sendResponse(
            @NotNull final HttpExchange httpExchange,
            final int code,
            @NotNull final byte[] body) {
        try {
            httpExchange.sendResponseHeaders(code, body.length);
            httpExchange.getResponseBody().write(body);
        } catch (IOException ignored) {
        } finally {
            httpExchange.close();
        }
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        try {
            handler.handle(httpExchange);
        } catch (IllegalArgumentException e) {
            sendResponse(httpExchange, Code.BAD_REQUEST, Body.BAD_REQUEST);
            httpExchange.close();
        } catch (Exception e) {
            httpExchange.close();
        }
    }

    @NotNull
    String extractAPIkey(@NotNull final String query) {
        String[] subqueries = query.split("&");

        for (String subquery : subqueries) {
            if (subquery.startsWith(PREFIX_API_KEY)) {
                if (query.length() == PREFIX_API_KEY.length()) {
                    throw new IllegalArgumentException();
                }
                return subquery.substring(PREFIX_API_KEY.length());
            }
        }
        throw new IllegalArgumentException("Shitty string");
    }


    public static class Code {
        public static final int OK = 200;
        static final int CREATED = 201;
        static final int ACCEPTED = 202;
        static final int BAD_REQUEST = 400;
        static final int NOT_FOUND = 404;
        static final int METHOD_NOT_ALLOWED = 405;
        static final int NOT_ENOUGH_REPLICAS = 504;
    }

    public static class Body {
        static final byte[] STATUS_ONLINE = "Online".getBytes();
        static final byte[] CREATED = "Created".getBytes();
        static final byte[] ACCEPTED = "Accepted".getBytes();
        static final byte[] BAD_REQUEST = "Bad request".getBytes();
        static final byte[] NOT_FOUND = "Not found".getBytes();
        static final byte[] METHOD_NOT_ALLOWED = "Method Not Allowed".getBytes();
        static final byte[] NOT_ENOUGH_REPLICAS = "Not Enough Replicas".getBytes();
    }
}
