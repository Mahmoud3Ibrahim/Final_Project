package com.ptfms.final_project.impl;

import com.ptfms.final_project.dao.DBConnection;
import com.ptfms.final_project.dao.LocationDAO;
import com.ptfms.final_project.model.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Location DAO Implementation - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class LocationDAOImpl implements LocationDAO {
    
    /**
     * Add location to database
     * @param location location to add
     * @return true if successful
     */
    @Override
    public boolean addLocation(Location location) {
        String sql = "INSERT INTO locations (vehicle_id, station_name, timestamp) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, location.getVehicleId());
            stmt.setString(2, location.getStationName());
            stmt.setString(3, location.getTimestamp());
            
            int rows = stmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            System.out.println("Error adding location: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get all locations from database
     * @return list of locations
     */
    @Override
    public List<Location> getAllLocations() {
        List<Location> locationList = new ArrayList<>();
        String sql = "SELECT * FROM locations";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Location location = new Location();
                location.setLocationId(rs.getInt("location_id"));
                location.setVehicleId(rs.getInt("vehicle_id"));
                location.setStationName(rs.getString("station_name"));
                location.setTimestamp(rs.getString("timestamp"));
                locationList.add(location);
            }
            
        } catch (SQLException e) {
            System.out.println("Error getting locations: " + e.getMessage());
        }
        
        return locationList;
    }
}