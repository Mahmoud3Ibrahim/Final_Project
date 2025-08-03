-- SIMPLE Database Schema for PTFMS
-- Updated to match the simple Java models

DROP DATABASE IF EXISTS ptfms_db;
CREATE DATABASE ptfms_db;
USE ptfms_db;

-- Users table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('Manager', 'Operator', 'Maintenance') NOT NULL
);

-- Simple Vehicles table
CREATE TABLE vehicles (
    vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_number VARCHAR(50) UNIQUE NOT NULL,
    vehicle_type VARCHAR(50) NOT NULL
);

-- Simple Fuel Usage table
CREATE TABLE fuel_usage (
    usage_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT NOT NULL,
    amount DOUBLE NOT NULL,
    date VARCHAR(20) NOT NULL
);

-- Simple GPS Locations table
CREATE TABLE locations (
    location_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT NOT NULL,
    station_name VARCHAR(100) NOT NULL,
    timestamp VARCHAR(50) NOT NULL
);

-- Simple Maintenance Logs table
CREATE TABLE maintenance_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT NOT NULL,
    part_name VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    date VARCHAR(20) NOT NULL
);

-- Simple Reports table
CREATE TABLE reports (
    report_id INT AUTO_INCREMENT PRIMARY KEY,
    report_type VARCHAR(50) NOT NULL,
    report_title VARCHAR(200) NOT NULL,
    report_data TEXT
);

-- PTFMS Database with Ottawa Transit Data
-- Updated with more sample data from Ottawa, Canada

-- Extended sample data for Ottawa Public Transit

-- More Users
INSERT INTO users (name, email, password, role) VALUES
('Ahmed Manager', 'manager@ptfms.com', '123', 'Manager'),
('Sara Operator', 'operator@ptfms.com', '123', 'Operator'),
('Jean-Pierre Maintenance', 'maintenance@ptfms.com', '123', 'Maintenance'),
('Emily Johnson', 'emily.operator@ptfms.com', '123', 'Operator'),
('Mike Thompson', 'mike.manager@ptfms.com', '123', 'Manager'),
('Sophie Martin', 'sophie.operator@ptfms.com', '123', 'Operator'),
('David Wilson', 'david.maintenance@ptfms.com', '123', 'Maintenance');

-- More Vehicles (Ottawa OC Transpo style)
INSERT INTO vehicles (vehicle_number, vehicle_type) VALUES
('BUS001', 'Bus'),
('BUS002', 'Bus'),
('BUS003', 'Bus'),
('BUS004', 'Bus'),
('TRAIN001', 'Train'),
('TRAIN002', 'Train'),
('RAIL001', 'Rail'),
('RAIL002', 'Rail'),
('BUS005', 'Bus'),
('BUS006', 'Bus');

-- More Fuel Usage Data
INSERT INTO fuel_usage (vehicle_id, amount, date) VALUES
(1, 45.5, '2025-07-30'),
(2, 120.0, '2025-07-30'),
(3, 42.8, '2025-07-30'),
(4, 38.2, '2025-07-30'),
(5, 180.5, '2025-07-30'),
(6, 175.3, '2025-07-30'),
(7, 95.0, '2025-07-30'),
(8, 88.7, '2025-07-30'),
(1, 48.2, '2025-07-31'),
(2, 125.8, '2025-07-31'),
(3, 44.1, '2025-07-31'),
(4, 39.5, '2025-07-31'),
(9, 41.3, '2025-07-31'),
(10, 43.7, '2025-07-31');

-- Ottawa Transit Stations and Routes
INSERT INTO locations (vehicle_id, station_name, timestamp) VALUES
-- Downtown Ottawa
(1, 'Rideau Centre', '2025-07-30 08:00'),
(1, 'Parliament Hill', '2025-07-30 08:15'),
(1, 'ByWard Market', '2025-07-30 08:30'),
(1, 'University of Ottawa', '2025-07-30 08:45'),

-- Kanata/West End
(2, 'Kanata Town Centre', '2025-07-30 09:00'),
(2, 'Terry Fox Station', '2025-07-30 09:20'),
(2, 'Bayshore Shopping Centre', '2025-07-30 09:40'),

-- Orleans/East End
(3, 'Place d Orleans', '2025-07-30 10:00'),
(3, 'Trim Station', '2025-07-30 10:25'),
(3, 'Jeanne d Arc Station', '2025-07-30 10:45'),

-- Barrhaven/South End
(4, 'Barrhaven Centre', '2025-07-30 11:00'),
(4, 'Fallowfield Station', '2025-07-30 11:20'),
(4, 'Greenboro Station', '2025-07-30 11:40'),

-- LRT Stations (Confederation Line)
(7, 'Tunney Pasture', '2025-07-30 12:00'),
(7, 'Westboro', '2025-07-30 12:05'),
(7, 'Dominion', '2025-07-30 12:08'),
(7, 'Pimisi', '2025-07-30 12:12'),
(7, 'Lyon', '2025-07-30 12:15'),
(7, 'Parliament', '2025-07-30 12:18'),
(7, 'Rideau', '2025-07-30 12:21'),
(7, 'uOttawa', '2025-07-30 12:24'),
(7, 'Lees', '2025-07-30 12:27'),
(7, 'Hurdman', '2025-07-30 12:30'),
(7, 'Tremblay', '2025-07-30 12:33'),
(7, 'St-Laurent', '2025-07-30 12:36'),
(7, 'Cyrville', '2025-07-30 12:39'),
(7, 'Blair', '2025-07-30 12:42'),

-- Trillium Line (Line 2)
(8, 'Bayview', '2025-07-30 13:00'),
(8, 'Carleton', '2025-07-30 13:05'),
(8, 'Carling', '2025-07-30 13:10'),
(8, 'Mooney\'s Bay', '2025-07-30 13:15'),
(8, 'South Keys', '2025-07-30 13:20'),
(8, 'Greenboro', '2025-07-30 13:25'),

-- Gatineau connections
(5, 'Portage du Fort', '2025-07-30 14:00'),
(5, 'Hull Casino', '2025-07-30 14:15'),
(6, 'Gatineau Station', '2025-07-30 14:30'),
(6, 'Promenade du Portage', '2025-07-30 14:45');

-- More Maintenance Logs
INSERT INTO maintenance_logs (vehicle_id, part_name, status, date) VALUES
(1, 'Brakes', 'Scheduled', '2025-08-01'),
(2, 'Engine', 'Completed', '2025-07-25'),
(3, 'Tires', 'In Progress', '2025-07-31'),
(4, 'Air Conditioning', 'Scheduled', '2025-08-03'),
(5, 'Transmission', 'Completed', '2025-07-28'),
(6, 'Electrical System', 'Scheduled', '2025-08-05'),
(7, 'Pantograph', 'Completed', '2025-07-26'),
(8, 'Rail Wheels', 'In Progress', '2025-07-31'),
(1, 'Oil Change', 'Completed', '2025-07-20'),
(2, 'Battery', 'Scheduled', '2025-08-02'),
(9, 'Brakes', 'Overdue', '2025-07-29'),
(10, 'Engine Tune-up', 'Scheduled', '2025-08-04'),
(3, 'Windshield', 'Completed', '2025-07-24'),
(4, 'Suspension', 'In Progress', '2025-07-30'),
(5, 'Fuel System', 'Scheduled', '2025-08-06');

-- More Reports
INSERT INTO reports (report_type, report_title, report_data) VALUES
('Vehicle', 'Fleet Report', 'Total vehicles: 10'),
('Fuel', 'Fuel Usage Report', 'Total consumption: 965.7L'),
('Maintenance', 'Weekly Maintenance Summary', 'Completed: 6, Scheduled: 7, In Progress: 3, Overdue: 1'),
('GPS', 'Route Performance Report', 'On-time performance: 94.2%'),
('Vehicle', 'Ottawa Downtown Routes', 'Coverage: Parliament, ByWard Market, Rideau Centre'),
('Fuel', 'LRT Energy Efficiency', 'Average consumption: 91.85L per day'),
('Maintenance', 'Winter Preparation Report', 'All vehicles ready for Ottawa winter conditions'),
('GPS', 'Confederation Line Status', 'Full service from Tunney\'s Pasture to Blair'),
('Vehicle', 'Suburban Route Coverage', 'Kanata, Orleans, Barrhaven fully covered'),
('Fuel', 'Monthly Fuel Analysis', 'July 2025: 2,847L total consumption'),
('Maintenance', 'Safety Inspection Report', 'All vehicles passed Transport Canada inspection'),
('GPS', 'Cross-River Service', 'Ottawa-Gatineau routes operating normally');