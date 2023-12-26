package org.example;

import org.apache.catalina.LifecycleException;
import org.example.app.Application;
import org.example.app.implementation.ApplicationImplementation;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        Application application = new ApplicationImplementation();
        application.init();
    }
}