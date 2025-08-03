package com.ptfms.final_project.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintenance Observer Interface - SIMPLE VERSION
 */
public interface MaintenanceObserver {
    void update(String message);
}

/**
 * Maintenance Subject Class - SIMPLE VERSION
 */
class MaintenanceSubject {
    private List<MaintenanceObserver> observers = new ArrayList<>();
    
    public void addObserver(MaintenanceObserver observer) {
        observers.add(observer);
    }
    
    public void notifyObservers(String message) {
        for (MaintenanceObserver observer : observers) {
            observer.update(message);
        }
    }
}

/**
 * Manager Observer - SIMPLE VERSION
 */
class ManagerObserver implements MaintenanceObserver {
    @Override
    public void update(String message) {
        System.out.println("Manager Alert: " + message);
    }
}

/**
 * Brake Observer - SIMPLE VERSION
 */
class BrakeObserver implements MaintenanceObserver {
    @Override
    public void update(String message) {
        if (message.toLowerCase().contains("brake")) {
            System.out.println("Brake Alert: " + message);
        }
    }
}