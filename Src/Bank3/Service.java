package Bank3;

import java.util.*;

public class Service {
	Scanner sc=new Scanner(System.in);
	View view=new View();
	public User userLogin(Map<Long,User>users){
	System.out.println("Enter Account Number");
	long accNum=sc.nextLong();
	User user=users.get(accNum);
	if(user==null) {
		System.out.println("Account Can't Find....");
	return null;	
	}else if(!user.getStatus().equals("Active")){
		System.out.println("Your Account not active");
		return null;
	}
	int count=0;
	int pin;
	do {
		if(count!=0) {
			System.err.println("Wrong credientials");
			System.err.println("you have only "+(3-count)+" Attempt left");
		}
		System.out.println("Enter the pin");
		pin=sc.nextInt();
		count++;
	}while(pin!=user.getPin() && count<3);
	if(count==3) {
		user.setStatus("Blocked");
		System.out.println("You card Temporary Blocked");
		return null;
	}
	return user;
	}public void deposite(User user){
		System.out.println("Enter the amount :");
		double amt=sc.nextDouble();
		if(amt<1) {
			System.out.println("Invalid Amount");
			return;
		}
		user.setBalance(user.getBalance()+amt);
		System.out.println("Amount deposited Successfully");
		view.showBalance(user);
	}
	public void withdraw(User user) {
		if(!user.getStatus().equals("Active")) {
			System.out.println("You Account not active");
			return;
		}
		System.out.println("Enter the amount");
		double amt=sc.nextDouble();
		if(amt<=0) {
		System.out.println("Invalid Amount");
		return;
		}
		if(user.getBalance()<amt ) {
			System.out.println("Insuficient Balance...");
			return;
		}
		
		user.setBalance(user.getBalance()-amt);
		System.out.println("Amount Withdraw Successfully...");
		view.showBalance(user);
	}

}
