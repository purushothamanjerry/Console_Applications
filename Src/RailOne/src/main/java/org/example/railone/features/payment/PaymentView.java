package org.example.railone.features.payment;

import org.example.railone.data.dto.Booking;

import java.util.Scanner;

/**
 * View class for Payment feature
 * Handles user interface for payment processing
 */
public class PaymentView {
    private Scanner scanner;

    /**
     * Constructor
     */
    public PaymentView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Display payment menu
     */
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("        PAYMENT");
        System.out.println("========================================");
    }

    /**
     * Display payment details
     */
    public void displayPaymentDetails(Booking booking) {
        System.out.println("\n" + "========================================");
        System.out.println("        BOOKING SUMMARY");
        System.out.println("========================================");
        System.out.printf("Booking ID: %d\n", booking.getBookingId());
        System.out.printf("Total Amount: Rs. %.2f\n", booking.getTotalAmount());
        System.out.printf("Number of Passengers: %d\n", booking.getTicketCount());
        System.out.println("========================================");
    }

    /**
     * Display payment methods
     */
    public void displayPaymentMethods() {
        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. UPI");
        System.out.println("4. Net Banking");
    }

    /**
     * Get payment method selection
     */
    public String selectPaymentMethod() {
        while (true) {
            System.out.print("\nSelect Payment Method (1-4): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        return "Credit Card";
                    case 2:
                        return "Debit Card";
                    case 3:
                        return "UPI";
                    case 4:
                        return "Net Banking";
                    default:
                        System.out.println("❌ Invalid selection. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid number.");
            }
        }
    }

    /**
     * Confirm payment
     */
    public boolean confirmPayment() {
        System.out.print("\nProceed with Payment? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    /**
     * Display payment processing message
     */
    public void displayProcessingMessage() {
        System.out.println("\n⏳ Processing payment...");
    }

    /**
     * Display payment success
     */
    public void displayPaymentSuccess(String transactionId, double amount) {
        System.out.println("\n" + "========================================");
        System.out.println("        PAYMENT SUCCESSFUL");
        System.out.println("========================================");
        System.out.printf("✓ Payment of Rs. %.2f received successfully.\n", amount);
        System.out.printf("Transaction ID: %s\n", transactionId);
        System.out.println("Your booking is now confirmed!");
        System.out.println("========================================");
    }

    /**
     * Display payment failure
     */
    public void displayPaymentFailure() {
        System.out.println("\n========================================");
        System.out.println("❌ PAYMENT FAILED");
        System.out.println("========================================");
        System.out.println("Your payment could not be processed.");
        System.out.println("Please try again with different payment method.");
        System.out.println("========================================");
    }

    /**
     * Display info message
     */
    public void displayInfoMessage(String message) {
        System.out.println("ℹ INFO: " + message);
    }

    /**
     * Display error message
     */
    public void displayErrorMessage(String message) {
        System.out.println("❌ ERROR: " + message);
    }
}
