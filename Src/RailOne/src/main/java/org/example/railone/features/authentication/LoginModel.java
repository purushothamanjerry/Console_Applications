package org.example.railone.features.authentication;

import org.example.railone.data.dto.User;
import org.example.railone.data.repository.UserRepository;
import org.example.railone.util.ValidationUtil;
import org.example.railone.util.DateUtil;

/**
 * Model class for Authentication feature
 * Contains business logic for login and registration
 */
public class LoginModel {

    /**
     * Authenticate user with username and password
     */
    public User authenticate(String username, String password) {
        if (!ValidationUtil.isNotEmpty(username) || !ValidationUtil.isNotEmpty(password)) {
            return null;
        }

        User user = UserRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    /**
     * Register a new user
     */
    public User registerUser(String firstName, String lastName, String email,
            String phoneNumber, String username, String password,
            String aadharNumber) {
        // Validate input
        if (!ValidationUtil.isValidName(firstName) || !ValidationUtil.isValidName(lastName)) {
            return null;
        }
        if (!ValidationUtil.isValidEmail(email)) {
            return null;
        }
        if (!ValidationUtil.isValidPhoneNumber(phoneNumber)) {
            return null;
        }
        if (!ValidationUtil.isValidUsername(username)) {
            return null;
        }
        if (!ValidationUtil.isValidPassword(password)) {
            return null;
        }
        if (!ValidationUtil.isValidAadhar(aadharNumber)) {
            return null;
        }

        // Check if username or email already exists
        if (UserRepository.usernameExists(username) || UserRepository.emailExists(email)) {
            return null;
        }

        // Create new user
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setAadharNumber(aadharNumber);
        newUser.setAdmin(false);
        newUser.setRegistrationDate(DateUtil.getCurrentDate());

        // Save to repository
        return UserRepository.addUser(newUser);
    }

    /**
     * Check if username exists
     */
    public boolean usernameExists(String username) {
        return UserRepository.usernameExists(username);
    }

    /**
     * Check if email exists
     */
    public boolean emailExists(String email) {
        return UserRepository.emailExists(email);
    }

    /**
     * Get user by username
     */
    public User getUserByUsername(String username) {
        return UserRepository.findByUsername(username);
    }

    /**
     * Get user by email
     */
    public User getUserByEmail(String email) {
        return UserRepository.findByEmail(email);
    }

    /**
     * Get user by ID
     */
    public User getUserById(int userId) {
        return UserRepository.findById(userId);
    }
}
