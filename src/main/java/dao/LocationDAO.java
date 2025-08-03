package com.ptfms.final_project.dao;

import com.ptfms.final_project.model.Location;
import java.util.List;

/**
 * Location DAO Interface - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public interface LocationDAO {
    
    /**
     * Add location
     * @param location location to add
     * @return true if successful
     */
    boolean addLocation(Location location);
    
    /**
     * Get all locations
     * @return list of locations
     */
    List<Location> getAllLocations();
}