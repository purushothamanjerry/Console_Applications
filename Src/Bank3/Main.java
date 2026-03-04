package Bank3;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Service service=new Service();
		View view=new View();
		Map<Long,User>users=new HashMap<>();
		users.put((long) 12345678, new User(12345678,"Jerry",1234,250000,"Active"));
		users.put((long)87654321, new User(87654321,"Tom",4321,40000,"Active"));
		User user=service.userLogin(users);
		if(user==null) {
			return;
		}
		while(true) {
			view.displayMenu();
			int opt=sc.nextInt();
			switch(opt) {
			case 1->{
				service.deposite(user);
			}case 2->{
				service.withdraw(user);
			}
			case 3 ->{
				view.showBalance(user);
			}case 4->{
				System.exit(0);
			}
			}
		}

	}

}
