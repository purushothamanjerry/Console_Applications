package Railway;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Service service=new Service();
		String []s1= {"Erode","Salem","Trichy","Vilupuram","Chennai"};
		String []s2= {"Chennai","Vilupuram","Trichy","Salem","Erode",};
		Train t1=new Train(638004,s1);
		Train t2=new Train(638005,s2);
		List<Train>trains=new ArrayList<>();
		trains.add(t1);
		trains.add(t2);
		View view=new View();
		while(true) {
			view.displayMenu();
			int opt=sc.nextInt();
			switch(opt) {
			case 1->{
				String msg=service.newBooking(trains);
				view.result(msg);
			}case 2->{
				view.checkAvailability(trains);;
			}case 5->{
				System.exit(0);
			}
			}
		}
	}	
}
