package TaxiBooking;
import java.util.*;
import java.time.*;

public class Main {
	public static void main(String[] args) {
		Service service=new Service();
		View view=new View();

	List<Taxi>taxilist=new ArrayList<>();
	taxilist.add(new Taxi("Taxi-1","A",LocalTime.MIN,100));
	taxilist.add(new Taxi("Taxi-2","A",LocalTime.MIN,100));
	taxilist.add(new Taxi("Taxi-3","A",LocalTime.MIN,100));
	taxilist.add(new Taxi("Taxi-4","A",LocalTime.MIN,100));
	while(true) {
		view.displayMenu();
		int opt=service.userNumInput();
		switch(opt) {
		case 1->{
		Taxi taxi=service.newBooking(taxilist);
			if(taxi==null) {
				view.noTaxi();
				view.failed();
			}else {
				view.displaySuccess(taxi.getName());
			}
		}case 2->{
			view.displayRecord(taxilist);
		}case 3->{
			System.exit(0);
		}
		}
	}
	}
}
