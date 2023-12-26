package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.request.record.ThirdFilterRequest;
import org.example.response.record.ThirdFilterResponse;
import org.example.util.GeneralUtil;

import java.io.IOException;

public class ThirdFilter extends HttpServlet {

    private GeneralUtil util = new GeneralUtil();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ThirdFilterRequest request = util.parseRequest(req, ThirdFilterRequest.class);

        ThirdFilterResponse response = new ThirdFilterResponse(false);

        if (request.secondFilterResponse()) {
            if (request.securityRating() > 4.5) {
                response = new ThirdFilterResponse(true);
            } else {
                response = new ThirdFilterResponse(false);
            }
        } else {
            response = new ThirdFilterResponse(false);
        }

        util.sendResponse(resp, response);
    }
}
