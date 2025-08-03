package com.ptfms.final_project.service;

import com.ptfms.final_project.dao.FuelUsageDAO;
import com.ptfms.final_project.impl.FuelUsageDAOImpl;
import com.ptfms.final_project.model.FuelUsage;

import java.util.List;

/**
 * Fuel Service - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class FuelService {
    
    private FuelUsageDAO fuelDAO = new FuelUsageDAOImpl();
    
    /**
     * Add fuel usage
     * @param fuelUsage fuel usage to add
     * @return true if successful
     */
    public boolean addFuelUsage(FuelUsage fuelUsage) {
        return fuelDAO.addFuelUsage(fuelUsage);
    }
    
    /**
     * Get all fuel usage
     * @return list of fuel usage
     */
    public List<FuelUsage> getAllFuelUsage() {
        return fuelDAO.getAllFuelUsage();
    }
}