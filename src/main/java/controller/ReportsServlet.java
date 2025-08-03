package com.ptfms.final_project.controller;

import com.ptfms.final_project.model.Vehicle;
import com.ptfms.final_project.model.FuelUsage;
import com.ptfms.final_project.model.Location;
import com.ptfms.final_project.model.MaintenanceLog;
import com.ptfms.final_project.service.VehicleService;
import com.ptfms.final_project.service.FuelService;
import com.ptfms.final_project.service.GPSService;
import com.ptfms.final_project.service.MaintenanceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Reports Servlet - Collect real data from all DAOs
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class ReportsServlet extends HttpServlet {
    
    // Services to get data from database
    private VehicleService vehicleService = new VehicleService();
    private FuelService fuelService = new FuelService();
    private GPSService gpsService = new GPSService();
    private MaintenanceService maintenanceService = new MaintenanceService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // Get all data from database
            List<Vehicle> vehicles = vehicleService.getAllVehicles();
            List<FuelUsage> fuelList = fuelService.getAllFuelUsage();
            List<Location> locationList = gpsService.getAllLocations();
            List<MaintenanceLog> maintenanceList = maintenanceService.getAllMaintenanceLogs();
            
            // Calculate basic statistics
            int totalVehicles = vehicles != null ? vehicles.size() : 0;
            int totalFuelRecords = fuelList != null ? fuelList.size() : 0;
            int totalGPSLocations = locationList != null ? locationList.size() : 0;
            int totalMaintenanceLogs = maintenanceList != null ? maintenanceList.size() : 0;
            
            // Count vehicle types
            int busCount = 0, trainCount = 0, railCount = 0;
            if (vehicles != null) {
                for (Vehicle v : vehicles) {
                    String type = v.getVehicleType().toLowerCase();
                    if (type.contains("bus")) busCount++;
                    else if (type.contains("train")) trainCount++;
                    else if (type.contains("rail")) railCount++;
                }
            }
            
            // Calculate fuel statistics
            double totalFuelConsumption = 0;
            if (fuelList != null) {
                for (FuelUsage fuel : fuelList) {
                    totalFuelConsumption += fuel.getAmount();
                }
            }
            
            // Count maintenance by status
            int scheduledCount = 0, completedCount = 0, overdueCount = 0, inProgressCount = 0;
            if (maintenanceList != null) {
                for (MaintenanceLog log : maintenanceList) {
                    String status = log.getStatus().toLowerCase();
                    if (status.contains("scheduled")) scheduledCount++;
                    else if (status.contains("completed")) completedCount++;
                    else if (status.contains("overdue")) overdueCount++;
                    else if (status.contains("progress")) inProgressCount++;
                }
            }
            
            // Send all data to JSP
            request.setAttribute("totalVehicles", totalVehicles);
            request.setAttribute("totalFuelRecords", totalFuelRecords);
            request.setAttribute("totalGPSLocations", totalGPSLocations);
            request.setAttribute("totalMaintenanceLogs", totalMaintenanceLogs);
            
            request.setAttribute("busCount", busCount);
            request.setAttribute("trainCount", trainCount);
            request.setAttribute("railCount", railCount);
            
            request.setAttribute("totalFuelConsumption", totalFuelConsumption);
            
            request.setAttribute("scheduledCount", scheduledCount);
            request.setAttribute("completedCount", completedCount);
            request.setAttribute("overdueCount", overdueCount);
            request.setAttribute("inProgressCount", inProgressCount);
            
            // Forward to reports page
            request.getRequestDispatcher("/jsp/reports.jsp").forward(request, response);
            
        } catch (Exception e) {
            // Handle any errors
            System.out.println("Error in ReportsServlet: " + e.getMessage());
            e.printStackTrace();
            
            // Send zeros if error occurs
            request.setAttribute("totalVehicles", 0);
            request.setAttribute("totalFuelRecords", 0);
            request.setAttribute("totalGPSLocations", 0);
            request.setAttribute("totalMaintenanceLogs", 0);
            request.setAttribute("busCount", 0);
            request.setAttribute("trainCount", 0);
            request.setAttribute("railCount", 0);
            request.setAttribute("totalFuelConsumption", 0.0);
            request.setAttribute("scheduledCount", 0);
            request.setAttribute("completedCount", 0);
            request.setAttribute("overdueCount", 0);
            request.setAttribute("inProgressCount", 0);
            
            request.getRequestDispatcher("/jsp/reports.jsp").forward(request, response);
        }
    }
}