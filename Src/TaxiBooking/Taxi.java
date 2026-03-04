package TaxiBooking;
import java.util.*;
import java.time.*;
public class Taxi {
	
	private String name;
	private String currentLocation;
	private LocalTime lastdropTime;
	private double minimumCharge;
	private List<Booking>booking;
	public Taxi(String name, String currentLocation, LocalTime lastdropTime,double charge) {
		super();
		this.name = name;
		this.currentLocation = currentLocation;
		this.lastdropTime = LocalTime.MIN;
		this.booking=new ArrayList<>();
		this.minimumCharge=charge;
	}
	
	public double getMinimumCharge() {
		return minimumCharge;
	}

	public void setMinimumCharge(double minimumCharge) {
		this.minimumCharge = minimumCharge;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public LocalTime getLastdropTime() {
		return lastdropTime;
	}
	public void setLastdropTime(LocalTime lastdropTime) {
		this.lastdropTime = lastdropTime;
	}
	public List<Booking> getBooking() {
		return booking;
	}
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	public String toString(){
		return "Taxi-no:"+name+" "+"Total Earning:"+getAmount();
	}
	public double getAmount() {
	return booking.stream().mapToDouble(Booking::getCharge).sum();
	}
}
