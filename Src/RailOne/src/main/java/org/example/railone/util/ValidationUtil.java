package org.example.railone.util;

/**
 * Utility class for validation operations
 * Contains methods for validating user inputs and data
 */
public class ValidationUtil {

    /**
     * Validate email format
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    /**
     * Validate phone number (10 digits for India)
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        return phoneNumber.matches("^[0-9]{10}$");
    }

    /**
     * Validate Aadhar number (12 digits)
     */
    public static boolean isValidAadhar(String aadhar) {
        if (aadhar == null || aadhar.isEmpty()) {
            return false;
        }
        return aadhar.matches("^[0-9]{12}$");
    }

    /**
     * Validate username (minimum 4 characters, alphanumeric)
     */
    public static boolean isValidUsername(String username) {
        if (username == null || username.length() < 4) {
            return false;
        }
        return username.matches("^[a-zA-Z0-9_]{4,}$");
    }

    /**
     * Validate password (minimum 6 characters)
     */
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }
        return true;
    }

    /**
     * Validate name (not empty, alphabets and spaces only)
     */
    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return name.matches("^[a-zA-Z ]+$");
    }

    /**
     * Validate non-empty string
     */
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    /**
     * Validate positive integer
     */
    public static boolean isPositiveInteger(String value) {
        try {
            int num = Integer.parseInt(value);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validate non-negative integer
     */
    public static boolean isNonNegativeInteger(String value) {
        try {
            int num = Integer.parseInt(value);
            return num >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validate positive double
     */
    public static boolean isPositiveDouble(String value) {
        try {
            double num = Double.parseDouble(value);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validate date format (DD-MM-YYYY)
     */
    public static boolean isValidDateFormat(String date) {
        if (date == null || !date.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            return false;
        }
        try {
            String[] parts = date.split("-");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12)
                return false;
            if (day < 1 || day > 31)
                return false;
            if (year < 2024)
                return false;

            // Simple validation - doesn't check leap years
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                return false;
            }
            if (month == 2 && day > 29) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validate seat number (positive integer within range)
     */
    public static boolean isValidSeatNumber(int seatNumber, int totalSeats) {
        return seatNumber > 0 && seatNumber <= totalSeats;
    }

    /**
     * Validate time format (HH:MM)
     */
    public static boolean isValidTimeFormat(String time) {
        if (time == null || !time.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            return false;
        }
        return true;
    }

    /**
     * Parse integer safely
     */
    public static Integer parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Parse double safely
     */
    public static Double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
