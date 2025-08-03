package com.ptfms.final_project.model;

/**
 * FuelUsage Model Class - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class FuelUsage {
    
    private int usageId;
    private int vehicleId;
    private double amount;
    private String date;
    
    /**
     * Default constructor
     */
    public FuelUsage() {
    }
    
    /**
     * Constructor with parameters
     * @param vehicleId vehicle ID
     * @param amount fuel amount
     * @param date usage date
     */
    public FuelUsage(int vehicleId, double amount, String date) {
        this.vehicleId = vehicleId;
        this.amount = amount;
        this.date = date;
    }
    
    /**
     * Get usage ID
     * @return usage ID
     */
    public int getUsageId() {
        return usageId;
    }
    
    /**
     * Set usage ID
     * @param usageId usage ID
     */
    public void setUsageId(int usageId) {
        this.usageId = usageId;
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
     * Get fuel amount
     * @return fuel amount
     */
    public double getAmount() {
        return amount;
    }
    
    /**
     * Set fuel amount
     * @param amount fuel amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    /**
     * Get usage date
     * @return usage date
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Set usage date
     * @param date usage date
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
        return "FuelUsage{" +
                "usageId=" + usageId +
                ", vehicleId=" + vehicleId +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}