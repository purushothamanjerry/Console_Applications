package Bank2;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		View view=new View();
		Service service=new Service();
		List<User>users=new ArrayList<>(Arrays.asList(new User("jerry",648021,123,25000)
				,new User("tom",688283,321,2510)));
		User user=service.getUser(users);
		if(user!=null) {
		while(true) {
		view.displayMenu();
		int opt=service.getInt();
		switch(opt) {
		case 1->{
			service.deposit(user);
		}case 2->{
			service.withdraw(user);
		}case 3->{
			User receiver=service.getReceiver(users);
			if(receiver==null || user.getAccNo()==receiver.getAccNo()) {
				System.out.println("Invalid Account");
			}else
			service.transfer(user,receiver);
		}case 4->{
			view.trasactionHistory(user);
		}case 5->{
			view.showBalance(user);
		}
		case 6->{
			System.out.println("Thank You...");
			System.exit(0);
		}
		}
		}
		}
	}

}
