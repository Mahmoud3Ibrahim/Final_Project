package com.ptfms.final_project.impl;

import com.ptfms.final_project.dao.DBConnection;
import com.ptfms.final_project.dao.MaintenanceDAO;
import com.ptfms.final_project.model.MaintenanceLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Maintenance DAO Implementation - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class MaintenanceDAOImpl implements MaintenanceDAO {
    
    /**
     * Add maintenance log to database
     * @param log maintenance log to add
     * @return true if successful
     */
    @Override
    public boolean addMaintenanceLog(MaintenanceLog log) {
        String sql = "INSERT INTO maintenance_logs (vehicle_id, part_name, status, date) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, log.getVehicleId());
            stmt.setString(2, log.getPartName());
            stmt.setString(3, log.getStatus());
            stmt.setString(4, log.getDate());
            
            int rows = stmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            System.out.println("Error adding maintenance log: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get all maintenance logs from database
     * @return list of maintenance logs
     */
    @Override
    public List<MaintenanceLog> getAllMaintenanceLogs() {
        List<MaintenanceLog> maintenanceList = new ArrayList<>();
        String sql = "SELECT * FROM maintenance_logs";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                MaintenanceLog log = new MaintenanceLog();
                log.setLogId(rs.getInt("log_id"));
                log.setVehicleId(rs.getInt("vehicle_id"));
                log.setPartName(rs.getString("part_name"));
                log.setStatus(rs.getString("status"));
                log.setDate(rs.getString("date"));
                maintenanceList.add(log);
            }
            
        } catch (SQLException e) {
            System.out.println("Error getting maintenance logs: " + e.getMessage());
        }
        
        return maintenanceList;
    }
}