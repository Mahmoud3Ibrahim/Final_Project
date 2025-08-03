package com.ptfms.final_project.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = request.getServletPath();
        
        if ("/dashboard".equals(path)) {
            request.getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
        } 
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}