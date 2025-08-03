package com.ptfms.final_project.model;

/**
 * Vehicle Model Class - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class Vehicle {

    private int vehicleId;
    private String vehicleNumber;
    private String vehicleType;

    /**
     * Default constructor
     */
    public Vehicle() {
    }

    /**
     * Constructor with parameters
     * @param vehicleNumber vehicle number
     * @param vehicleType vehicle type
     */
    private Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
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
     * @param vehicleId vehicle ID to set
     */
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Get vehicle number
     * @return vehicle number
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * Set vehicle number
     * @param vehicleNumber vehicle number to set
     */
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    /**
     * Get vehicle type
     * @return vehicle type
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Set vehicle type
     * @param vehicleType vehicle type to set
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * Convert to string
     * @return string representation
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }

/**
 * Vehicle Builder Pattern - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public static class VehicleBuilder {

    private String vehicleNumber;
    private String vehicleType;

    /**
     * Set vehicle number
     * @param vehicleNumber vehicle number
     * @return builder instance
     */

    public VehicleBuilder setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    /**
     * Set vehicle type
     * @param vehicleType vehicle type
     * @return builder instance
     */
    public VehicleBuilder setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    /**
     * Build vehicle object
     * @return built vehicle
     */
    public Vehicle build() {
        return new Vehicle(vehicleNumber, vehicleType);
    }
}
}