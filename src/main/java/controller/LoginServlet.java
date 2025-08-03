package com.ptfms.final_project.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private Map<String, String[]> users = new HashMap<>();

    @Override
    public void init() {
        users.put("manager@example.com", new String[]{"pass123", "Manager"});
        users.put("operator@example.com", new String[]{"pass123", "Operator"});
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if ("login".equals(action)) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (users.containsKey(email) && users.get(email)[0].equals(password)) {
                session.setAttribute("userEmail", email);
                session.setAttribute("userRole", users.get(email)[1]);
                response.sendRedirect(request.getContextPath() + "/dashboard");
            } else {
                response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?error=Invalid credentials");
            }
        } 
        else if ("register".equals(action)) {
            String email = request.getParameter("email");
            if (!users.containsKey(email)) {
                users.put(email, new String[]{
                    request.getParameter("password"),
                    request.getParameter("role")
                });
                response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?message=Registration successful");
            } else {
                response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?error=Email already exists");
            }
        }
    }
}