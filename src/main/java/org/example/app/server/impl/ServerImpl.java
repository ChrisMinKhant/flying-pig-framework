package org.example.app.server.impl;

import org.example.app.server.Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerImpl implements Server {

    private int port;

    public ServerImpl(int port) {
        this.port = port;
    }

    @Override
    public void start() throws IOException {

        ServerSocket mainServer = new ServerSocket(this.port);
        Socket clientSocket;

        showBanner();
        while (true) {

            clientSocket = mainServer.accept();

        }
    }

    @Override
    public void stop() {

    }

    private void showBanner() {
        System.out.println(" \n/$$$$$$$$/$$           /$$                           /$$$$$$$  /$$          \n" +
                "| $$_____/ $$          |__/                          | $$__  $$|__/          \n" +
                "| $$     | $$ /$$   /$$ /$$ /$$$$$$$   /$$$$$$       | $$  \\ $$ /$$  /$$$$$$ \n" +
                "| $$$$$  | $$| $$  | $$| $$| $$__  $$ /$$__  $$      | $$$$$$$/| $$ /$$__  $$\n" +
                "| $$__/  | $$| $$  | $$| $$| $$  \\ $$| $$  \\ $$      | $$____/ | $$| $$  \\ $$\n" +
                "| $$     | $$| $$  | $$| $$| $$  | $$| $$  | $$      | $$      | $$| $$  | $$\n" +
                "| $$     | $$|  $$$$$$$| $$| $$  | $$|  $$$$$$$      | $$      | $$|  $$$$$$$\n" +
                "|__/     |__/ \\____  $$|__/|__/  |__/ \\____  $$      |__/      |__/ \\____  $$\n" +
                "              /$$  | $$               /$$  \\ $$                     /$$  \\ $$\n" +
                "             |  $$$$$$/              |  $$$$$$/                    |  $$$$$$/\n" +
                "              \\______/                \\______/                      \\______/ \n");

        System.out.println( Server started at port :: " + this.port);
    }
}
