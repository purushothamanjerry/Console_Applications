package Bank;

public class BankController {
	
	private Account account;
	private BankView bankview;
	public BankController() {
	}
	public BankController(Account account,BankView bankview) {
		this.account = account;
		this.bankview=bankview;
	}
	public void deposit(double amount){
		account.deposit(amount);
		account.getTransaction().add(new Transaction(0,account.getAccNo(),amount,Type.Deposit));
		bankview.showMesage("Amount Deposited Successfully");
	}public void withdraw(double amount) {
	try {
		account.withdraw(amount);
		bankview.showMesage("Withdraw Successful");
		account.getTransaction().add(new Transaction(0,account.getAccNo(),amount,Type.Withdraw));
	}catch(Exception e) {
		bankview.showMesage(e.getMessage());
	}
	}
	public void showBalance(){
		bankview.showMesage("Balance:"+account.getBalance());
	}
	public void showTransaction() {
		if(account.getTransaction().isEmpty()) {
			bankview.showMesage("No TransactionFound");
			return;
		}
		for(Transaction t:account.getTransaction()) {
			bankview.showMesage(t.toString());
		}
	}
}
