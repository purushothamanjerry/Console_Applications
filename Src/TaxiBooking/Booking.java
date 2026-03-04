package TaxiBooking;
import java.time.*;
public class Booking {
	
	private int customerId;
	private String pickPoint;
	private String dropPoint;
	private LocalTime pickUpTime;
	private LocalTime dropTime;
	private double charge;
	
	public Booking(int customerId, String pickPoint, String dropPoint, LocalTime pickUpTime, LocalTime dropTime,
			double charge) {
		super();
		this.customerId = customerId;
		this.pickPoint = pickPoint;
		this.dropPoint = dropPoint;
		this.pickUpTime = pickUpTime;
		this.dropTime = dropTime;
		this.charge = charge;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPickPoint() {
		return pickPoint;
	}
	public void setPickPoint(String pickPoint) {
		this.pickPoint = pickPoint;
	}
	public String getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}
	public LocalTime getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(LocalTime pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public LocalTime getDropTime() {
		return dropTime;
	}
	public void setDropTime(LocalTime dropTime) {
		this.dropTime = dropTime;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	public String toString() {
		return customerId+" "+pickPoint+" "+dropPoint+" "+charge;
	}
}
