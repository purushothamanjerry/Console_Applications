package org.example.railone.features.authentication;

import java.util.Scanner;

/**
 * View class for Authentication feature
 * Handles user interface and input/output for login and registration
 */
public class LoginView {
    private Scanner scanner;

    /**
     * Constructor
     */
    public LoginView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Display login menu
     */
    public void displayLoginMenu() {
        System.out.println("\n========================================");
        System.out.println("        RAILONE - LOGIN");
        System.out.println("========================================");
    }

    /**
     * Display registration menu
     */
    public void displayRegistrationMenu() {
        System.out.println("\n========================================");
        System.out.println("        RAILONE - REGISTRATION");
        System.out.println("========================================");
    }

    /**
     * Get username from user
     */
    public String getUsername() {
        System.out.print("Enter Username: ");
        return scanner.nextLine().trim();
    }

    /**
     * Get password from user
     */
    public String getPassword() {
        System.out.print("Enter Password: ");
        return scanner.nextLine().trim();
    }

    /**
     * Get first name from user
     */
    public String getFirstName() {
        System.out.print("Enter First Name: ");
        return scanner.nextLine().trim();
    }

    /**
     * Get last name from user
     */
    public String getLastName() {
        System.out.print("Enter Last Name: ");
        return scanner.nextLine().trim();
    }

    /**
     * Get email from user
     */
    public String getEmail() {
        System.out.print("Enter Email: ");
        return scanner.nextLine().trim();
    }

    /**
     * Get phone number from user
     */
    public String getPhoneNumber() {
        System.out.print("Enter Phone Number (10 digits): ");
        return scanner.nextLine().trim();
    }

    /**
     * Get Aadhar number from user
     */
    public String getAadharNumber() {
        System.out.print("Enter Aadhar Number (12 digits): ");
        return scanner.nextLine().trim();
    }

    /**
     * Display error message
     */
    public void displayErrorMessage(String message) {
        System.out.println("❌ ERROR: " + message);
    }

    /**
     * Display success message
     */
    public void displaySuccessMessage(String message) {
        System.out.println("✓ SUCCESS: " + message);
    }

    /**
     * Display welcome message
     */
    public void displayWelcomeMessage(String username) {
        System.out.println("\n✓ Welcome, " + username + "!");
    }

    /**
     * Display info message
     */
    public void displayInfoMessage(String message) {
        System.out.println("ℹ INFO: " + message);
    }

    /**
     * Prompt for login or registration
     */
    public String promptLoginOrRegister() {
        System.out.println("\n1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("\nEnter your choice (1-3): ");
        return scanner.nextLine().trim();
    }

    /**
     * Display divider
     */
    public void displayDivider() {
        System.out.println("----------------------------------------");
    }
}
