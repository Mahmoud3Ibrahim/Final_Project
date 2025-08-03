package com.ptfms.final_project.dao;

import com.ptfms.final_project.model.Vehicle;
import java.util.List;

/**
 * Vehicle DAO Interface - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public interface VehicleDAO {
    
    /**
     * Add new vehicle
     * @param vehicle vehicle to add
     * @return true if successful
    
    
    */
    boolean addVehicle(Vehicle vehicle);
    
   
    
    /**
     * Get all vehicles
     * @return list of all vehicles
     */
    List<Vehicle> getAllVehicles();
    
    /**
     * @param vehicleId vehicle ID
     * @return vehicle object
     */
    Vehicle findVehicleById(int vehicleId);
    
    boolean deleteVehicle(int vehicleId);

}