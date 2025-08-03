package com.ptfms.final_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Database Connection Utility Class
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class DBConnection {
    
    private static String DB_URL = "jdbc:mysql://localhost:3306/ptfms_db";
    private static String DB_USERNAME = "cst8288";
    private static String DB_PASSWORD = "cst8288";
    private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    /**
     * Get database connection
     * @return database connection
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found");
        }
    }
    
    
    /**
     * Close database connection
     * @param conn connection to close
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection");
            }
        }
    }
}