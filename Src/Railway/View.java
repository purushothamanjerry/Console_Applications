package Railway;
import java.util.*;
public class View {
	
	public void result(String msg) {
		if(msg.equals("No train Available")||msg.equals("Invalid Train number")) {
			System.out.println(msg);
			System.out.println("Ticket Booking Failed...");
		}else {	System.out.println("Ticket Booked Successfully:");
			System.out.println("Your Ticket:"+msg);
		}
	}
	
	public void displayMenu() {
		System.out.println("1.Booking");
		System.out.println("2.Check Availabilty");
		System.out.println("3.Cancel Ticket");
		System.out.println("4.prepare Chart");
		System.out.println("5.Exit");
		System.out.println("Enter the option:");
	}
	public void checkAvailability(List<Train> trains) {

	    for (Train t : trains) {

	        System.out.println("\nTrain No: " + t.getNum());

	        Seats seat = t.getSeats();

	        if (seat.getAc().size() < 60) {
	            System.out.print("AC Available: " + (60 - seat.getAc().size()) + " ");
	        } else {
	            if (seat.getAcW().size() < 10) {
	                System.out.print("AC Waiting Available: " + (10 - seat.getAcW().size()) + " ");
	            } else {
	                System.out.print("AC: No Available ");
	            }
	        }

	        if (seat.getNonAc().size() < 60) {
	            System.out.print("Non-AC Available: " + (60 - seat.getNonAc().size()) + " ");
	        } else {
	            if (seat.getNonAcW().size() < 10) {
	                System.out.print("Non-AC Waiting Available: " + (10 - seat.getNonAcW().size()) + " ");
	            } else {
	                System.out.print("Non-AC: No Available ");
	            }
	        }

	        if (seat.getSeater().size() < 60) {
	            System.out.print("Seater Available: " + (60 - seat.getSeater().size()) + " ");
	        } else {
	            if (seat.getSeaterW().size() < 10) {
	                System.out.print("Seater Waiting Available: " + (10 - seat.getSeaterW().size()) + " ");
	            } else {
	                System.out.print("Seater: No Available ");
	            }
	        }

	        System.out.println();
	    }
	}
	public void msg(String msg){
		System.out.println(msg);
	}
	public void seatType() {
		System.out.println("Choose the Seat Type");
		System.out.println("1.Ac");
		System.out.println("2.NonAc");
		System.out.println("3.Seater");
	}

}
