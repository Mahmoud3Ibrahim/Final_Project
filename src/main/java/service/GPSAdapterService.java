package com.ptfms.final_project.service;

import com.ptfms.final_project.patterns.GPSAdapter;
import com.ptfms.final_project.patterns.ExternalGPSService;
import com.ptfms.final_project.dao.LocationDAO;
import com.ptfms.final_project.impl.LocationDAOImpl;
import com.ptfms.final_project.model.Location;

/**
 * GPS Adapter Service - Uses Adapter Pattern to integrate external GPS
 * @author Tianxin Gu  
 * @author Mahmoud Ibrahim
 */
public class GPSAdapterService {
    
    private GPSAdapter gpsAdapter;
    private LocationDAO locationDAO;
    
    /**
     * Constructor - Initialize Adapter Pattern components
     */
    public GPSAdapterService() {
        ExternalGPSService externalGPS = new ExternalGPSService();
        this.gpsAdapter = new GPSAdapter(externalGPS);
        this.locationDAO = new LocationDAOImpl();
        
        System.out.println("GPS Adapter Service initialized with Adapter Pattern");
    }
    
    /**
     * Sync location from external GPS using Adapter Pattern
     * @param vehicleId vehicle ID
     * @return true if successful
     */
    public boolean syncFromExternalGPS(int vehicleId) {
        // Use Adapter Pattern to get location from external GPS
        Location location = gpsAdapter.getLocation(vehicleId);
        
        // Save to database
        boolean success = locationDAO.addLocation(location);
        
        if (success) {
            System.out.println("Adapter Pattern Success: Vehicle " + vehicleId + 
                             " location synced from external GPS - " + location.getStationName());
        } else {
            System.out.println("Failed to save GPS location for Vehicle " + vehicleId);
        }
        
        return success;
    }
}