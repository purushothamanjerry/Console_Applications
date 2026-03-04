package Railway;
import java.util.*;
public class Service {
	Scanner sc=new Scanner(System.in);
	View view=new View();
	public String newBooking(List<Train>trains) {
		System.out.println("Enter the name");
		String name=getInput();
		System.out.println("Enter the age");
		int age=getnum();
		System.out.println("Enter the gender");
		String gender=getInput();
		System.out.println("From: ");
		String from=getInput().toLowerCase();
		System.out.println("To:");
		String to=getInput().toLowerCase();
		List<Train>train=filterTrain(trains,from,to);
		if(train.isEmpty()) {
			return "No train Available";
		}
		view.checkAvailability(train);
		view.msg("Enter the trainNum:");
		int trainnum=getnum();
		Train t=checkTrain(train, trainnum);
		if(t==null)return "Invalid Train number";
		Passanger p=new Passanger(name,age,gender,from,to,trainnum);
		return seatbook(t,p);
	}public String seatbook(Train t,Passanger p){
		view.seatType();
		int opt=getnum();
		Seats seat=t.getSeats();
		switch(opt) {
		case 1->{
			if(seat.getAc().size()<60) {
				seat.getAc().add(p);
				return "Ac-cnf"+seat.getAc().size();
			}else if(seat.getAcW().size()<10) {
				seat.getAcW().add(p);
				return "AC-W"+seat.getAcW().size();
			}else {
				return "no";
			}
		}case 2->{
			if(seat.getNonAc().size()<60) {
				seat.getNonAc().add(p);
				return "NA-cnf"+seat.getNonAc().size();
			}else if(seat.getNonAcW().size()<10) {
				seat.getNonAcW().add(p);
				return "NA-W"+seat.getNonAcW().size();
			}else {
				return "no";
			}
		}case 3->{
			if(seat.getSeater().size()<60) {
				seat.getSeater().add(p);
				return "ST-cnf"+seat.getSeater().size();		
			}else if(seat.getSeaterW().size()<10) {
				seat.getSeaterW().add(p);
				return "ST-W"+seat.getSeaterW().size();
			}else {
				return "no";
			}
		}default->{
			return "no";
		}
		}
	}
	public List<Train>filterTrain(List<Train>trains , String from,String to){
		List<Train>train=new ArrayList<>();
		for(Train t:trains) {
			if(checkStop(t,from,to)) {
				train.add(t);
			}
		}
		return train;
	}
	public boolean checkStop(Train train, String from, String to) {
		  List<String> stops = train.getStops();
	    List<String> lowerStops = stops.stream()
                .map(String::toLowerCase)
                .toList();

int f = lowerStops.indexOf(from.toLowerCase());
int e = lowerStops.indexOf(to.toLowerCase());
if (f == -1 || e == -1) {
    return false;
}
return f < e;

	}
	public Train checkTrain(List<Train>train,int num){
	for(Train t:train) {
		if(t.getNum()==num) {
			return t;
		}
	}
	return null;
	}
	public String getInput() {
		return sc.next();
	}public int getnum() {
		return sc.nextInt();
	}

}
