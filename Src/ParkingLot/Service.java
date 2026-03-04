package ParkingLot;
import java.util.*;
public class Service {
	Scanner sc=new Scanner(System.in);
	List<Parking>bikeParking=new ArrayList<>();
	List<Parking>carParking=new ArrayList<>();
	public void newParking() {
		System.out.println("1.Two Wheeler");
		System.out.println("2.Four Wheeler");
		int opt=sc.nextInt();
		switch(opt) {
		case 1->{
			twoWheelar();
		}case 2->{
			fourWheelar();
		}
		}
	}public void twoWheelar() {
		Vehicle v=new Bike(getVehicleNumber());
		Parking p=new BikeParking(v);
		if(p.checkAvailability(bikeParking.size())) {
			bikeParking.add(p);
			System.out.println("Vehicle Added SuccessFully");
		}else {
			System.out.println("No Slot Available...");
		}
		System.out.println("-----------------------------------");
	}
	public void fourWheelar() {
		Vehicle v=new Car(getVehicleNumber());
		Parking p=new CarParking(v);
		if(p.checkAvailability(carParking.size())) {
			carParking.add(p);
			System.out.println("Vehicle Added SuccessFully");
		}else {
			System.out.println("No Slot Available...");
		}
		System.out.println("-----------------------------------");
	}public String getVehicleNumber() {

		System.out.println("-----------------------------------");
		sc.nextLine();
		System.out.println("Enter the vehicle Number");
		return sc.nextLine();
	}
	public void showSlots() {
		System.out.println("Choose the Vehicle Type");
		System.out.println("1.Two Wheeler");
		System.out.println("2.Four Wheeler");
		int opt=sc.nextInt();
		System.out.println("-----------------------------------");
		switch(opt) {
		case 1->{
			viewTwoWheeler();
		}case 2->{
			viewFourWheeler();
		}
		}
	}public void viewTwoWheeler(){
		BikeParking.displayAvailability(bikeParking);
	}public void viewFourWheeler(){
		 CarParking.displayAvailability(carParking);
	}
}
