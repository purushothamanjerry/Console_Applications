package SuperStore2;
import java.util.*;
public class Main {
	
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		ProfileService ps=new ProfileService();
		Buyer buyer=new Buyer("jerry","jerry123");
		ps.Register(buyer);
		System.out.println(ps.login());
	}

}
