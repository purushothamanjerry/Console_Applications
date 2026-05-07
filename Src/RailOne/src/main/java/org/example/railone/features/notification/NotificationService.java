package org.example.railone.features.notification;

import org.example.railone.data.dto.Notification;
import org.example.railone.data.repository.BookingRepository;
import org.example.railone.data.dto.Booking;
import org.example.railone.util.DateUtil;

/**
 * Notification Service class
 * Handles sending notifications to users
 */
public class NotificationService {

    /**
     * Send booking confirmation notification
     */
    public void sendBookingConfirmationNotification(int userId, int bookingId, String trainName) {
        System.out.println("\n📧 Sending booking confirmation notification...");
        System.out.printf("✓ Notification sent to User ID: %d\n", userId);
        System.out.printf("  Subject: Booking Confirmed - %s\n", trainName);
        System.out.printf("  Your booking ID: %d\n", bookingId);
    }

    /**
     * Send payment confirmation notification
     */
    public void sendPaymentConfirmationNotification(int userId, int bookingId, double amount, String transactionId) {
        System.out.println("\n📧 Sending payment confirmation notification...");
        System.out.printf("✓ Notification sent to User ID: %d\n", userId);
        System.out.printf("  Subject: Payment Successful\n");
        System.out.printf("  Amount: Rs. %.2f | Transaction ID: %s\n", amount, transactionId);
    }

    /**
     * Send cancellation notification
     */
    public void sendCancellationNotification(int userId, int bookingId, double refundAmount) {
        System.out.println("\n📧 Sending cancellation notification...");
        System.out.printf("✓ Notification sent to User ID: %d\n", userId);
        System.out.printf("  Subject: Ticket Cancelled\n");
        System.out.printf("  Refund Amount: Rs. %.2f\n", refundAmount);
        System.out.printf("  Processing time: 7 business days\n");
    }

    /**
     * Send booking reminder notification
     */
    public void sendBookingReminderNotification(int userId, int bookingId, String journeyDate) {
        System.out.println("\n📧 Sending booking reminder notification...");
        System.out.printf("✓ Notification sent to User ID: %d\n", userId);
        System.out.printf("  Subject: Journey Reminder\n");
        System.out.printf("  Journey Date: %s\n", journeyDate);
    }

    /**
     * Send payment failed notification
     */
    public void sendPaymentFailedNotification(int userId, int bookingId) {
        System.out.println("\n📧 Sending payment failed notification...");
        System.out.printf("✓ Notification sent to User ID: %d\n", userId);
        System.out.printf("  Subject: Payment Failed\n");
        System.out.printf("  Please retry payment for Booking ID: %d\n", bookingId);
    }

    /**
     * Send welcome notification
     */
    public void sendWelcomeNotification(int userId, String userName) {
        System.out.println("\n📧 Sending welcome notification...");
        System.out.printf("✓ Welcome notification sent to User ID: %d\n", userId);
        System.out.printf("  Welcome, %s!\n", userName);
        System.out.printf("  Thank you for registering with RailOne\n");
    }

    /**
     * Send seat availability alert
     */
    public void sendSeatAvailabilityAlert(int userId, String trainName, int availableSeats) {
        System.out.println("\n📧 Sending seat availability alert...");
        System.out.printf("✓ Alert sent to User ID: %d\n", userId);
        System.out.printf("  Train: %s\n", trainName);
        System.out.printf("  Available Seats: %d\n", availableSeats);
    }

    /**
     * Display notification center
     */
    public void displayNotificationCenter(int userId) {
        System.out.println("\n" + "========================================");
        System.out.println("        NOTIFICATION CENTER");
        System.out.println("========================================");
        System.out.println("You have notifications!");
        System.out.println("1. Booking Confirmations");
        System.out.println("2. Payment Updates");
        System.out.println("3. Cancellation Notices");
        System.out.println("4. Journey Reminders");
        System.out.println("5. Alerts");
        System.out.println("========================================");
    }
}
