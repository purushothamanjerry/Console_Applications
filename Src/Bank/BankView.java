package Bank;
import java.util.*;
public class BankView {
	private Scanner sc=new Scanner(System.in);
		public int choice() {
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Balance");
			System.out.println("4.Transaction History");
			System.out.println("5.Exit");
		return sc.nextInt();
		}
		public double getAmount() {
			System.out.println("Enter Amount");
			return sc.nextDouble();
		}
		public int getAccNumber() {
			System.out.println("Enter the Account Number");
			return sc.nextInt();
		}
		public void showMesage(String msg) {
			System.out.println(msg);
		}
}
