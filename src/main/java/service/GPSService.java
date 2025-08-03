package com.ptfms.final_project.service;

import com.ptfms.final_project.dao.LocationDAO;
import com.ptfms.final_project.impl.LocationDAOImpl;
import com.ptfms.final_project.model.Location;

import java.util.List;

/**
 * GPS Service - SIMPLE VERSION with Database
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class GPSService {
    
    private LocationDAO locationDAO = new LocationDAOImpl();
    
    /**
     * Add location
     * @param location location to add
     * @return true if successful
     */
    public boolean addLocation(Location location) {
        return locationDAO.addLocation(location);
    }
    
    /**
     * Get all locations
     * @return list of locations
     */
    public List<Location> getAllLocations() {
        return locationDAO.getAllLocations();
    }
}