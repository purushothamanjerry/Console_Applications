package Railway2;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		View v=new View();
		Service service=new Service();
		Scanner sc=new Scanner(System.in);
		List<String>stop=new ArrayList<>(Arrays.asList("erode","salem","vilupuram","chennai"));
		List<Train>trains=new ArrayList<>();
		Train t1=new Train(123456,stop);
		Train t2=new Train(654321,stop.reversed());
		trains.add(t1);trains.add(t2);
		while(true) {
			v.showOperations();
			int opt=sc.nextInt();
			switch(opt) {
			case 1->{
				service.booking(trains);
			}case 2->{
				v.showAvailability(trains);
			}case 3->{
				System.exit(0);
			}
			}
		}
	}
}
