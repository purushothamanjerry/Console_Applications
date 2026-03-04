package TaxiBooking;
import java.util.*;
import java.time.*;
public class Service {
	Scanner sc=new Scanner(System.in);
	View v=new View();
	public Taxi newBooking(List<Taxi>taxilist){
		System.out.println("Enter the customer Id:");
		int customer_id=userNumInput();
		System.out.println("Enter the PickUp Point:");
		String pickUP_point=userletterInput();
		System.out.println("Enter the DropUp Point:");
		String dropUP_point=userletterInput();
		System.out.println("Enter the PickUp Time:(HH:MM)");
		String input=userletterInput();
		LocalTime pickUpTime = null;
		try {
			pickUpTime=LocalTime.parse(input);
		}catch (Exception e) {
			System.out.println("Invalid Time");
		}
		int km=calculateKm(pickUP_point,dropUP_point);
		int hour=hourCalculate(km);
		LocalTime dropTime=pickUpTime.plusHours(hour);
		Taxi taxi=checkAvailibility(taxilist, pickUpTime,pickUP_point);
		if(taxi==null) {
			v.noTaxi();
			return null;
		}
		double charge=calculateCharge(taxi.getMinimumCharge(), km);
		Booking b=new Booking(customer_id,pickUP_point,dropUP_point
		,pickUpTime,dropTime,charge);
		taxi.getBooking().add(b);
		taxi.setCurrentLocation(dropUP_point);
		taxi.setLastdropTime(dropTime);
		return taxi;
	}public double calculateCharge(double mincharge , int km){
		double total=5*mincharge;
		km-=5;
		total=total+(km*10);
		return total;
	}
	public int calculateKm(String pick,String drop){
		int km=Math.abs(helperStops(pick)-helperStops(drop));
		return km*15;
	}public int hourCalculate(int km){
		return km/15;
	}public Taxi checkAvailibility(List<Taxi>taxi,LocalTime pickUpTime,String pickupPoint) {
		List<Taxi>available=new ArrayList<>();
		for(Taxi t:taxi) {
		if(t.getLastdropTime().isBefore(pickUpTime)) {
			available.add(t);
		}
		}
		if(available.isEmpty())return null;
		else if(available.size()==1)return available.get(0);
		else {
		return findNearestTaxi(available,pickupPoint);	
		}
	}public Taxi taxiFilter(List<Taxi>taxi) {
		Taxi tax=taxi.get(0);
		for(Taxi t:taxi) {
			tax=tax.getMinimumCharge()<t.getMinimumCharge()?
				tax:t;
		}
		return tax;
	}public Taxi findNearestTaxi(List<Taxi> taxis, String pickupPoint) {

	    Taxi nearestTaxi = null;
	    int minDistance = Integer.MAX_VALUE;

	    int pickupPos = helperStops(pickupPoint);

	    for (Taxi t : taxis) {

	        int taxiPos = helperStops(t.getCurrentLocation());

	        int distance = Math.abs(taxiPos - pickupPos);

	        if (distance < minDistance) {
	            minDistance = distance;
	            nearestTaxi = t;
	        }
	        else if (distance == minDistance) {
	            if (t.getMinimumCharge() < nearestTaxi.getMinimumCharge()) {
	                nearestTaxi = t;
	            }
	        }
	    }

	    return nearestTaxi;
	}

	public int helperStops(String s){
		switch(s) {
		case "A"->{
			return 1;
		}case "B"->{
			return 2;
		}case "C"->{
			return 3;
		}case "D"->{
			return 4;
		}case "E"->{
			return 5;
		}case "F"->{
			return 6;
		}default->{
			return 0;
		}
		}
	}
	public int userNumInput() {
		return sc.nextInt();
	}
	public String userletterInput() {
		return sc.next();
	}
	
}
