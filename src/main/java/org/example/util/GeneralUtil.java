package org.example.util;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneralUtil {
    public <T> T parseRequest(HttpServletRequest request, Class<T> clazz) {
        String line;
        BufferedReader reader = null;
        StringBuilder resultString = new StringBuilder();
        Gson gson = new Gson();

        try {

            reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                resultString.append(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(" fetched result string >>>  " + gson.fromJson(resultString.toString(), clazz));

        return gson.fromJson(resultString.toString(), clazz);
    }

    public void sendResponse(HttpServletResponse response, Object source) {
        response.setContentType("application/json");
        Gson gson = new Gson();

        try {

            PrintWriter responseWriter = response.getWriter();
            responseWriter.print(gson.toJson(source));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
