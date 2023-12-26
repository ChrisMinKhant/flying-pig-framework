package org.example.app;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;

public interface Application {
    void init();

    void Boot();

    void stop();
}
