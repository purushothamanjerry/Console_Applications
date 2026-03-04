package ParkingLot;

import java.util.*;
public class CarParking extends Parking{
	final static int car_Slots=5;
	public CarParking(Vehicle v){
		super(car_Slots,v);
	}
	public boolean checkAvailability(int size){
		return size<car_Slots;
	}
	
	static void displayAvailability(List<Parking> list) {
		int count=1;
		for(Parking p:list) {
			System.out.println("SlotNo:"+count+" "+"Availability:"+"No"+" "+"Vehicle:"+p.v.vehicle_regNo);count++;
		}
	while(count<=car_Slots) {
		System.out.println("SlotNo:"+count+" "+"Availability:"+"Yes");
		count++;
	}
	}
}
