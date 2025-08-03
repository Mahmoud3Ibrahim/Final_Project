package com.ptfms.final_project.patterns;

import com.ptfms.final_project.model.Location;

/**
 * GPS Adapter Pattern - Converts external GPS data to our internal format
 * This is the main Adapter Pattern class
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class GPSAdapter {
    
    private ExternalGPSService externalGPS;
    
    /**
     * Constructor
     * @param externalGPS external GPS service instance
     */
    public GPSAdapter(ExternalGPSService externalGPS) {
        this.externalGPS = externalGPS;
        System.out.println("GPS Adapter initialized - ready to convert external GPS data");
    }
    
    /**
     * Get location from external GPS and convert to our format
     * This is the main Adapter Pattern method - converts incompatible interfaces
     * @param vehicleId vehicle ID to track
     * @return Location object in our system format
     */
    public Location getLocation(int vehicleId) {
        try {
            // Get raw data from external GPS system (different format)
            String gpsData = externalGPS.getGPSData(vehicleId);
            
            // Convert external format to our internal Location format
            Location location = convertToLocation(vehicleId, gpsData);
            
            System.out.println("GPS Adapter: Successfully converted external data to Location object");
            return location;
            
        } catch (Exception e) {
            System.out.println("GPS Adapter Error: " + e.getMessage());
            
            // Return default location in case of error
            return new Location(vehicleId, "Unknown Station", getCurrentTimestamp());
        }
    }
    
    /**
     * Convert external GPS string format to our Location object
     * @param vehicleId vehicle ID
     * @param gpsData raw GPS data string from external system
     * @return converted Location object
     */
    private Location convertToLocation(int vehicleId, String gpsData) {
        // Parse external GPS format: "StationName,Timestamp"
        String[] parts = gpsData.split(",");
        
        String stationName = parts.length > 0 ? parts[0].trim() : "Unknown Station";
        String timestamp = parts.length > 1 ? parts[1].trim() : getCurrentTimestamp();
        
        // Create Location object in our system format
        return new Location(vehicleId, stationName, timestamp);
    }
    
    /**
     * Get current timestamp
     * @return current timestamp string
     */
    private String getCurrentTimestamp() {
        return java.time.LocalDateTime.now().toString();
    }
}