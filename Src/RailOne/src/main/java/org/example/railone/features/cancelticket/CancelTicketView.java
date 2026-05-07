package org.example.railone.features.cancelticket;

import org.example.railone.data.dto.Booking;
import org.example.railone.data.dto.Ticket;
import org.example.railone.util.ValidationUtil;

import java.util.List;
import java.util.Scanner;

/**
 * View class for Cancel Ticket feature
 * Handles user interface for ticket cancellation
 */
public class CancelTicketView {
    private Scanner scanner;

    /**
     * Constructor
     */
    public CancelTicketView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Display cancel ticket menu
     */
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("        CANCEL TICKET");
        System.out.println("========================================");
    }

    /**
     * Get booking ID
     */
    public int getBookingId() {
        while (true) {
            System.out.print("Enter Booking ID: ");
            try {
                int bookingId = Integer.parseInt(scanner.nextLine().trim());
                if (bookingId > 0) {
                    return bookingId;
                }
            } catch (NumberFormatException e) {
                // Invalid input
            }
            System.out.println("❌ Invalid Booking ID. Please try again.");
        }
    }

    /**
     * Display user bookings
     */
    public void displayUserBookings(List<Booking> bookings) {
        if (bookings.isEmpty()) {
            System.out.println("❌ No bookings found.");
            return;
        }

        System.out.println("\nYour Bookings:");
        System.out.println("----------------------------------------");
        int index = 1;
        for (Booking booking : bookings) {
            System.out.printf("%d. Booking ID: %d | Status: %s | Amount: Rs. %.2f\n",
                    index++, booking.getBookingId(), booking.getStatus(),
                    booking.getTotalAmount());
        }
    }

    /**
     * Display booking details
     */
    public void displayBookingDetails(Booking booking, List<Ticket> tickets) {
        System.out.println("\n" + "========================================");
        System.out.println("        BOOKING DETAILS");
        System.out.println("========================================");
        System.out.printf("Booking ID: %d\n", booking.getBookingId());
        System.out.printf("Status: %s\n", booking.getStatus());
        System.out.printf("Journey Date: %s\n", booking.getJourneyDate());
        System.out.printf("Total Amount: Rs. %.2f\n", booking.getTotalAmount());
        System.out.println();

        System.out.println("Passengers:");
        for (Ticket ticket : tickets) {
            System.out.printf("  - %s (Aadhar: %s) | Ticket Status: %s\n",
                    ticket.getPassengerName(), ticket.getPassengerAadhar(),
                    ticket.getStatus());
        }
        System.out.println("========================================");
    }

    /**
     * Confirm cancellation
     */
    public boolean confirmCancellation() {
        System.out.print("\nAre you sure you want to cancel this booking? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    /**
     * Display refund details
     */
    public void displayRefundDetails(double refundAmount, int bookingId) {
        System.out.println("\n" + "========================================");
        System.out.println("        REFUND DETAILS");
        System.out.println("========================================");
        System.out.printf("Booking ID: %d\n", bookingId);
        System.out.printf("Refund Amount: Rs. %.2f (80%% of ticket price)\n", refundAmount);
        System.out.println("Refund will be processed within 7 business days.");
        System.out.println("========================================");
    }

    /**
     * Display success message
     */
    public void displaySuccessMessage(String message) {
        System.out.println("✓ " + message);
    }

    /**
     * Display error message
     */
    public void displayErrorMessage(String message) {
        System.out.println("❌ ERROR: " + message);
    }

    /**
     * Display info message
     */
    public void displayInfoMessage(String message) {
        System.out.println("ℹ INFO: " + message);
    }
}
