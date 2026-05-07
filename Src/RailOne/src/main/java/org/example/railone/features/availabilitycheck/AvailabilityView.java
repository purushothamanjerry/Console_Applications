package org.example.railone.features.availabilitycheck;

import org.example.railone.data.dto.Train;
import org.example.railone.data.dto.Station;
import java.util.List;
import java.util.Scanner;

/**
 * View class for Availability Check feature
 * Handles user interface and input/output for train search
 */
public class AvailabilityView {
    private Scanner scanner;

    /**
     * Constructor
     */
    public AvailabilityView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Display availability check menu
     */
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("        CHECK TRAIN AVAILABILITY");
        System.out.println("========================================");
    }

    /**
     * Display all available stations
     */
    public void displayStations(List<Station> stations) {
        System.out.println("\nAvailable Stations:");
        System.out.println("----------------------------------------");
        int index = 1;
        for (Station station : stations) {
            System.out.printf("%d. %-15s (Code: %s) - %s, %s\n",
                    index++, station.getStationName(), station.getStationCode(),
                    station.getCity(), station.getState());
        }
    }

    /**
     * Get source station ID
     */
    public int getSourceStationId(List<Station> stations) {
        System.out.print("Enter Source Station Number: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice > 0 && choice <= stations.size()) {
                return stations.get(choice - 1).getStationId();
            }
        } catch (NumberFormatException e) {
            // Invalid input
        }
        return -1;
    }

    /**
     * Get destination station ID
     */
    public int getDestinationStationId(List<Station> stations) {
        System.out.print("Enter Destination Station Number: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice > 0 && choice <= stations.size()) {
                return stations.get(choice - 1).getStationId();
            }
        } catch (NumberFormatException e) {
            // Invalid input
        }
        return -1;
    }

    /**
     * Get required number of seats
     */
    public int getRequiredSeats() {
        System.out.print("Enter Number of Passengers: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Display available trains
     */
    public void displayAvailableTrains(List<Train> trains) {
        if (trains.isEmpty()) {
            System.out.println("\n❌ No trains available for the selected route.");
            return;
        }

        System.out.println("\n" + "========================================");
        System.out.println("        AVAILABLE TRAINS");
        System.out.println("========================================");
        System.out.println();

        int index = 1;
        for (Train train : trains) {
            System.out.printf("%d. Train: %s (%s)\n", index++, train.getTrainName(), train.getTrainNumber());
            System.out.printf("   Departure: %s | Arrival: %s\n", train.getDepartureTime(), train.getArrivalTime());
            System.out.printf("   Type: %-8s | Fare: Rs. %.2f\n", train.getTrainType(), train.getBaseFare());
            System.out.printf("   Available Seats: %d / %d\n", train.getAvailableSeats(), train.getTotalSeats());
            System.out.println("   ----------------------------------------");
        }
    }

    /**
     * Display train details
     */
    public void displayTrainDetails(Train train, Station sourceStation, Station destinationStation) {
        System.out.println("\n" + "========================================");
        System.out.println("        TRAIN DETAILS");
        System.out.println("========================================");
        System.out.printf("Train Name: %s\n", train.getTrainName());
        System.out.printf("Train Number: %s\n", train.getTrainNumber());
        System.out.printf("Train Type: %s\n", train.getTrainType());
        System.out.printf("From: %s (%s)\n", sourceStation.getStationName(), sourceStation.getStationCode());
        System.out.printf("To: %s (%s)\n", destinationStation.getStationName(), destinationStation.getStationCode());
        System.out.printf("Departure: %s | Arrival: %s\n", train.getDepartureTime(), train.getArrivalTime());
        System.out.printf("Base Fare: Rs. %.2f\n", train.getBaseFare());
        System.out.printf("Available Seats: %d / %d\n", train.getAvailableSeats(), train.getTotalSeats());
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
     * Display no trains message
     */
    public void displayNoTrainsMessage() {
        System.out.println("❌ No trains found for the selected route and number of passengers.");
    }
}
