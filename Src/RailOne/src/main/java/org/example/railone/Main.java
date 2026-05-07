package org.example.railone;

import java.util.List;
import java.util.Scanner;

import org.example.railone.data.dto.Booking;
import org.example.railone.data.dto.Payment;
import org.example.railone.data.dto.Station;
import org.example.railone.data.dto.Ticket;
import org.example.railone.data.dto.Train;
import org.example.railone.data.dto.User;
import org.example.railone.features.admin.AdminController;
import org.example.railone.features.authentication.LoginController;
import org.example.railone.features.availabilitycheck.AvailabilityModel;
import org.example.railone.features.availabilitycheck.AvailabilityView;
import org.example.railone.features.booking.BookingModel;
import org.example.railone.features.booking.BookingView;
import org.example.railone.features.cancelticket.CancelTicketModel;
import org.example.railone.features.cancelticket.CancelTicketView;
import org.example.railone.features.notification.NotificationService;
import org.example.railone.features.payment.PaymentModel;
import org.example.railone.features.payment.PaymentView;


public class Main {
    private static Scanner scanner;
    private static LoginController loginController;
    private static NotificationService notificationService;
    private static User currentUser;

    public static void main(String[] args) {
        try {
            scanner = new Scanner(System.in);
            loginController = new LoginController(scanner);
            notificationService = new NotificationService();

            displayApplicationHeader();
            authenticateUser();

            if (currentUser != null) {
                if (currentUser.isAdmin()) {
                    handleAdminMenu();
                } else {
                    handleCustomerMenu();
                }
            }

            System.out.println("\n✓ Thank you for using RailOne! Goodbye!");
        } catch (Exception e) {
            System.out.println("❌ An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void displayApplicationHeader() {
        System.out.println("\n" + "========================================");
        System.out.println("   RAILONE - TRAIN TICKET BOOKING SYSTEM");
        System.out.println("        Version 1.0.0");
        System.out.println("========================================");
    }

    
    private static void authenticateUser() {
        while (currentUser == null) {
            String choice = loginController.getView().promptLoginOrRegister();

            switch (choice) {
                case "1":
                    if (loginController.handleLogin()) {
                        currentUser = loginController.getCurrentUser();
                    }
                    break;
                case "2":
                    if (loginController.handleRegistration()) {
                        currentUser = loginController.getCurrentUser();
                        notificationService.sendWelcomeNotification(
                                currentUser.getUserId(),
                                currentUser.getFirstName() + " " + currentUser.getLastName());
                    }
                    break;
                case "3":
                    System.out.println("\n✓ Thank you for visiting RailOne!");
                    return;
                default:
                    loginController.getView().displayErrorMessage("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Handle customer menu
     */
    private static void handleCustomerMenu() {
        boolean isLoggedIn = true;

        while (isLoggedIn) {
            displayCustomerMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    handleCheckAvailability();
                    break;
                case "2":
                    handleBookTicket();
                    break;
                case "3":
                    handleViewBookingHistory();
                    break;
                case "4":
                    handleCancelTicket();
                    break;
                case "5":
                    handleViewNotifications();
                    break;
                case "6":
                    handleViewProfile();
                    break;
                case "7":
                    isLoggedIn = false;
                    loginController.logout();
                    break;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }

    /**
     * Display customer menu
     */
    private static void displayCustomerMenu() {
        System.out.println("\n" + "========================================");
        System.out.println("        MAIN MENU - CUSTOMER");
        System.out.println("========================================");
        System.out.println("1. Check Train Availability");
        System.out.println("2. Book Ticket");
        System.out.println("3. View Booking History");
        System.out.println("4. Cancel Ticket");
        System.out.println("5. View Notifications");
        System.out.println("6. View Profile");
        System.out.println("7. Logout");
        System.out.println("========================================");
        System.out.print("Select Option (1-7): ");
    }

    /**
     * Handle check availability
     */
    private static void handleCheckAvailability() {
        AvailabilityModel model = new AvailabilityModel();
        AvailabilityView view = new AvailabilityView(scanner);

        view.displayMenu();

        List<Station> stations = model.getAllStations();
        view.displayStations(stations);

        int sourceStationId = view.getSourceStationId(stations);
        if (sourceStationId == -1) {
            view.displayErrorMessage("Invalid source station.");
            return;
        }

        int destinationStationId = view.getDestinationStationId(stations);
        if (destinationStationId == -1) {
            view.displayErrorMessage("Invalid destination station.");
            return;
        }

        int requiredSeats = view.getRequiredSeats();
        if (requiredSeats <= 0 || requiredSeats > 10) {
            view.displayErrorMessage("Invalid number of passengers.");
            return;
        }

        List<Train> availableTrains = model.getAvailableTrains(sourceStationId, destinationStationId, requiredSeats);
        view.displayAvailableTrains(availableTrains);
    }

    /**
     * Handle book ticket
     */
    private static void handleBookTicket() {
        BookingModel bookingModel = new BookingModel();
        BookingView bookingView = new BookingView(scanner);
        PaymentModel paymentModel = new PaymentModel();
        PaymentView paymentView = new PaymentView(scanner);
        AvailabilityModel availabilityModel = new AvailabilityModel();

        bookingView.displayMenu();

        // Step 1: Select train
        List<Station> stations = availabilityModel.getAllStations();
        AvailabilityView availView = new AvailabilityView(scanner);
        availView.displayStations(stations);

        int sourceStationId = availView.getSourceStationId(stations);
        if (sourceStationId == -1) {
            bookingView.displayErrorMessage("Invalid source station.");
            return;
        }

        int destinationStationId = availView.getDestinationStationId(stations);
        if (destinationStationId == -1) {
            bookingView.displayErrorMessage("Invalid destination station.");
            return;
        }

        int numPassengers = bookingView.getNumberOfPassengers();
        String journeyDate = bookingView.getJourneyDate();

        List<Train> availableTrains = availabilityModel.getAvailableTrains(sourceStationId, destinationStationId,
                numPassengers);
        availView.displayAvailableTrains(availableTrains);

        if (availableTrains.isEmpty()) {
            bookingView.displayErrorMessage("No trains available.");
            return;
        }

        int trainIndex = bookingView.selectTrain(availableTrains.size());
        Train selectedTrain = availableTrains.get(trainIndex);

        // Step 2: Create booking
        Booking booking = bookingModel.createBooking(currentUser.getUserId(), selectedTrain.getTrainId(),
                journeyDate, numPassengers);
        if (booking == null) {
            bookingView.displayErrorMessage("Failed to create booking.");
            return;
        }

        // Step 3: Add passengers
        for (int i = 1; i <= numPassengers; i++) {
            bookingView.displayPassengerDetailsHeader(i, numPassengers);
            String passengerName = bookingView.getPassengerName();
            String passengerAadhar = bookingView.getPassengerAadhar();
            String seatType = bookingView.selectSeatType();

            Ticket ticket = bookingModel.addTicketToBooking(
                    booking.getBookingId(),
                    i,
                    passengerName,
                    passengerAadhar,
                    seatType,
                    selectedTrain.getBaseFare());

            if (ticket == null) {
                bookingView.displayErrorMessage("Failed to add ticket for passenger " + i);
                return;
            }
        }

        // Step 4: Confirm booking
        Station sourceStation = bookingModel.getStation(sourceStationId);
        Station destStation = bookingModel.getStation(destinationStationId);
        bookingView.displayBookingSummary(booking, selectedTrain, sourceStation, destStation, booking.getTickets());

        if (!bookingView.confirmBooking()) {
            bookingView.displayInfoMessage("Booking cancelled.");
            return;
        }

        // Step 5: Confirm and update seats
        if (bookingModel.confirmBooking(booking.getBookingId(), selectedTrain.getTrainId())) {
            notificationService.sendBookingConfirmationNotification(
                    currentUser.getUserId(),
                    booking.getBookingId(),
                    selectedTrain.getTrainName());

            // Step 6: Payment
            paymentView.displayMenu();
            paymentView.displayPaymentDetails(booking);
            paymentView.displayPaymentMethods();

            String paymentMethod = paymentView.selectPaymentMethod();

            if (!paymentView.confirmPayment()) {
                bookingView.displayInfoMessage("Payment cancelled.");
                return;
            }

            paymentView.displayProcessingMessage();

            Payment payment = paymentModel.processPayment(
                    booking.getBookingId(),
                    currentUser.getUserId(),
                    booking.getTotalAmount(),
                    paymentMethod);

            if (payment != null && "Success".equals(payment.getStatus())) {
                paymentModel.updateBookingPaymentStatus(booking.getBookingId(), "Paid");
                paymentView.displayPaymentSuccess(payment.getTransactionId(), payment.getAmount());
                notificationService.sendPaymentConfirmationNotification(
                        currentUser.getUserId(),
                        booking.getBookingId(),
                        payment.getAmount(),
                        payment.getTransactionId());
            } else {
                paymentView.displayPaymentFailure();
                notificationService.sendPaymentFailedNotification(currentUser.getUserId(), booking.getBookingId());
            }
        } else {
            bookingView.displayErrorMessage("Failed to confirm booking.");
        }
    }

    /**
     * Handle view booking history
     */
    private static void handleViewBookingHistory() {
        BookingModel bookingModel = new BookingModel();

        List<Booking> userBookings = bookingModel.getUserBookings(currentUser.getUserId());

        System.out.println("\n" + "========================================");
        System.out.println("        BOOKING HISTORY");
        System.out.println("========================================");

        if (userBookings.isEmpty()) {
            System.out.println("❌ No bookings found.");
            return;
        }

        for (Booking booking : userBookings) {
            Train train = bookingModel.getTrainDetails(booking.getTrainId());
            System.out.printf("Booking ID: %d | Train: %s | Date: %s | Status: %s | Amount: Rs. %.2f | Payment: %s\n",
                    booking.getBookingId(),
                    train != null ? train.getTrainName() : "Unknown",
                    booking.getJourneyDate(),
                    booking.getStatus(),
                    booking.getTotalAmount(),
                    booking.getPaymentStatus());
        }
        System.out.println("========================================");
    }

    /**
     * Handle cancel ticket
     */
    private static void handleCancelTicket() {
        CancelTicketModel model = new CancelTicketModel();
        CancelTicketView view = new CancelTicketView(scanner);

        view.displayMenu();

        List<Booking> userBookings = model.getUserBookings(currentUser.getUserId());
        view.displayUserBookings(userBookings);

        int bookingId = view.getBookingId();
        Booking booking = model.getBooking(bookingId);

        if (booking == null) {
            view.displayErrorMessage("Booking not found.");
            return;
        }

        if (!model.canCancelBooking(booking)) {
            view.displayErrorMessage("This booking cannot be cancelled.");
            return;
        }

        List<Ticket> tickets = model.getBookingTickets(bookingId);
        view.displayBookingDetails(booking, tickets);

        if (!view.confirmCancellation()) {
            view.displayInfoMessage("Cancellation cancelled.");
            return;
        }

        if (model.cancelBooking(bookingId, booking.getTrainId())) {
            double refundAmount = model.calculateRefundAmount(booking);
            view.displayRefundDetails(refundAmount, bookingId);
            view.displaySuccessMessage("Booking cancelled successfully!");

            // Send notification
            notificationService.sendCancellationNotification(currentUser.getUserId(), bookingId, refundAmount);
        } else {
            view.displayErrorMessage("Failed to cancel booking.");
        }
    }

    /**
     * Handle view notifications
     */
    private static void handleViewNotifications() {
        notificationService.displayNotificationCenter(currentUser.getUserId());
    }

    /**
     * Handle view profile
     */
    private static void handleViewProfile() {
        System.out.println("\n" + "========================================");
        System.out.println("        USER PROFILE");
        System.out.println("========================================");
        System.out.printf("User ID: %d\n", currentUser.getUserId());
        System.out.printf("Name: %s %s\n", currentUser.getFirstName(), currentUser.getLastName());
        System.out.printf("Email: %s\n", currentUser.getEmail());
        System.out.printf("Phone: %s\n", currentUser.getPhoneNumber());
        System.out.printf("Aadhar: %s\n", currentUser.getAadharNumber());
        System.out.printf("User Type: %s\n", currentUser.isAdmin() ? "Admin" : "Customer");
        System.out.printf("Member Since: %s\n", currentUser.getRegistrationDate());
        System.out.println("========================================");
    }

    /**
     * Handle admin menu
     */
    private static void handleAdminMenu() {
        AdminController adminController = new AdminController(scanner);
        adminController.handleAdminMenu();
    }
}
