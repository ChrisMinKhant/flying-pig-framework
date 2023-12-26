package org.example.app.implementation;

import jakarta.servlet.Servlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.example.app.Application;
import org.example.servlet.FirstFilter;
import org.example.servlet.SecondFilter;
import org.example.servlet.ThirdFilter;

import java.io.File;

/*
 * Application Class to start the server.
 */
public class ApplicationImplementation implements Application {

    private static Context context;

    private static final Tomcat tomcat = new Tomcat();

    // Initializing the server.
    @Override
    public void init() {
        showBanner();

        tomcat.setBaseDir("temp");
        tomcat.setHostname("localhost");
        tomcat.setPort(8080);
        tomcat.getConnector();

        context = tomcat.addContext("", new File(".").getAbsolutePath());

        Boot();

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }

    // Boot up all the registered servlet.
    @Override
    public void Boot() {

        /*
         * Bind the servlet with respective url.
         */

        RegisterServlet("/first_filter", "FirstFilter", new FirstFilter());
        RegisterServlet("/second_filter", "SecondFilter", new SecondFilter());
        RegisterServlet("/third_filter", "ThirdFilter", new ThirdFilter());
    }

    @Override
    public void stop() {

    }

    private void RegisterServlet(String url, String servletName, Servlet servlet) {
        tomcat.addServlet(context, servletName, servlet);
        context.addServletMappingDecoded(url, servletName);
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
    }
}