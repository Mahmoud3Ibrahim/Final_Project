package com.ptfms.final_project.impl;

import com.ptfms.final_project.dao.DBConnection;
import com.ptfms.final_project.dao.VehicleDAO;
import com.ptfms.final_project.model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Vehicle DAO Implementation - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class VehicleDAOImpl implements VehicleDAO {
    
    /**
     * Add new vehicle to database
     * @param vehicle vehicle to add
     * @return true if successful
     */
    @Override
    public boolean addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (vehicle_number, vehicle_type) VALUES (?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, vehicle.getVehicleNumber());
            stmt.setString(2, vehicle.getVehicleType());
            
            int rows = stmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            System.out.println("Error adding vehicle: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get all vehicles from database
     * @return list of all vehicles
     */
    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("vehicle_id"));
                vehicle.setVehicleNumber(rs.getString("vehicle_number"));
                vehicle.setVehicleType(rs.getString("vehicle_type"));
                vehicles.add(vehicle);
            }
            
        } catch (SQLException e) {
            System.out.println("Error getting vehicles: " + e.getMessage());
        }
        
        return vehicles;
    }
    
    /**
     * Find vehicle by ID
     * @param vehicleId vehicle ID
     * @return vehicle object
     */
    @Override
    public Vehicle findVehicleById(int vehicleId) {
        String sql = "SELECT * FROM vehicles WHERE vehicle_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, vehicleId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("vehicle_id"));
                vehicle.setVehicleNumber(rs.getString("vehicle_number"));
                vehicle.setVehicleType(rs.getString("vehicle_type"));
                return vehicle;
            }
            
        } catch (SQLException e) {
            System.out.println("Error finding vehicle: " + e.getMessage());
        }
        
        return null;
    }
    
    @Override
public boolean deleteVehicle(int vehicleId) {
    String sql = "DELETE FROM vehicles WHERE vehicle_id = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, vehicleId);
        int rows = stmt.executeUpdate();
        return rows > 0;

    } catch (SQLException e) {
        System.out.println("Error deleting vehicle: " + e.getMessage());
        return false;
    }
}



}