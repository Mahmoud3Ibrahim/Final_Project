package com.ptfms.final_project.service;

import com.ptfms.final_project.dao.MaintenanceDAO;
import com.ptfms.final_project.impl.MaintenanceDAOImpl;
import com.ptfms.final_project.model.MaintenanceLog;
import java.util.List;

/**
 * Maintenance Service - Simple Version with Observer Pattern
 * This service handles maintenance operations and notifies observers
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class MaintenanceService {
    
    // Database access object for maintenance operations
    private MaintenanceDAO maintenanceDAO = new MaintenanceDAOImpl();
    
    // Observer manager to handle notifications
    private ObserverManager observerManager = new ObserverManager();
    
    /**
     * Constructor - Initialize the service
     * Sets up the observer pattern automatically
     */
    public MaintenanceService() {
        System.out.println("Maintenance Service initialized with Observer Pattern");
    }
    
    /**
     * Add a new maintenance log to database and notify observers
     * @param log The maintenance log to add
     * @return true if successful, false otherwise
     */
    public boolean addMaintenanceLog(MaintenanceLog log) {
        // Try to save to database first
        boolean success = maintenanceDAO.addMaintenanceLog(log);
        
        if (success) {
            // Create notification message
            String message = "Vehicle " + log.getVehicleId() + " - " + 
                           log.getPartName() + " status: " + log.getStatus();
            
            // Notify all observers (Observer Pattern)
            observerManager.notifyAllObservers(message);
            
            System.out.println("Maintenance log added successfully and observers notified");
        } else {
            System.out.println("Failed to add maintenance log");
        }
        
        return success;
    }
    
    /**
     * Get all maintenance logs from database
     * @return List of all maintenance logs
     */
    public List<MaintenanceLog> getAllMaintenanceLogs() {
        return maintenanceDAO.getAllMaintenanceLogs();
    }
    
    /**
     * Inner class to manage observers (Observer Pattern Implementation)
     * This class handles all the observer notifications
     */
    private class ObserverManager {
        
        /**
         * Notify all observers about maintenance changes
         * @param message The message to send to observers
         */
        public void notifyAllObservers(String message) {
            // Manager Observer - gets all notifications
            notifyManager(message);
            
            // Brake Observer - only gets brake-related notifications
            notifyBrakeObserver(message);
            
            // Engine Observer - only gets engine-related notifications  
            notifyEngineObserver(message);
        }
        
        /**
         * Notify the manager about any maintenance activity
         * @param message The maintenance message
         */
        private void notifyManager(String message) {
            System.out.println(" MANAGER ALERT: " + message);
            
            // Special alert for overdue maintenance
            if (message.toLowerCase().contains("overdue")) {
                System.out.println("URGENT: This maintenance is overdue and needs immediate attention!");
            }
        }
        
        /**
         * Notify brake observer only for brake-related maintenance
         * @param message The maintenance message
         */
        private void notifyBrakeObserver(String message) {
            if (message.toLowerCase().contains("brake")) {
                System.out.println("BRAKE ALERT: " + message);
                
                // Critical alert for overdue brake maintenance
                if (message.toLowerCase().contains("overdue")) {
                    System.out.println("CRITICAL: Brake maintenance is overdue - SAFETY RISK!");
                }
            }
        }
        
        /**
         * Notify engine observer only for engine-related maintenance
         * @param message The maintenance message
         */
        private void notifyEngineObserver(String message) {
            if (message.toLowerCase().contains("engine")) {
                System.out.println("⚙️  ENGINE ALERT: " + message);
                
                // Critical alert for overdue engine maintenance
                if (message.toLowerCase().contains("overdue")) {
                    System.out.println("CRITICAL: Engine maintenance is overdue - PERFORMANCE RISK!");
                }
            }
        }
    }
}