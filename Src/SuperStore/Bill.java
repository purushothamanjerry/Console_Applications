package SuperStore;
import java.util.*;
public class Bill {
	
	private List<Product>product;
	private double total;
	View v=new View();
	public double calculateTotal(List<Product>product) {
		double sum=0;
		for(Product p:product) {
			sum+=p.calculatePrice( p.getQuantity(),p.getPrice());
		}
		return sum;
	}
	public void designBill(List<Product>product) {
		System.out.println("Kg Super Market");
		System.out.println("______________________");
		v.showItem(product);
		System.out.println("Total Amount:-"+" "+calculateTotal(product));
		System.out.println("Thank You...!");
		System.out.println("_______________________");
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
