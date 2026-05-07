package org.example.railone.features.booking;

import org.example.railone.data.dto.Booking;
import org.example.railone.data.dto.Ticket;
import org.example.railone.data.dto.Train;
import org.example.railone.data.dto.Station;
import org.example.railone.util.ValidationUtil;

import java.util.List;
import java.util.Scanner;

/**
 * View class for Booking feature
 * Handles user interface for booking tickets
 */
public class BookingView {
    private Scanner scanner;

    /**
     * Constructor
     */
    public BookingView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Display booking menu
     */
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("        BOOK YOUR TICKET");
        System.out.println("========================================");
    }

    /**
     * Get journey date
     */
    public String getJourneyDate() {
        while (true) {
            System.out.print("Enter Journey Date (DD-MM-YYYY): ");
            String date = scanner.nextLine().trim();
            if (ValidationUtil.isValidDateFormat(date)) {
                return date;
            }
            System.out.println("❌ Invalid date format. Please use DD-MM-YYYY.");
        }
    }

    /**
     * Get number of passengers
     */
    public int getNumberOfPassengers() {
        while (true) {
            System.out.print("Enter Number of Passengers (1-10): ");
            try {
                int numPassengers = Integer.parseInt(scanner.nextLine().trim());
                if (numPassengers >= 1 && numPassengers <= 10) {
                    return numPassengers;
                }
                System.out.println("❌ Please enter a number between 1 and 10.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid number.");
            }
        }
    }

    /**
     * Get train selection
     */
    public int selectTrain(int maxTrains) {
        while (true) {
            System.out.print("Select Train (Enter Train Number): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice > 0 && choice <= maxTrains) {
                    return choice - 1;
                }
                System.out.println("❌ Invalid selection. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a valid number.");
            }
        }
    }

    /**
     * Display passenger details form
     */
    public void displayPassengerDetailsHeader(int passengerNumber, int totalPassengers) {
        System.out.println("\n========================================");
        System.out.printf("PASSENGER %d / %d DETAILS\n", passengerNumber, totalPassengers);
        System.out.println("========================================");
    }

    /**
     * Get passenger name
     */
    public String getPassengerName() {
        while (true) {
            System.out.print("Enter Passenger Name: ");
            String name = scanner.nextLine().trim();
            if (ValidationUtil.isValidName(name)) {
                return name;
            }
            System.out.println("❌ Invalid name. Please use alphabets only.");
        }
    }

    /**
     * Get passenger Aadhar
     */
    public String getPassengerAadhar() {
        while (true) {
            System.out.print("Enter Aadhar Number (12 digits): ");
            String aadhar = scanner.nextLine().trim();
            if (ValidationUtil.isValidAadhar(aadhar)) {
                return aadhar;
            }
            System.out.println("❌ Invalid Aadhar. Please enter 12 digits.");
        }
    }

    /**
     * Get seat type selection
     */
    public String selectSeatType() {
        System.out.println("\nSeat Type Options:");
        System.out.println("1. AC");
        System.out.println("2. Non-AC");
        System.out.println("3. Sleeper");
        System.out.print("Select Seat Type (1-3): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 1:
                    return "AC";
                case 2:
                    return "Non-AC";
                case 3:
                    return "Sleeper";
                default:
                    System.out.println("❌ Invalid selection. Defaulting to AC.");
                    return "AC";
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Defaulting to AC.");
            return "AC";
        }
    }

    /**
     * Display booking summary
     */
    public void displayBookingSummary(Booking booking, Train train, Station source,
            Station destination, List<Ticket> tickets) {
        System.out.println("\n" + "========================================");
        System.out.println("        BOOKING CONFIRMATION");
        System.out.println("========================================");
        System.out.printf("Booking ID: %d\n", booking.getBookingId());
        System.out.printf("Train: %s (%s)\n", train.getTrainName(), train.getTrainNumber());
        System.out.printf("From: %s → To: %s\n", source.getStationName(), destination.getStationName());
        System.out.printf("Journey Date: %s\n", booking.getJourneyDate());
        System.out.printf("Departure: %s | Arrival: %s\n", train.getDepartureTime(), train.getArrivalTime());
        System.out.println();

        System.out.println("Passengers:");
        for (Ticket ticket : tickets) {
            System.out.printf("  - %s (Aadhar: %s) | Seat: %d\n",
                    ticket.getPassengerName(), ticket.getPassengerAadhar(),
                    ticket.getSeatNumber());
        }

        System.out.println();
        System.out.printf("Total Amount: Rs. %.2f\n", booking.getTotalAmount());
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

    /**
     * Confirm booking
     */
    public boolean confirmBooking() {
        System.out.print("\nConfirm Booking? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
}
