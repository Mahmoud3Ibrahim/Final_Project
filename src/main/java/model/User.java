package com.ptfms.final_project.model;

/**
 * User Model Class - represents a user in the system
 * @author Tianxin Gu
 * @author Mahmoud Ibrahim
 */
public class User {
    
    private int userId;
    private String name;
    private String email;
    private String password;
    private String role;
    
    /**
     * Default constructor
     */
    public User() {
    }
    /**
     * Constructor with all parameters
     * @param name user's full name
     * @param email user's email address
     * @param password user's password
     * @param role user's role (Manager, Operator, Maintenance)
     */
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    /**
     * Get user ID
     * @return user ID
     */
    public int getUserId() {
        return userId;
    }
    
    /**
     * Set user ID
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    /**
     * Get user name
     * @return user's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set user name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get user email
     * @return user's email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Set user email
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Get user password
     * @return user's password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Set user password
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Get user role
     * @return user's role
     */
    public String getRole() {
        return role;
    }
    
    /**
     * Set user role
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    /**
     * Convert user object to string
     * @return string representation of user
     */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}