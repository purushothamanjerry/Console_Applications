package ParkingLot;

import java.util.*;
public abstract class Parking {
	
	static int total_slot;
	Vehicle v;
	abstract boolean checkAvailability(int x);
	public Parking(int slot,Vehicle v){
		 Parking.total_slot=slot;
		 this.v=v;
	}
}
