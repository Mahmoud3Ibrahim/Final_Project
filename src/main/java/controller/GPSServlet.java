package com.ptfms.final_project.controller;

import com.ptfms.final_project.model.Location;
import com.ptfms.final_project.service.GPSService;
import com.ptfms.final_project.service.GPSAdapterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * GPS Servlet - Now supports both manual entry and Adapter Pattern
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class GPSServlet extends HttpServlet {
    
    // Service for manual GPS operations
    private GPSService gpsService = new GPSService();
    
    // Service for external GPS integration using Adapter Pattern
    private GPSAdapterService gpsAdapterService = new GPSAdapterService();
    
    /**
     * Handle GET request - show GPS page
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Location> locationList = gpsService.getAllLocations();
        request.setAttribute("locationList", locationList);
        request.getRequestDispatcher("/jsp/gps.jsp").forward(request, response);
    }
    
    /**
     * Handle POST request - supports manual entry and external GPS sync
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ("sync_external".equals(action)) {
            // Use Adapter Pattern to sync from external GPS
            handleExternalGPSSync(request);
            
        } else {
            // Manual GPS entry (original functionality)
            handleManualEntry(request);
        }
        
        response.sendRedirect("gps");
    }
    
    /**
     * Handle manual GPS entry
     * @param request HTTP request
     */
    private void handleManualEntry(HttpServletRequest request) {
        try {
            int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
            String stationName = request.getParameter("stationName");
            String timestamp = request.getParameter("timestamp");
            
            Location location = new Location(vehicleId, stationName, timestamp);
            gpsService.addLocation(location);
            
            System.out.println("Manual GPS entry added for Vehicle " + vehicleId);
            
        } catch (Exception e) {
            System.out.println("Error in manual GPS entry: " + e.getMessage());
        }
    }
    
    /**
     * Handle external GPS synchronization using Adapter Pattern
     * @param request HTTP request
     */
    private void handleExternalGPSSync(HttpServletRequest request) {
        try {
            int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
            
            // This is where Adapter Pattern is used!
            boolean success = gpsAdapterService.syncFromExternalGPS(vehicleId);
            
            if (success) {
                System.out.println("External GPS sync completed for Vehicle " + vehicleId);
            } else {
                System.out.println("External GPS sync failed for Vehicle " + vehicleId);
            }
            
        } catch (Exception e) {
            System.out.println("Error in external GPS sync: " + e.getMessage());
        }
    }
}