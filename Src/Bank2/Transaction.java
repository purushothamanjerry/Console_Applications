package Bank2;

enum Type{
	DEPOSIT,
	WITHDRAWAL,
	SEND,
	RECIVE
}
public class Transaction {
	private long accId;
	private double amount;
	private Type type;
	
	
	
	public Transaction(long accId, double amount, Type type) {
		super();
		this.accId = accId;
		this.amount = amount;
		this.type = type;
	}
	public long getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}
