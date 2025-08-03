package com.ptfms.final_project.patterns;

/**
 * Consumption Strategy Interface - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public interface ConsumptionStrategy {
    
    /**
     * Calculate fuel efficiency
     * @param amount fuel amount
     * @return efficiency value
     */
    double calculateEfficiency(double amount);
}

/**
 * Bus Consumption Strategy
 */
class BusStrategy implements ConsumptionStrategy {
    
    /**
     * Calculate bus efficiency
     * @param amount fuel amount
     * @return efficiency value
     */
    @Override
    public double calculateEfficiency(double amount) {
        return amount * 0.8; // Simple calculation
    }
}

/**
 * Train Consumption Strategy
 */
class TrainStrategy implements ConsumptionStrategy {
    
    /**
     * Calculate train efficiency
     * @param amount fuel amount
     * @return efficiency value
     */
    @Override
    public double calculateEfficiency(double amount) {
        return amount * 0.6; // Simple calculation
    }
}