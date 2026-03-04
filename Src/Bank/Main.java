package Bank;
import java.util.*;
public class Main {
	static List<Account>list=new ArrayList<>();
	public static void main(String[] args) {
		list.addAll(Arrays.asList(new Account(1010,"Surya",10000),
				new Account(1011,"Ramya",45000)));
	Scanner sc=new Scanner(System.in);
	BankView view=new BankView();
	int acc=view.getAccNumber();
	Account account=list.stream().filter(a->a.getAccNo()==acc).findFirst().orElse(null);
	if(account==null) {
		view.showMesage("Account not found");
		System.exit(0);
	}
	BankController bc=new BankController(account,view);
	while(true) {
		int choice=view.choice();
		switch(choice) {
		case 1->bc.deposit(view.getAmount());
		case 2->bc.withdraw(view.getAmount());
		case 3->bc.showBalance();
		case 4->bc.showTransaction();
		case 5->System.exit(0);
		}
	}
	}
}
