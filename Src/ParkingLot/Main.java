package ParkingLot;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Service service=new Service();
		while(true) {
			System.out.println("-----------------------------------");
			System.out.println("1.Parking");
			System.out.println("2.Display  slots");
			System.out.println("3.Nearest Available Slots");
			System.out.println("4.Exit");
			System.out.println("Choose the option...");
			int opt=sc.nextInt();

			System.out.println("-----------------------------------");
			switch(opt) {
			case 1->{
				service.newParking();
			}case 2->{
				service.showSlots();
			}case 4->{
				System.out.println("Thank You.!");
				System.exit(0);
			}
			}
		}
	}

}
