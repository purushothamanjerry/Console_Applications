package org.example.railone.features.authentication;

import org.example.railone.data.dto.User;
import org.example.railone.util.ValidationUtil;
import java.util.Scanner;

/**
 * Controller class for Authentication feature
 * Handles interaction between View and Model
 */
public class LoginController {
    private LoginView view;
    private LoginModel model;
    private User currentUser; // Store logged-in user

    /**
     * Constructor
     */
    public LoginController(Scanner scanner) {
        this.view = new LoginView(scanner);
        this.model = new LoginModel();
        this.currentUser = null;
    }

    /**
     * Handle login
     */
    public boolean handleLogin() {
        view.displayLoginMenu();

        String username = view.getUsername();
        String password = view.getPassword();

        if (!ValidationUtil.isNotEmpty(username) || !ValidationUtil.isNotEmpty(password)) {
            view.displayErrorMessage("Username and password cannot be empty.");
            return false;
        }

        User user = model.authenticate(username, password);
        if (user != null) {
            currentUser = user;
            view.displayWelcomeMessage(user.getFirstName() + " " + user.getLastName());
            return true;
        } else {
            view.displayErrorMessage("Invalid username or password.");
            return false;
        }
    }

    /**
     * Handle registration
     */
    public boolean handleRegistration() {
        view.displayRegistrationMenu();

        String firstName = view.getFirstName();
        String lastName = view.getLastName();
        String email = view.getEmail();
        String phoneNumber = view.getPhoneNumber();
        String username = view.getUsername();
        String password = view.getPassword();
        String aadharNumber = view.getAadharNumber();

        // Validate inputs
        if (!ValidationUtil.isValidName(firstName)) {
            view.displayErrorMessage("First name should contain only alphabets.");
            return false;
        }
        if (!ValidationUtil.isValidName(lastName)) {
            view.displayErrorMessage("Last name should contain only alphabets.");
            return false;
        }
        if (!ValidationUtil.isValidEmail(email)) {
            view.displayErrorMessage("Invalid email format.");
            return false;
        }
        if (!ValidationUtil.isValidPhoneNumber(phoneNumber)) {
            view.displayErrorMessage("Phone number should be 10 digits.");
            return false;
        }
        if (!ValidationUtil.isValidUsername(username)) {
            view.displayErrorMessage("Username should be at least 4 characters (alphanumeric).");
            return false;
        }
        if (!ValidationUtil.isValidPassword(password)) {
            view.displayErrorMessage("Password should be at least 6 characters.");
            return false;
        }
        if (!ValidationUtil.isValidAadhar(aadharNumber)) {
            view.displayErrorMessage("Aadhar number should be 12 digits.");
            return false;
        }

        // Check if username or email exists
        if (model.usernameExists(username)) {
            view.displayErrorMessage("Username already exists. Please choose another.");
            return false;
        }
        if (model.emailExists(email)) {
            view.displayErrorMessage("Email already registered. Please use another.");
            return false;
        }

        // Register user
        User newUser = model.registerUser(firstName, lastName, email, phoneNumber,
                username, password, aadharNumber);
        if (newUser != null) {
            view.displaySuccessMessage("Registration successful! You can now login.");
            currentUser = newUser;
            return true;
        } else {
            view.displayErrorMessage("Registration failed. Please try again.");
            return false;
        }
    }

    /**
     * Get current logged-in user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Check if user is logged in
     */
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    /**
     * Check if current user is admin
     */
    public boolean isAdmin() {
        return currentUser != null && currentUser.isAdmin();
    }

    /**
     * Logout current user
     */
    public void logout() {
        currentUser = null;
        view.displayInfoMessage("Logged out successfully.");
    }

    /**
     * Get view object
     */
    public LoginView getView() {
        return view;
    }
}
