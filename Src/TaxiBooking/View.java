package TaxiBooking;
import java.util.*;
public class View {
	
	public void displayMenu() {
		System.out.println("1.new booking");
		System.out.println("2.Show TaxiDetails");
		System.out.println("3.Exit");
	}public void failed() {
		System.out.println("Booking Failed");
	}public void noTaxi() {
		System.out.println("No Taxi Available...");
	}public void displayRecord(List<Taxi>taxi){
		for(Taxi t:taxi) {
			System.out.println(t.toString());
			System.out.println("BookingId"+" "+"CustomerId"
			+" "+"From"+" "+"To"+" "+"PickUpTime"+" "+"DropTime"
			+" "+"Amount");
			for(Booking b:t.getBooking()) {
			System.out.println(b.toString());	
			}
		}
	}public void displaySuccess(String name){
		System.out.print(name+"");
		System.out.println("Booking Successfull...");
	}
}
