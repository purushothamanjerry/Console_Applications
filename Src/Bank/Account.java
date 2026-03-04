package Bank;

import java.util.*;

public class Account {
	
	private int accNo;
	private String name;
	private double balance;
	private List<Transaction>transaction;
	public Account(int accNo, String name, double balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
		this.transaction=new ArrayList<>();
	}
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double amount){
		balance+=amount;
	}
	public void withdraw(double amount) {
		 if (balance >= amount)
	            balance -= amount;
	        else
	            throw new RuntimeException("Insufficient balance");
		}
	
}
