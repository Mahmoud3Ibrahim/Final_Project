package com.ptfms.final_project.model;

/**
 * MaintenanceLog Model Class - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class MaintenanceLog {
    
    private int logId;
    private int vehicleId;
    private String partName;
    private String status;
    private String date;
    
    /**
     * Default constructor
     */
    public MaintenanceLog() {
    }
    
    /**
     * Constructor with parameters
     * @param vehicleId vehicle ID
     * @param partName part name
     * @param status maintenance status
     * @param date maintenance date
     */
    public MaintenanceLog(int vehicleId, String partName, String status, String date) {
        this.vehicleId = vehicleId;
        this.partName = partName;
        this.status = status;
        this.date = date;
    }
    
    /**
     * Get log ID
     * @return log ID
     */
    public int getLogId() {
        return logId;
    }
    
    /**
     * Set log ID
     * @param logId log ID
     */
    public void setLogId(int logId) {
        this.logId = logId;
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
     * Get part name
     * @return part name
     */
    public String getPartName() {
        return partName;
    }
    
    /**
     * Set part name
     * @param partName part name
     */
    public void setPartName(String partName) {
        this.partName = partName;
    }
    
    /**
     * Get maintenance status
     * @return maintenance status
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * Set maintenance status
     * @param status maintenance status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Get maintenance date
     * @return maintenance date
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Set maintenance date
     * @param date maintenance date
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * Convert to string
     * @return string representation
     */
    @Override
    public String toString() {
        return "MaintenanceLog{" +
                "logId=" + logId +
                ", vehicleId=" + vehicleId +
                ", partName='" + partName + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}