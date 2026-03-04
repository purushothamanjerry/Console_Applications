package ParkingLot;

import java.util.*;

public class BikeParking extends Parking{
	final static int bike_Slots=5;
	public BikeParking(Vehicle v){
		super(bike_Slots,v);
	}
	public boolean checkAvailability(int size){
		return size<bike_Slots;
	}
	
	static void displayAvailability(List<Parking> list) {
		int count=1;

		for(Parking p:list) {
			System.out.println("SlotNo:"+count+" "+"Availability:"+"No"+" "+"Vehicle:"+p.v.vehicle_regNo);count++;
		}
	while(count<=bike_Slots) {
		System.out.println("SlotNo:"+count+" "+"Availability:"+"Yes");
		count++;
	}
	}
}
