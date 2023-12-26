package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.request.record.SecondFilterRequest;
import org.example.response.record.SecondFilterResponse;
import org.example.util.GeneralUtil;

import java.io.IOException;
import java.util.Random;

public class SecondFilter extends HttpServlet {

    private static GeneralUtil util = new GeneralUtil();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SecondFilterRequest request = util.parseRequest(req, SecondFilterRequest.class);

        SecondFilterResponse response = new SecondFilterResponse(false,0.0f);

        if (request.firstFilterResponse()) {
            if (!request.signature().isEmpty()) {
                response = new SecondFilterResponse(true,new Random().nextFloat(4.4f,5.0f));
            } else {
                response = new SecondFilterResponse(false,0.0f);
            }
        } else {
            response = new SecondFilterResponse(false,0.0f);
        }

        util.sendResponse(resp, response);
    }
}
