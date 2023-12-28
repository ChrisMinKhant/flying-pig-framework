package org.example;

import org.example.app.server.Server;
import org.example.app.server.impl.ServerImpl;

import java.io.IOException;

public abstract class Main {
    public static void main(String[] args) throws IOException {
        Server server = new ServerImpl(8080);
        server.start();
    }
}