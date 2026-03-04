package Bank2;
import java.util.*;
public class View {
	
	public void displayMenu() {
		System.out.println("1.Deposit");
		System.out.println("2.WithDrawal");
		System.out.println("3.Transfer");
		System.out.println("4.Transaction History");
		System.out.println("5.Check Balance");
		System.out.println("6.Exit...");
		System.out.println("Choose the option");
	}public void showMsg(String msg){
		System.out.println(msg);
	}
	public void trasactionHistory(User user){
	List<Transaction>transaction=user.getTransaction();
	for(Transaction t:transaction) {
		switch(t.getType()) {
		case Type.DEPOSIT->{
			System.out.println("Deposited:"+t.getAmount());

		}case Type.WITHDRAWAL->{
			System.out.println("Atm-WithDrawal:"+t.getAmount());
			
		}case Type.SEND->{
			System.out.println("Receiver Id"+t.getAccId()+" "+"Amount"+t.getAmount());
		}case Type.RECIVE->{
			System.out.println("Sender Id"+t.getAccId()+" "+"Amount"+t.getAmount());
			}
		}
	}
	
	}public void showBalance(User user) {
		System.out.println("Your Available Balance:"+user.getBalance());
	}

}
