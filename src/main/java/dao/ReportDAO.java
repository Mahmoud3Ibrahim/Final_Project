package com.ptfms.final_project.dao;

import com.ptfms.final_project.model.Report;
import java.util.List;

/**
 * Report DAO Interface - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public interface ReportDAO {
    
    /**
     * Add report
     * @param report report to add
     * @return true if successful
     */
    boolean addReport(Report report);
    
    /**
     * Get all reports
     * @return list of reports
     */
    List<Report> getAllReports();
}