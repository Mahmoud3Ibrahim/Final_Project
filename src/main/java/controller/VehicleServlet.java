package com.ptfms.final_project.controller;

import com.ptfms.final_project.model.Vehicle;
import com.ptfms.final_project.service.VehicleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Vehicle Servlet - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class VehicleServlet extends HttpServlet {
    
    private VehicleService vehicleService = new VehicleService();
    
    /**
     * Handle GET request - show vehicles page
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        request.setAttribute("vehicles", vehicles);
        request.getRequestDispatcher("/jsp/vehicles.jsp").forward(request, response);
    }
    
    /**
     * Handle POST request - add vehicle
     */
 @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String action = request.getParameter("action");
    if (action == null) action = "add";  // fallback in case no action provided

    switch (action) {
        case "delete":
            int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
            vehicleService.deleteVehicle(vehicleId);

            
            break;

        case "add":
        default:
            String vehicleNumber = request.getParameter("vehicleNumber");
            String vehicleType = request.getParameter("vehicleType");

            Vehicle vehicle = new Vehicle.VehicleBuilder()
                    .setVehicleNumber(vehicleNumber)
                    .setVehicleType(vehicleType)
                    .build();

            vehicleService.addVehicle(vehicle);
            break;
    }

    response.sendRedirect("vehicles");
}



}