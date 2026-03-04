package Railway2;
import java.util.*;
public class Service {
	Scanner sc=new Scanner(System.in);
	View view=new View();
	public void booking(List<Train>trains) {
	System.out.println("Enter the name:");
	String name=sc.next();
	System.out.println("Enter the Age:");
	int age=sc.nextInt();
	System.out.println("Enter the Source:");
	String source=sc.next();
	System.out.println("Enter the Destination:");
	String dest=sc.next();
	List<Train>train=checkTrain(trains, source, dest);
	if(train.isEmpty()) {
		System.out.println("Source or Destination Not Found...");
		return;
	}
	view.showAvailability(train);
	System.out.println("Enter the Train Number:");
	int trainum=sc.nextInt();
	Passenger p=new Passenger(name,age,source,dest);
	Train nexttrain = null;
	for(Train t:train) {
		if(t.getTrainnum()==trainum) {
			nexttrain=t;
		}
	}
	if(nexttrain==null) {
		System.out.println("Invalid Train Number");
		return;
	}
	berthpreference(p, nexttrain);
	}public List<Train> checkTrain(List<Train>trains,String source,String dest) {
		List<Train> result = new ArrayList<>();
	    for (Train t : trains) {
	        List<String> stops = t.getStops();
	        int sourceIndex = stops.indexOf(source);
	        int destIndex = stops.indexOf(dest);
	        if (sourceIndex != -1 && destIndex != -1 && sourceIndex < destIndex) {
	            result.add(t);
	        }
	    }
	    return result;
	}public void berthpreference(Passenger p, Train t) {

	    view.showBerthPreference();
	    int opt = sc.nextInt();

	    Seat seat = t.getSeat();

	    boolean booked = false;
    if(opt == 1 && seat.upperAvailable()) {
	        seat.getUpperList().add(p);
	        System.out.println("Ticket Booked: CNF-U " + seat.getUpperList().size());
	        booked = true;
	    }
	    else if(opt == 2 && seat.middleAvailable()) {
	        seat.getMiddleList().add(p);
	        System.out.println("Ticket Booked: CNF-M " + seat.getMiddleList().size());
	        booked = true;
	    }
	    else if(opt == 3 && seat.lowerAvailable()) {
	        seat.getLowerList().add(p);
	        System.out.println("Ticket Booked: CNF-L " + seat.getLowerList().size());
	        booked = true;
	    }
  if(!booked) {
	        if(seat.lowerAvailable()) {
	            seat.getLowerList().add(p);
	            System.out.println("Preferred not available → Booked CNF-L " + seat.getLowerList().size());
	            booked = true;
	        }
	        else if(seat.middleAvailable()) {
	            seat.getMiddleList().add(p);
	            System.out.println("Preferred not available → Booked CNF-M " + seat.getMiddleList().size());
	            booked = true;
	        }
	        else if(seat.upperAvailable()) {
	            seat.getUpperList().add(p);
	            System.out.println("Preferred not available → Booked CNF-U " + seat.getUpperList().size());
	            booked = true;
	        }
	    }
   if(!booked && seat.racAvailable()) {
	        seat.getRacQueue().add(p);
	        System.out.println("RAC Booked: RAC-" + seat.getRacQueue().size());
	        return;
	    }

	    if(!booked && seat.wlAvailable()) {
	        seat.getWaitinglist().add(p);
	        System.out.println("Added to Waiting List: WL-" + seat.getWaitinglist().size());
	        return;
	    }

	    if(!booked) {
	        System.out.println("Booking Failed — No seats available");
	    }
	}
}
