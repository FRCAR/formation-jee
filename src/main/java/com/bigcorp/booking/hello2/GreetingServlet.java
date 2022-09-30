/*
 * Copyright (c) 2014, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.bigcorp.booking.hello2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigcorp.booking.model.Restaurant;
import com.bigcorp.booking.service.RestaurantService;

/**
 * This is a simple example of an HTTP Servlet. It responds to the GET method of
 * the HTTP protocol.
 */
@WebServlet("/welcome")
public class GreetingServlet extends HttpServlet {
	
	@Inject
	RestaurantService restaurantService;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        restaurantService.findByName("coucou");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Booking</title></head>");
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<h2>Welcome to the bookinggg app servlet page !!!</h2>");
            
            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
                RequestDispatcher dispatcher =
                        getServletContext().getRequestDispatcher("/response");
                
                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
            out.println("</body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "The Hello servlet says hello.";

    }
}
