package SuperStore;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		View view=new View();
		Service service=new Service();
		Scanner sc=new Scanner(System.in);
		List<Category>list=new ArrayList<>();
		Product f1=new Product(1,"Apple",280.0,4,1);
		Product f2=new Product(2,"Orange",280.0,4,1);
		Product f3=new Product(3,"Banana",280.0,4,1);
		Product f4=new Product(4,"Guva",280.0,4,1);
		Product V1=new Product(1,"Onion",280.0,4,2);
		Product V2=new Product(2,"Carot",280.0,4,2);
		Product V3=new Product(3,"Cabbage",280.0,4,2);
		Product V4=new Product(4,"Garlic",280.0,4,2);
		List<Product>fruit=new ArrayList<>(Arrays.asList(f1,f2,f3,f4));
		List<Product>Vegitables=new ArrayList<>(Arrays.asList(V1,V2,V3,V4));
		list.add(new Category(1,"Fruits",fruit));
		list.add(new Category(2,"Vegitables",Vegitables));
		while(true) {
		view.showOption();
		int opt=sc.nextInt();
		switch(opt) {
		case 1->{
			service.sellService(list);
		}case 2->{
			service.buyService(list);
		}case 3->{
			System.exit(0);
		}
		default ->{
			System.out.println("Invalid Option");
		}
		}
		}
	}
}
