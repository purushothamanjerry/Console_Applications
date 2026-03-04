package Bank2;
import java.util.*;
public class Service {
	Scanner sc=new Scanner(System.in);
	View view=new View();
	public void deposit(User user){
		System.out.println("Enter the amount:");
		double amt=getDouble();
		double bal=user.getBalance();
		user.setBalance(amt+bal);
		Transaction t=new Transaction(0,amt,Type.DEPOSIT);
		user.getTransaction().add(t);
		System.out.println("Amount Deposited Successfully...");
		view.showBalance(user);
	}public void withdraw(User user){
		System.out.println("Enter the amount");
		double amt=getDouble();
		double bal=user.getBalance();
		if(amt>bal) {
			view.showMsg("Insufficient Balance...");
		}else {
		user.setBalance(bal-amt);
		Transaction t=new Transaction(0,amt,Type.WITHDRAWAL);
		user.getTransaction().add(t);
		view.showMsg("Withdraw Successfully");
		view.showBalance(user);
		}
}	public User getReceiver(List<User>users){
	System.out.println("Enter the accNoo");
	long accNo=sc.nextLong();
	User user=users.stream().filter(a->a.getAccNo()==accNo).findFirst().orElse(null);
	return user;
}
	public void transfer(User user,User receiver){
	System.out.println("Enter the amount:");
	double amt=getDouble();
	double bal=user.getBalance();
	if(amt>bal) {
		view.showMsg("Insufficient Balance...");
	}else {
		double bal2=receiver.getBalance();
		receiver.setBalance(bal2+amt);
		Transaction t2=new Transaction(user.getAccNo(),amt,Type.RECIVE);
		receiver.transaction.add(t2);
		user.setBalance(bal-amt);
		Transaction t1=new Transaction(receiver.getAccNo(),amt,Type.SEND);
		user.transaction.add(t1);
		view.showMsg("Amount Transfered Successfully...");
		view.showBalance(user);
	}
		}
	public User getUser(List<User>users){
		System.out.println("Enter user accNo");
		long acc=sc.nextLong();
		User user=users.stream().filter(a->a.getAccNo()==acc).findFirst().orElse(null);
		if(user==null) {
			view.showMsg("No Account");
		}else {
			System.out.println("Enter pin");
			int pin=sc.nextInt();
			if(user.getPin()!=pin) {
				view.showMsg("Invalid Pin");
			}else {
				return user;
			}
		}return null;
	}
	
	public int getInt(){
		return sc.nextInt();
	}public double getDouble() {
		return sc.nextDouble();
	}

}
