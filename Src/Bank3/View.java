package Bank3;

public class View {
	
	public void showBalance(User user){
		System.out.println("Your Available balance:"+" "+user.getBalance());
	}
	public void displayMenu() {
		System.out.println("1.Deposit");
		System.out.println("2.Withdraw");
		System.out.println("3.Check Balance");
		System.out.println("4.Exit");
		System.out.println("Enter the operation to perform..");
	}
}
