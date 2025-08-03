package com.ptfms.final_project.dao;

import com.ptfms.final_project.model.FuelUsage;
import java.util.List;

/**
 * FuelUsage DAO Interface - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public interface FuelUsageDAO {
    
    /**
     * Add fuel usage
     * @param fuelUsage fuel usage to add
     * @return true if successful
     */
    boolean addFuelUsage(FuelUsage fuelUsage);
    
    /**
     * Get all fuel usage records
     * @return list of fuel usage
     */
    List<FuelUsage> getAllFuelUsage();
}