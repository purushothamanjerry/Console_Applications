package org.example.railone.features.admin;

import org.example.railone.data.dto.*;
import org.example.railone.data.repository.*;
import org.example.railone.features.report.ReportGenerator;
import java.util.List;
import java.util.Scanner;

/**
 * Admin Controller class
 * Handles administrative operations
 */
public class AdminController {
    private Scanner scanner;
    private ReportGenerator reportGenerator;

    /**
     * Constructor
     */
    public AdminController(Scanner scanner) {
        this.scanner = scanner;
        this.reportGenerator = new ReportGenerator();
    }

    /**
     * Display admin menu
     */
    public void displayAdminMenu() {
        System.out.println("\n" + "========================================");
        System.out.println("        ADMIN PANEL");
        System.out.println("========================================");
        System.out.println("1. View Booking Report");
        System.out.println("2. View Payment Report");
        System.out.println("3. View Train Availability Report");
        System.out.println("4. View User Report");
        System.out.println("5. View System Report");
        System.out.println("6. View All Users");
        System.out.println("7. View All Bookings");
        System.out.println("8. View All Trains");
        System.out.println("9. Exit Admin Panel");
        System.out.println("========================================");
        System.out.print("Select Option (1-9): ");
    }

    /**
     * Handle admin menu
     */
    public void handleAdminMenu() {
        while (true) {
            displayAdminMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    reportGenerator.generateBookingReport();
                    break;
                case "2":
                    reportGenerator.generatePaymentReport();
                    break;
                case "3":
                    reportGenerator.generateTrainAvailabilityReport();
                    break;
                case "4":
                    reportGenerator.generateUserReport();
                    break;
                case "5":
                    reportGenerator.generateSystemReport();
                    break;
                case "6":
                    viewAllUsers();
                    break;
                case "7":
                    viewAllBookings();
                    break;
                case "8":
                    viewAllTrains();
                    break;
                case "9":
                    System.out.println("\n✓ Exiting Admin Panel...");
                    return;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }

    /**
     * View all users
     */
    private void viewAllUsers() {
        List<User> users = UserRepository.getAllUsers();
        System.out.println("\n" + "========================================");
        System.out.println("        ALL USERS");
        System.out.println("========================================");

        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        for (User user : users) {
            System.out.printf("ID: %d | Name: %s %s | Email: %s | Type: %s\n",
                    user.getUserId(), user.getFirstName(), user.getLastName(),
                    user.getEmail(), user.isAdmin() ? "Admin" : "Customer");
        }
        System.out.println("========================================");
    }

    /**
     * View all bookings
     */
    private void viewAllBookings() {
        List<Booking> bookings = BookingRepository.getAllBookings();
        System.out.println("\n" + "========================================");
        System.out.println("        ALL BOOKINGS");
        System.out.println("========================================");

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking booking : bookings) {
            System.out.printf("ID: %d | User: %d | Train: %d | Status: %s | Amount: Rs. %.2f | Tickets: %d\n",
                    booking.getBookingId(), booking.getUserId(), booking.getTrainId(),
                    booking.getStatus(), booking.getTotalAmount(), booking.getTicketCount());
        }
        System.out.println("========================================");
    }

    /**
     * View all trains
     */
    private void viewAllTrains() {
        List<Train> trains = TrainRepository.getAllTrains();
        System.out.println("\n" + "========================================");
        System.out.println("        ALL TRAINS");
        System.out.println("========================================");

        if (trains.isEmpty()) {
            System.out.println("No trains found.");
            return;
        }

        for (Train train : trains) {
            System.out.printf("%s (%s) | Dep: %s | Arr: %s | Seats: %d/%d | Fare: Rs. %.2f\n",
                    train.getTrainName(), train.getTrainNumber(),
                    train.getDepartureTime(), train.getArrivalTime(),
                    train.getAvailableSeats(), train.getTotalSeats(),
                    train.getBaseFare());
        }
        System.out.println("========================================");
    }
}
