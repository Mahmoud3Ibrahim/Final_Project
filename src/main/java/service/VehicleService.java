package com.ptfms.final_project.service;

import com.ptfms.final_project.dao.VehicleDAO;
import com.ptfms.final_project.impl.VehicleDAOImpl;
import com.ptfms.final_project.model.Vehicle;

import java.util.List;

/**
 * Vehicle Service - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class VehicleService {
    
    private VehicleDAO vehicleDAO = new VehicleDAOImpl();
    
    /**
     * Add new vehicle
     * @param vehicle vehicle to add
     * @return true if successful
     */
    public boolean addVehicle(Vehicle vehicle) {
        return vehicleDAO.addVehicle(vehicle);
    }
    
    /**
     * Get all vehicles
     * @return list of vehicles
     */
    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }
    
    /**
     * Get vehicle by ID
     * @param vehicleId vehicle ID
     * @return vehicle object
     */
    public Vehicle getVehicleById(int vehicleId) {
        return vehicleDAO.findVehicleById(vehicleId);
    }
    
    public boolean deleteVehicle(int vehicleId) {
    return vehicleDAO.deleteVehicle(vehicleId);
}

}