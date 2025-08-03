package com.ptfms.final_project.model;

/**
 * Location Model Class - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class Location {
    
    private int locationId;
    private int vehicleId;
    private String stationName;
    private String timestamp;
    
    /**
     * Default constructor
     */
    public Location() {
    }
    
    /**
     * Constructor with parameters
     * @param vehicleId vehicle ID
     * @param stationName station name
     * @param timestamp time stamp
     */
    public Location(int vehicleId, String stationName, String timestamp) {
        this.vehicleId = vehicleId;
        this.stationName = stationName;
        this.timestamp = timestamp;
    }
    
    
    
    /**
     * Get location ID
     * @return location ID
     */
    public int getLocationId() {
        return locationId;
    }
    
    /**
     * Set location ID
     * @param locationId location ID
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    
    /**
     * Get vehicle ID
     * @return vehicle ID
     */
    public int getVehicleId() {
        return vehicleId;
    }
    
    /**
     * Set vehicle ID
     * @param vehicleId vehicle ID
     */
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    /**
     * Get station name
     * @return station name
     */
    public String getStationName() {
        return stationName;
    }
    
    /**
     * Set station name
     * @param stationName station name
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    
    /**
     * Get timestamp
     * @return timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }
    
    /**
     * Set timestamp
     * @param timestamp timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * Convert to string
     * @return string representation
     */
    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", vehicleId=" + vehicleId +
                ", stationName='" + stationName + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}