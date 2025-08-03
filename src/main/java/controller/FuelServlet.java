package com.ptfms.final_project.controller;

import com.ptfms.final_project.model.FuelUsage;
import com.ptfms.final_project.service.FuelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Fuel Servlet - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class FuelServlet extends HttpServlet {
    
    private FuelService fuelService = new FuelService();
    
    /**
     * Handle GET request - show fuel page
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<FuelUsage> fuelList = fuelService.getAllFuelUsage();
        request.setAttribute("fuelList", fuelList);
        request.getRequestDispatcher("/jsp/fuel.jsp").forward(request, response);
    }
    
    /**
     * Handle POST request - add fuel usage
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        
        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String date = request.getParameter("date");
        
        FuelUsage fuel = new FuelUsage(vehicleId, amount, date);
        fuelService.addFuelUsage(fuel);
        
        response.sendRedirect("fuel");
    }
}