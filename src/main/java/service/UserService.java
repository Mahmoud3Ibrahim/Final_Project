package com.ptfms.final_project.service;

import com.ptfms.final_project.dao.UserDAO;
import com.ptfms.final_project.impl.UserDAOImpl;
import com.ptfms.final_project.model.User;

/**
 * User Service - SIMPLE VERSION
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class UserService {
    
    private UserDAO userDAO = new UserDAOImpl();
    
    /**
     * Register new user
     * @param user user to register
     * @return true if successful
     */
    public boolean registerUser(User user) {
        return userDAO.registerUser(user);
    }
    
    /**
     * Login user
     * @param email user email
     * @param password user password
     * @return user object if successful
     */
    public User loginUser(String email, String password) {
        return userDAO.loginUser(email, password);
    }
    
    /**
     * Find user by email
     * @param email user email
     * @return user object
     */
    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }
}