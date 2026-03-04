package SuperStore;
import java.util.*;
public class View {
	
	public void showMenu() {
		System.out.println("------------------------------");
		System.out.println("1.Add Item");
		System.out.println("2.check out");
		System.out.println("3.Show All Item");
		System.out.println("4.Remove Item");
		System.out.println("6.Exit");
		System.out.println("Choose the operations to perform.");
		System.out.println("------------------------------");
	}public void showItem(List<Product>items){
		System.out.println("Product-Id"+" "+"Product-Name"+" "+"Product-Price"+" "+"Quantity"+" "+"Total");
		System.out.println("------------------------------");
		for(Product p:items) {
			System.out.println(p.toString()+" "+p.calculatePrice(p.getQuantity(),p.getPrice()));
		}
	}public void showOption() {
		System.out.println("----------------------");
		System.out.println("Choose the option to perform...");
		System.out.println("1.Sell");
		System.out.println("2.Buy");
		System.out.println("3.Exit");
	}
}
