package Bank3;

public class User {
	
	private long accNo;
	private String name;
	private int pin;
	private double balance;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public User(long accNo, String name, int pin, double balance, String status) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.pin = pin;
		this.balance = balance;
		this.status = status;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
