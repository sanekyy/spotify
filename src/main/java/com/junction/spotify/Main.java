package com.junction.spotify;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final MyService myService = new MyService();
        myService.start();
        Runtime.getRuntime().addShutdownHook(new Thread(myService::stop));
    }
}
