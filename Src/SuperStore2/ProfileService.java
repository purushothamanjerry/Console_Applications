package SuperStore2;
import java.util.*;
public class ProfileService {
	Scanner sc=new Scanner(System.in);
	private Map<String,User>users=new HashMap<>();
	
	public boolean login(){
		System.out.println("Enter the Username:");
		String name=sc.next();
		System.out.println("Enter the Password");
		String pass=sc.next();
		if(!users.containsKey(name)) {
			System.out.println("User not Found");
			return false;
		}
		User user=users.get(name);
		if(user==null) {
			System.out.println("User not Found");
			return false;}
		if(!user.getPassword().equals(pass)) {
			System.out.println("Credietials Miss Match");
			return false;
		}
		System.out.println("Login SuccessFully");
		return true;
	}public void Register (User user){
		
		if(users.containsKey(user.getName())) {
			System.out.println("UserName alread exists...");
			return;
		}
		users.put(user.getName(),user);
		System.out.println("User Registered SucessFully...");
	}
}
