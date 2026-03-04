package SuperStore;
import java.util.*;

public class Category {
	
	
	public Category() {
		super();
	}

	Scanner sc=new Scanner(System.in);
    private int categoryId;
    private String categoryName;
    private List<Product> products;

    public Category(int categoryId, String categoryName, List<Product> products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.products = products;
    }

    public boolean addCategory(List<Category> list) {
    	
    	System.out.println("Enter category name:");
    	String category=sc.next();

        if (isExist(list, category)) {
            System.out.println("Category already exists");
            return false;
        }

        int id = list.isEmpty() ? 1 : list.get(list.size() - 1).getCategoryId() + 1;
        list.add(new Category(id, category, new ArrayList<>()));
        return true;
    }

    public boolean isExist(List<Category> list, String category) {
        return list.stream()
                .anyMatch(a -> a.getCategoryName().equalsIgnoreCase(category));
    }

    public int getCategoryId() { return categoryId; }
    public String getCategoryName() { return categoryName; }
    public List<Product> getProducts() { return products; }

    public void addProduct(Product product) { products.add(product); }
    public void removeProduct(Product product) { products.remove(product); }

    @Override
    public String toString() {
        return categoryId + " " + categoryName;
    }
}