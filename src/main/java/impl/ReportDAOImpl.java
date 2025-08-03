package com.ptfms.final_project.impl;

import com.ptfms.final_project.dao.DBConnection;
import com.ptfms.final_project.dao.ReportDAO;
import com.ptfms.final_project.model.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Report DAO Implementation - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class ReportDAOImpl implements ReportDAO {
    
    /**
     * Add report to database
     * @param report report to add
     * @return true if successful
     */
    @Override
    public boolean addReport(Report report) {
        String sql = "INSERT INTO reports (report_type, report_title, report_data) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, report.getReportType());
            stmt.setString(2, report.getReportTitle());
            stmt.setString(3, report.getReportData());
            
            int rows = stmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            System.out.println("Error adding report: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get all reports from database
     * @return list of reports
     */
    @Override
    public List<Report> getAllReports() {
        List<Report> reportList = new ArrayList<>();
        String sql = "SELECT * FROM reports";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Report report = new Report();
                report.setReportId(rs.getInt("report_id"));
                report.setReportType(rs.getString("report_type"));
                report.setReportTitle(rs.getString("report_title"));
                report.setReportData(rs.getString("report_data"));
                reportList.add(report);
            }
            
        } catch (SQLException e) {
            System.out.println("Error getting reports: " + e.getMessage());
        }
        
        return reportList;
    }
}