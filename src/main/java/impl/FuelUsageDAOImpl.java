package com.ptfms.final_project.impl;

import com.ptfms.final_project.dao.DBConnection;
import com.ptfms.final_project.dao.FuelUsageDAO;
import com.ptfms.final_project.model.FuelUsage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * FuelUsage DAO Implementation - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class FuelUsageDAOImpl implements FuelUsageDAO {
    
    /**
     * Add fuel usage to database
     * @param fuelUsage fuel usage to add
     * @return true if successful
     */
    @Override
    public boolean addFuelUsage(FuelUsage fuelUsage) {
        String sql = "INSERT INTO fuel_usage (vehicle_id, amount, date) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, fuelUsage.getVehicleId());
            stmt.setDouble(2, fuelUsage.getAmount());
            stmt.setString(3, fuelUsage.getDate());
            
            int rows = stmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            System.out.println("Error adding fuel usage: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get all fuel usage from database
     * @return list of fuel usage
     */
    @Override
    public List<FuelUsage> getAllFuelUsage() {
        List<FuelUsage> fuelList = new ArrayList<>();
        String sql = "SELECT * FROM fuel_usage";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                FuelUsage fuel = new FuelUsage();
                fuel.setUsageId(rs.getInt("usage_id"));
                fuel.setVehicleId(rs.getInt("vehicle_id"));
                fuel.setAmount(rs.getDouble("amount"));
                fuel.setDate(rs.getString("date"));
                fuelList.add(fuel);
            }
            
        } catch (SQLException e) {
            System.out.println("Error getting fuel usage: " + e.getMessage());
        }
        
        return fuelList;
    }
}