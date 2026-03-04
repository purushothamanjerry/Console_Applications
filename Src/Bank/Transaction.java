package Bank;

enum Type{
	Deposit,
	Withdraw,
	Transfer;
}
public class Transaction {
	
	private int sender;
	private int reciver;
	private double amount;
	private Type t;
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReciver() {
		return reciver;
	}
	public void setReciver(int reciver) {
		this.reciver = reciver;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Type getT() {
		return t;
	}
	public void setT(Type t) {
		this.t = t;
	}
	public Transaction(int sender, int reciver, double amount, Type t) {
		this.sender = sender;
		this.reciver = reciver;
		this.amount = amount;
		this.t = t;
	}public Transaction() {
	}
	
	public String toString() {
		return "Type:"+t+
				" "+"From:"+sender+" "+"To:"+reciver+
				" "+"Amount:"+amount;
	}
}
