package org.example.app.server;

import java.io.IOException;

public interface Server {
    void start() throws IOException;

    void stop();
}
