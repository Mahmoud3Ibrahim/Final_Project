package com.ptfms.final_project.dao;

import com.ptfms.final_project.model.User;

/**
 * User DAO Interface - defines user database operations
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public interface UserDAO {
    
    /**
     * Register a new user in the database
     * @param user user to register
     * @return true if successful, false if failed
     */
    boolean registerUser(User user);
    
    /**
     * Login user with email and password
     * @param email user's email
     * @param password user's password
     * @return user object if login successful, null if failed
     */
    User loginUser(String email, String password);
    
    /**
     * Find user by email address
     * @param email user's email
     * @return user object if found, null if not found
     */
    User findUserByEmail(String email);
}