package org.example.railone.features.report;

import org.example.railone.data.dto.*;
import org.example.railone.data.repository.*;
import java.util.List;

/**
 * Report Generator class
 * Generates various reports for the system
 */
public class ReportGenerator {

    /**
     * Generate booking report
     */
    public void generateBookingReport() {
        System.out.println("\n" + "========================================");
        System.out.println("        BOOKING REPORT");
        System.out.println("========================================");

        List<Booking> bookings = BookingRepository.getAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        int confirmedCount = 0;
        int cancelledCount = 0;
        double totalRevenue = 0;

        for (Booking booking : bookings) {
            if ("Confirmed".equals(booking.getStatus())) {
                confirmedCount++;
                if ("Paid".equals(booking.getPaymentStatus())) {
                    totalRevenue += booking.getTotalAmount();
                }
            } else if ("Cancelled".equals(booking.getStatus())) {
                cancelledCount++;
            }
        }

        System.out.printf("Total Bookings: %d\n", bookings.size());
        System.out.printf("Confirmed Bookings: %d\n", confirmedCount);
        System.out.printf("Cancelled Bookings: %d\n", cancelledCount);
        System.out.printf("Total Revenue: Rs. %.2f\n", totalRevenue);
        System.out.println("========================================");
    }

    /**
     * Generate payment report
     */
    public void generatePaymentReport() {
        System.out.println("\n" + "========================================");
        System.out.println("        PAYMENT REPORT");
        System.out.println("========================================");

        List<Payment> payments = PaymentRepository.getAllPayments();
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        double totalAmount = PaymentRepository.getTotalPaymentAmount();
        int successfulPayments = PaymentRepository.getTotalSuccessfulPayments();

        System.out.printf("Total Payments: %d\n", payments.size());
        System.out.printf("Successful Payments: %d\n", successfulPayments);
        System.out.printf("Total Amount Collected: Rs. %.2f\n", totalAmount);

        // Payment method breakdown
        int creditCard = PaymentRepository.getPaymentCountByMethod("Credit Card");
        int debitCard = PaymentRepository.getPaymentCountByMethod("Debit Card");
        int upi = PaymentRepository.getPaymentCountByMethod("UPI");
        int netBanking = PaymentRepository.getPaymentCountByMethod("Net Banking");

        System.out.println("\nPayment Method Breakdown:");
        System.out.printf("  Credit Card: %d\n", creditCard);
        System.out.printf("  Debit Card: %d\n", debitCard);
        System.out.printf("  UPI: %d\n", upi);
        System.out.printf("  Net Banking: %d\n", netBanking);
        System.out.println("========================================");
    }

    /**
     * Generate train availability report
     */
    public void generateTrainAvailabilityReport() {
        System.out.println("\n" + "========================================");
        System.out.println("        TRAIN AVAILABILITY REPORT");
        System.out.println("========================================");

        List<Train> trains = TrainRepository.getAllTrains();
        if (trains.isEmpty()) {
            System.out.println("No trains found.");
            return;
        }

        for (Train train : trains) {
            double occupancy = ((double) (train.getTotalSeats() - train.getAvailableSeats()) / train.getTotalSeats())
                    * 100;
            System.out.printf("Train: %s (%s)\n", train.getTrainName(), train.getTrainNumber());
            System.out.printf("  Available Seats: %d / %d (%.1f%% occupancy)\n",
                    train.getAvailableSeats(), train.getTotalSeats(), occupancy);
        }
        System.out.println("========================================");
    }

    /**
     * Generate user registration report
     */
    public void generateUserReport() {
        System.out.println("\n" + "========================================");
        System.out.println("        USER REPORT");
        System.out.println("========================================");

        List<User> users = UserRepository.getAllUsers();
        int adminCount = 0;
        int customerCount = 0;

        for (User user : users) {
            if (user.isAdmin()) {
                adminCount++;
            } else {
                customerCount++;
            }
        }

        System.out.printf("Total Users: %d\n", users.size());
        System.out.printf("Admin Users: %d\n", adminCount);
        System.out.printf("Customer Users: %d\n", customerCount);
        System.out.println("========================================");
    }

    /**
     * Generate comprehensive system report
     */
    public void generateSystemReport() {
        System.out.println("\n" + "========================================");
        System.out.println("        SYSTEM REPORT");
        System.out.println("========================================");

        // Booking statistics
        List<Booking> bookings = BookingRepository.getAllBookings();
        int confirmedBookings = (int) bookings.stream().filter(b -> "Confirmed".equals(b.getStatus())).count();

        // User statistics
        int totalUsers = UserRepository.getTotalUsers();

        // Revenue
        double totalRevenue = BookingRepository.getTotalRevenue();

        // Train statistics
        List<Train> trains = TrainRepository.getAllTrains();
        int totalSeats = 0;
        int occupiedSeats = 0;

        for (Train train : trains) {
            totalSeats += train.getTotalSeats();
            occupiedSeats += (train.getTotalSeats() - train.getAvailableSeats());
        }

        System.out.printf("Total Users: %d\n", totalUsers);
        System.out.printf("Total Trains: %d\n", trains.size());
        System.out.printf("Total Bookings: %d\n", bookings.size());
        System.out.printf("Confirmed Bookings: %d\n", confirmedBookings);
        System.out.printf("Total Revenue: Rs. %.2f\n", totalRevenue);
        System.out.printf("Seat Occupancy: %d / %d (%.1f%%)\n",
                occupiedSeats, totalSeats,
                totalSeats > 0 ? ((double) occupiedSeats / totalSeats) * 100 : 0);
        System.out.println("========================================");
    }
}
