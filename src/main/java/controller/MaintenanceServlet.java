package com.ptfms.final_project.controller;

import com.ptfms.final_project.model.MaintenanceLog;
import com.ptfms.final_project.service.MaintenanceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Maintenance Servlet - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class MaintenanceServlet extends HttpServlet {
    
    private MaintenanceService maintenanceService = new MaintenanceService();
    
    /**
     * Handle GET request - show maintenance page
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<MaintenanceLog> maintenanceList = maintenanceService.getAllMaintenanceLogs();
        request.setAttribute("maintenanceList", maintenanceList);
        request.getRequestDispatcher("/jsp/maintenance.jsp").forward(request, response);
    }
    
    /**
     * Handle POST request - add maintenance log
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
        String partName = request.getParameter("partName");
        String status = request.getParameter("status");
        String date = request.getParameter("date");
        
        MaintenanceLog log = new MaintenanceLog(vehicleId, partName, status, date);
        maintenanceService.addMaintenanceLog(log);
        
        response.sendRedirect("maintenance");
    }
}