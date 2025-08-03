package com.ptfms.final_project.service;

import com.ptfms.final_project.dao.ReportDAO;
import com.ptfms.final_project.impl.ReportDAOImpl;
import com.ptfms.final_project.model.Report;

import java.util.List;

/**
 * Report Service - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class ReportService {
    
    private ReportDAO reportDAO = new ReportDAOImpl();
    
    /**
     * Add report
     * @param report report to add
     * @return true if successful
     */
    public boolean addReport(Report report) {
        return reportDAO.addReport(report);
    }
    
    /**
     * Get all reports
     * @return list of reports
     */
    public List<Report> getAllReports() {
        return reportDAO.getAllReports();
    }
    
    /**
     * Generate vehicle report
     * @return generated report
     */
    public Report generateVehicleReport() {
        return new Report("Vehicle", "Fleet Report", "Total vehicles: 7");
    }
    
    /**
     * Generate fuel report
     * @return generated report
     */
    public Report generateFuelReport() {
        return new Report("Fuel", "Fuel Usage Report", "Total fuel consumption: 1250L");
    }
}