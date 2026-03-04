package Railway2;
import java.util.*;
public class View {

    public void showOperations() {
        System.out.println("\n===== Railway Booking System =====");
        System.out.println("1. Ticket Booking");
        System.out.println("2. Check Train");
        System.out.println("3. Cancel Ticket");
        System.out.println("4. Exit");
    }

    public void showBerthPreference() {
        System.out.println("Choose the Berth Preference:");
        System.out.println("1. Upper");
        System.out.println("2. Middle");
        System.out.println("3. Lower");
    }

    public void showAvailability(List<Train> trains) {

        if (trains == null || trains.isEmpty()) {
            System.out.println("No trains available.");
            return;
        }

        System.out.println("Train No\tStops\t\tSeat Status");

        for (Train t : trains) {
            System.out.println(t.getTrainnum() + "\t" + t.getStops() + "\t" + t.getSeat());
        }
    }
}
