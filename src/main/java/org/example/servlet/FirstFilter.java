package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.request.record.FirstFilterRequest;
import org.example.response.record.FirstFilterResponse;
import org.example.util.GeneralUtil;

import java.io.IOException;
import java.util.UUID;

public class FirstFilter extends HttpServlet {
    private static GeneralUtil util = new GeneralUtil();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FirstFilterRequest request = util.parseRequest(req, FirstFilterRequest.class);

        String temporaryString = "This is right answer";
        String temporaryStringTwo = "Hello World";

        byte[] firstByte = temporaryString.getBytes();
        byte[] secondByte = temporaryString.getBytes();
        System.out.println(" Bit AND manipulation >>> ");

        FirstFilterResponse response = new FirstFilterResponse(false, null);

        if (request.inputNumber() > 10) {
            response = new FirstFilterResponse(true, UUID.randomUUID().toString());
        } else {
            response = new FirstFilterResponse(false, null);
        }

        util.sendResponse(resp, response);
    }
}
