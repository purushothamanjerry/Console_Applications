package SuperStore;
import java.util.*;
public class Product {
Scanner sc=new Scanner(System.in);
	private int categoryId;
    public int getCategoryId() {
		return categoryId;
	}

	public Product() {
		super();
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	private int productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productId, String productName, double price, int quantity,int ct) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.categoryId=ct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculatePrice(int quantity,double price) {
        return price * quantity;
    }

    public void updateStock(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough stock available");
        }
    }
    public void newProduct(Category category){
    	System.out.println("Enter the productName:");
    	String name=sc.nextLine();
    	System.out.println("Set the price");
    	double price=sc.nextDouble();
    	System.out.println("Enter the Stock Count");
    	int q=sc.nextInt();
    	int pi=category.getProducts().isEmpty()?1:category.getProducts().get(category.getProducts().size()-1).productId+1;
    	Product p=new Product(pi,name,price,q,category.getCategoryId());
    	 category.getProducts().add(p);
    	 System.out.println("Product Added Successfully...");
    }
    @Override
    public String toString() {
        return productId + " " + productName + " " + price + " " + quantity;
    }
}