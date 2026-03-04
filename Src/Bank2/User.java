package Bank2;
import java.util.*;
public class User {
	private String name;
	private long accNo;
	private int pin;
	private double balance;
	List<Transaction>transaction;
	public User(String name, long accNo, int pin,double amount) {
		super();
		this.name = name;
		this.accNo = accNo;
		this.pin = pin;
		this.balance=amount;
		this.transaction=new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
