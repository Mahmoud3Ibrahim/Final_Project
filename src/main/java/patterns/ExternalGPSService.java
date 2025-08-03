package com.ptfms.final_project.patterns;

/**
 * External GPS Service - Simulates third-party GPS provider
 * This represents the external system that we need to adapt to
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class ExternalGPSService {
    
    /**
     * Get GPS data from external system
     * This method simulates an external GPS API that returns data in a different format
     * @param vehicleId vehicle ID to track
     * @return GPS data in external format (comma-separated string)
     */
    public String getGPSData(int vehicleId) {
        // Generate realistic station names based on vehicle ID
        String[] stations = {
            "Downtown Transit Center",
            "University Campus", 
            "Shopping Mall Plaza",
            "Airport Terminal",
            "City Hall Station",
            "Hospital District",
            "Sports Complex",
            "Business District",
            "Subway Station A",
            "Metro Stop B"
        };
        
        // Use vehicle ID to select station (simulate different locations)
        String stationName = stations[vehicleId % stations.length];
        
        // Generate current timestamp
        String timestamp = java.time.LocalDateTime.now()
               .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        // External system returns data as comma-separated string
        String gpsData = stationName + "," + timestamp;
        
        System.out.println("External GPS: Providing data for Vehicle " + vehicleId + " - " + gpsData);
        return gpsData;
    }
    
    /**
     * Check if external GPS service is available
     * @return service status message
     */
    public String getServiceStatus() {
        return "External GPS Service: Online and operational";
    }
}