package org.example.railone.util;

/**
 * Constants class containing application-wide constants
 */
public class Constants {

    // Application Details
    public static final String APP_NAME = "RailOne - Train Ticket Booking System";
    public static final String APP_VERSION = "1.0.0";

    // User Types
    public static final String USER_TYPE_ADMIN = "ADMIN";
    public static final String USER_TYPE_CUSTOMER = "CUSTOMER";

    // Booking Status
    public static final String BOOKING_STATUS_CONFIRMED = "Confirmed";
    public static final String BOOKING_STATUS_CANCELLED = "Cancelled";
    public static final String BOOKING_STATUS_PENDING = "Pending";

    // Payment Status
    public static final String PAYMENT_STATUS_PAID = "Paid";
    public static final String PAYMENT_STATUS_PENDING = "Pending";
    public static final String PAYMENT_STATUS_REFUNDED = "Refunded";

    // Payment Methods
    public static final String PAYMENT_METHOD_CREDIT_CARD = "Credit Card";
    public static final String PAYMENT_METHOD_DEBIT_CARD = "Debit Card";
    public static final String PAYMENT_METHOD_UPI = "UPI";
    public static final String PAYMENT_METHOD_NET_BANKING = "Net Banking";

    // Train Types
    public static final String TRAIN_TYPE_AC = "AC";
    public static final String TRAIN_TYPE_NON_AC = "Non-AC";
    public static final String TRAIN_TYPE_SLEEPER = "Sleeper";
    public static final String TRAIN_TYPE_LOCAL = "Local";
    public static final String TRAIN_TYPE_EXPRESS = "Express";

    // Ticket Status
    public static final String TICKET_STATUS_CONFIRMED = "Confirmed";
    public static final String TICKET_STATUS_CANCELLED = "Cancelled";
    public static final String TICKET_STATUS_PENDING = "Pending";

    // Notification Types
    public static final String NOTIFICATION_TYPE_BOOKING = "Booking";
    public static final String NOTIFICATION_TYPE_PAYMENT = "Payment";
    public static final String NOTIFICATION_TYPE_CANCELLATION = "Cancellation";
    public static final String NOTIFICATION_TYPE_ALERT = "Alert";

    // Notification Status
    public static final String NOTIFICATION_STATUS_SENT = "Sent";
    public static final String NOTIFICATION_STATUS_PENDING = "Pending";
    public static final String NOTIFICATION_STATUS_FAILED = "Failed";

    // Admin Credentials (for testing)
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin123";

    // Application Configuration
    public static final int MIN_PASSENGER_COUNT = 1;
    public static final int MAX_PASSENGER_COUNT = 10;
    public static final int CANCELLATION_REFUND_PERCENTAGE = 80; // 80% refund on cancellation
    public static final int MAX_LOGIN_ATTEMPTS = 3;
    public static final int SESSION_TIMEOUT_MINUTES = 30;

    // Seat Type
    public static final String SEAT_TYPE_AC = "AC";
    public static final String SEAT_TYPE_NON_AC = "Non-AC";
    public static final String SEAT_TYPE_SLEEPER = "Sleeper";

    // Pagination
    public static final int PAGE_SIZE = 10;

    // Error Messages
    public static final String ERROR_INVALID_INPUT = "Invalid input provided.";
    public static final String ERROR_USER_NOT_FOUND = "User not found.";
    public static final String ERROR_BOOKING_NOT_FOUND = "Booking not found.";
    public static final String ERROR_TRAIN_NOT_FOUND = "Train not found.";
    public static final String ERROR_SEAT_NOT_AVAILABLE = "Seat not available.";
    public static final String ERROR_INVALID_CREDENTIALS = "Invalid username or password.";
    public static final String ERROR_USERNAME_EXISTS = "Username already exists.";
    public static final String ERROR_EMAIL_EXISTS = "Email already exists.";
    public static final String ERROR_INSUFFICIENT_SEATS = "Insufficient seats available.";

    // Success Messages
    public static final String SUCCESS_REGISTRATION = "Registration successful!";
    public static final String SUCCESS_LOGIN = "Login successful!";
    public static final String SUCCESS_BOOKING = "Booking confirmed!";
    public static final String SUCCESS_CANCELLATION = "Cancellation successful!";
    public static final String SUCCESS_PAYMENT = "Payment successful!";

    // UI Messages
    public static final String MENU_SEPARATOR = "========================================";
    public static final String DIVIDER = "----------------------------------------";
}
