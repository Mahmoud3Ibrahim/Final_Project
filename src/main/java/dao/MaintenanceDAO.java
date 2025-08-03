package com.ptfms.final_project.dao;

import com.ptfms.final_project.model.MaintenanceLog;
import java.util.List;

/**
 * Maintenance DAO Interface - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public interface MaintenanceDAO {
    
    /**
     * Add maintenance log
     * @param log maintenance log to add
     * @return true if successful
     */
    boolean addMaintenanceLog(MaintenanceLog log);
    
    /**
     * Get all maintenance logs
     * @return list of maintenance logs
     */
    List<MaintenanceLog> getAllMaintenanceLogs();
}